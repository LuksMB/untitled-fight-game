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
                    val realDamage = this.damage + ((1 + modPassive) * this.damage) - (opponent.getDefense()/100.0 * damage)
                    applyDamage(opponent, realDamage)
                    println($$"» [$$name] DANO CRÍTICO! $$realDamage de dano causado ao $${opponent.name}.")
                }
                in hitInterval -> {
                    val realDamage = this.damage + (this.damage * modPassive) - (opponent.getDefense()/100.0 * damage)
                    applyDamage(opponent, realDamage)
                    println($$"» [$$name] $$realDamage de dano causado ao $${opponent.name}.")
                }
                else -> println("O ${opponent.name} se esquivou, concentre-se, ${player.name}!")
            }
        } else {
            println("O ataque falhou, você está sem $typeOfResource.")
        }
    }

    private fun applyDamage(opponent: Character, damageModified: Double) {
        opponent.takeDamage(damageModified)
    }

    private fun chargePlayer(player: Character) {
        if (this.cost < 0) player.gainResource(cost * -1) else player.useResource(this.cost)
    }

    fun showAbilities() {
        val attributes = listOf(
            "Dano              : $damage",
            "Custo             : $cost",
        )

        PrinterConsoleBox.printBox(
            title = name,
            attributes = attributes,
            description = description,
            width = 50
        )
    }
}