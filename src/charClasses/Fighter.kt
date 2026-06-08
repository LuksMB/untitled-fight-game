package charClasses

import Ability
import CharClass
import PassiveAbility
import enum.AffectedStat
import enum.TriggerType

class Fighter: CharClass(
    className = "Lutador",
    baseHp = 180.0,
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
    charMoveset = listOf(
        Ability(
            "Pancadão",
            10,
            -15,
            "Um soco simples, direto, que cumpre sua função."),
        Ability(
            "Chute Giratório",
            20,
            -5,
            "Com um ritmo acelerado, desfere um chute com a energia de uma rotação inteira do próprio corpo."
        ),
        Ability(
            "Descarregar Fúria",
            40,
            100,
            "Com o sangue fervendo, o lutador vai executar todo o combo que ele conhece no inimigo."

        )
    )
)