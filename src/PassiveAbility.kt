enum class TriggerType { ON_TAKE_DAMAGE, ON_OPPONENT_MISS, ON_LOW_HEALTH }
enum class AffectedStat { DAMAGE, DEFENSE }

class PassiveAbility(
    val name: String,
    val description: String,

    val chance: Int,
    val trigger: TriggerType,
    val activationThreshold: Int,

    val affectedStat: AffectedStat,
    val modifierValue: Int,
) {

    fun checkAndExecute(player: Character, event: TriggerType, opponent: Character) {
        if (event != this.trigger) return

        val roll = (1..100).random()
        if (roll > chance) return

        execute(player, opponent)
    }

    private fun execute(player: Character, opponent: Character) {
        when (this.trigger) {
            TriggerType.ON_TAKE_DAMAGE -> onTakeDamage(player)
            TriggerType.ON_OPPONENT_MISS -> onOpponentMiss(opponent)
            TriggerType.ON_LOW_HEALTH -> onLowHealth(player)
        }
    }

    private fun onTakeDamage(player: Character) {
        when (this.affectedStat) {
            AffectedStat.DEFENSE -> {
                player.increaseDefense(modifierValue)
                println("» [PASSIVA: $name] Defesa aumentada em $modifierValue!")
            }
            else -> return
        }
    }

    private fun onOpponentMiss(opponent: Character) {
        when (this.affectedStat) {
            AffectedStat.DAMAGE -> {
                opponent.takeDamage(modifierValue)
                println("» [PASSIVA: $name] Contra-ataque! \$modifierValue de dano causado no oponente.")
            }
            else -> return
        }
    }

    private fun onLowHealth(player: Character) {
        when (this.affectedStat) {
            AffectedStat.DAMAGE -> {
                if (player.getHp() < activationThreshold) {
                    player.increaseDamage(modifierValue)
                    println("» [PASSIVA: $name] Dano aumentado em $modifierValue!")
                }
            }
            else -> return
        }
    }

    public fun showPassiveAbility() {

        val nameText = "  » Nome: $name"
        val chanceText = "  » Chance: $chance%"
        val triggerText = "  » Gatilho: $trigger"
        val effectText = "  » Efeito: +$modifierValue de $affectedStat"

        val totalWidth = 36
        val maxTextWidth = totalWidth - 4
        val descriptionLines = description.chunked(maxTextWidth)

        if (trigger == TriggerType.ON_LOW_HEALTH) {
            val conditionText = "  » Ativa abaixo de: $activationThreshold HP"
            println("║${conditionText.padEnd(totalWidth)}║")
        }

        for (line in descriptionLines) {
            val formattedLine = "    ${line.trim()}"
            println("║${formattedLine.padEnd(totalWidth)}║")
        }

        println("╔══════════════════════════════════════╗")
        println("║           HABILIDADE PASSIVA         ║")
        println("╠══════════════════════════════════════╣")
        println("║${nameText.padEnd(totalWidth)}║")
        println("║${triggerText.padEnd(totalWidth)}║")
        println("║${chanceText.padEnd(totalWidth)}║")
        println("║${effectText.padEnd(totalWidth)}║")
        println("╠══════════════════════════════════════╣")
        println("║  Descrição:                          ║")
        println("╚══════════════════════════════════════╝")
    }
}