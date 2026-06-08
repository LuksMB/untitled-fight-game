import enum.AffectedStat
import enum.TriggerType
import components.PrinterConsoleBox

class PassiveAbility(
    val name: String,
    val description: String,
    val trigger: TriggerType,
    val activationThreshold: Int,
    val affectedStat: AffectedStat,
    val modifierValue: Int,
) {

    fun checkAndExecute(player: Character, opponent: Character) {
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
                player.useResource(5)
                println("» [PASSIVA: $name] Defesa aumentada em $modifierValue! e mana reduzida em 5")
            }
            else -> return
        }
    }

    private fun onOpponentMiss(opponent: Character) {
        when (this.affectedStat) {
            AffectedStat.NONE -> {
                opponent.takeDamage(modifierValue + 0.0)
                println($$"» [PASSIVA: $$name] $modifierValue de dano causado ao oponente.")
            }
            else -> return
        }
    }

    private fun onLowHealth(player: Character) {
        when (this.affectedStat) {
            AffectedStat.DAMAGE -> {
                val actualHp = player.getHp()
                if (actualHp < activationThreshold && !player.getPassiveStatus()) {
                    player.activatePassive()
                    println("» [PASSIVA: $name] Dano aumentado em $modifierValue% !")
                } else if (actualHp >= activationThreshold) {
                    player.deactivatePassive()
                    println("» [PASSIVA: $name] O sangue esfriou, sua força volta ao normal...")
                }
            }
            else -> return
        }
    }

    fun showPassiveAbility() {
        val attributes = mutableListOf(
            "» Gatilho: $trigger",
            "» Efeito  : +$modifierValue de $affectedStat"
        )

        PrinterConsoleBox.printBox(
            title = "HABILIDADE PASSIVA: $name",
            attributes = attributes,
            description = description,
            width = 44
        )
    }
}