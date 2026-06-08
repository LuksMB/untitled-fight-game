import components.PrinterConsoleBox

class Ability(
    val name: String,
    val damage: Int,
    val cost: Int,
    val description: String,
) {

    fun execute(player: Character, opponent: Character) {
        val typeOfResource = player.getResourceName()
        val modPassive = if (player.getPassiveStatus()) 0.5 else 0.0
        if (player.getResource() >= this.cost) {
            chargePlayer(player)

            val accuracy = player.getAccuracy()
            val critInterval = 95..100
            val hitInterval = (101 - accuracy)..94
            val rollDice = (1..100).random()

            when (rollDice) {
                in critInterval -> {
                    applyDamage(opponent, 1 + modPassive)
                    println($$"» [$$name] DANO CRÍTICO! $$damage de dano causado ao oponente.")
                }
                in hitInterval -> {
                    applyDamage(opponent, modPassive)
                    println($$"» [$$name] $$damage de dano causado ao oponente.")
                }
                else -> println("Você errou o ataque, concentre-se!")
            }
        } else {
            println("O ataque falhou, você está sem $typeOfResource.")
        }
    }

    private fun applyDamage(opponent: Character, modifier: Double = 0.0) {
        opponent.takeDamage(this.damage + (modifier * this.damage))
    }

    private fun chargePlayer(player: Character) {
        if (this.cost < 0) player.gainResource(cost * -1) else player.useResource(this.cost)
    }

    fun showAbilities() {
        val attributes = listOf(
            "Nome         : $name",
            "Dano         : $damage",
            "Custo        : $cost",
        )

        PrinterConsoleBox.printBox(
            title = "HABILIDADE",
            attributes = attributes,
            description = description,
            width = 34
        )

        println("Pressione ENTER para voltar")
        readln()
    }
}