package charClasses

import CharClass
import PassiveAbility
import enum.AffectedStat
import enum.TriggerType

class Fighter: CharClass(
    className = "Lutador",
    baseHp = 180,
    baseDefense = 30,
    baseAccuracy = 85,
    baseResource = 100,
    resourceName = "Fúria",
    description = "Combatente resistente especializado em combate corpo a corpo e capaz de absorver muito dano.",
    passive = PassiveAbility(
        "Sangue Nuzói",
        "O lutador já apanhou muito, agora é a vez dele! Cada golpe desferido será 50% mais forte.",
        TriggerType.ON_LOW_HEALTH,
        63,
        AffectedStat.DAMAGE,
        50
    ),
    charMoveset =
) {
}