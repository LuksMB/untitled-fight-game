import components.PrinterConsoleBox

class Match {

    companion object {

        fun battle(player: Character, opponent: Character, ability: Ability) {
            println("\n Você selecionou a habilidade ${ability.name}")
            ability.execute(player, opponent)
        }

        fun showOpponent(opponent: Character) {
            val attributes = listOf(
                "HP         : ${opponent.getHp()}",
            )

            PrinterConsoleBox.printBox(
                title = "Seu oponente é um ${opponent.name}!",
                attributes = attributes,
                description = "",
                width = 50
            )
            println("➜ Precione ENTER para continuar:")
            readln()
        }

        fun showActions(player: Character): String {
            val attributes: List<String> =
                player.charClass.charMoveset.mapIndexed { index, ability ->
                    "${index + 1}. ${ability.name}"
                }

            val menuComplete = attributes + listOf("0. Voltar")

            PrinterConsoleBox.printBox(
                title = "Você é um ${player.name}",
                attributes = menuComplete,
                description = "",
                width = 50
            )
            print("\n➜ Escolha sua ação:")
            return readln()
        }

        fun matchMenu(player: Character, opponent: Character) {
            showOpponent(opponent)

            while (true) {
                val action = showActions(player).toIntOrNull()?.minus(1)

                if (action != null && action in player.charClass.charMoveset.indices) {
                    val chosenAbility = player.charClass.charMoveset[action]
                    battle(player, opponent, chosenAbility)
                    if (!opponent.isAlive()) {
                        println("Oponente está morto! Parabéns!")
                        break
                    }
                }else
                {
                    println("\nOpção inválida! Escolha uma habilidade válida.")
                    continue
                }

                println("\nTurno do oponente...")
                val actionOpponent = (0..2).random()

                val chosenAbility = opponent.charClass.charMoveset[actionOpponent]
                battle(opponent, player, chosenAbility)
                if (!player.isAlive()) {
                    println("Você perdeu uma vida. Sinto muito...")
                    break
                }
            }
        }
    }
}