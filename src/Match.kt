import components.PrinterConsoleBox

class Match {

    companion object {

        fun battle(player: Character, opponent: Character, ability: Ability, playerTurn: Boolean = true) {
            if (playerTurn) println("\n Você selecionou a habilidade ${ability.name}")
            else println("\n O inimigo selecionou a habilidade ${ability.name}")
            ability.execute(player, opponent)
        }

        fun showStateGame(player: Character, opponent: Character) {
            val attributes = listOf(
                "Protagonista: ${player.getHp()} HP",
                "${player.getResourceName()}: ${player.getResource()}",
                "",
                "${opponent.name}: ${opponent.getHp()} HP",
                "${opponent.getResourceName()}: ${opponent.getResource()}"
            )

            PrinterConsoleBox.printBox(
                title = "Seu oponente é o ${opponent.name}!",
                attributes = attributes,
                description = "",
                width = 50
            )
        }

        fun showActions(player: Character): String {
            val attributes: List<String> =
                player.charClass.charMoveset.mapIndexed { index, ability ->
                    "${index + 1}. ${ability.name}"
                }

            PrinterConsoleBox.printBox(
                title = "Habilidades",
                attributes = attributes,
                description = "",
                width = 50
            )
            print("\n➜ Escolha sua ação:")
            return readln()
        }

        fun matchMenu(player: Character, opponent: Character): Boolean {
            while (true) {
                showStateGame(player, opponent)
                val action = showActions(player).toIntOrNull()?.minus(1)

                if (action != null && action in player.charClass.charMoveset.indices) {
                    val chosenAbility = player.charClass.charMoveset[action]
                    battle(player, opponent, chosenAbility)
                    if (opponent.getHp() == 0.0) {
                        println("Oponente está morto! Parabéns!")
                        return true
                    }
                }else
                {
                    println("\nOpção inválida! Escolha uma habilidade válida.")
                    continue
                }

                println("\nTurno do oponente...")
                val actionOpponent = (0..2).random()

                val chosenAbility = opponent.charClass.charMoveset[actionOpponent]
                battle(opponent, player, chosenAbility, false)
                if (player.getHp() == 0.0) {
                    println("Você perdeu uma vida. Sinto muito...")
                    return false
                }
            }
        }
    }
}