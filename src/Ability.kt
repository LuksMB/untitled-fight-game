import components.PrinterConsoleBox

class Ability(
    val name: String,
    val damage: Int,
    val cost: Int,
    val description: String,
) {

    fun execute(player: Character, opponent: Character) {
        if (player.isAlive()) {
            chargePlayer(player)
            applyDamage(opponent)
        }
    }

    private fun applyDamage(opponent: Character) {
        opponent.takeDamage(this.damage)
    }

    private fun chargePlayer(player: Character) {
        player.useResource(this.cost)
    }

    public fun showAbilitys() {
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