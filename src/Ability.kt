abstract class Ability(
    val name: String,
    val damage: Int,
    val description: String,
    val cooldown: Int
) {

    public fun execute(player: Character, opponent: Character) {
        if (player.isAlive()) {
            applyDamage(opponent)
            applyCooldown(player)
        }
    }

    private fun applyDamage(opponent: Character) {
        opponent.takeDamage(this.damage)
    }

    private fun applyCooldown(player: Character) {
        player.takeCooldown(this.cooldown + 1)
    }

    public fun showAbilitys() {
        val totalWidth = 34

        println("╔══════════════════════════════════╗")
        println("║             HABILIDADE           ║")
        println("╠══════════════════════════════════╣")

        val nameText = "  [ PERSONAGEM $name ]"
        println("║${nameText.padEnd(totalWidth)}║")
        println("║${"".padEnd(totalWidth)}║")

        val damageText = "  » Dano: $damage"
        println("║${damageText.padEnd(totalWidth)}║")

        val effectText = "  » Efeito: $effect"
        println("║${effectText.padEnd(totalWidth)}║")

        println("║  » Descrição:                    ║")
        println("║${"".padEnd(totalWidth)}║")

        val maxTextWidth = totalWidth - 6

        val descriptionLines = description.chunked(maxTextWidth)

        for (line in descriptionLines) {
            val formattedLine = "      » ${line.trim()}"
            println("║${formattedLine.padEnd(totalWidth)}║")
        }
        println("╚══════════════════════════════════╝")
    }
}