package charClasses

import CharClass
import PassiveAbility
import enum.AffectedStat
import enum.TriggerType

class Mage: CharClass(
    className = "Mago",
    baseHp = 90,
    baseDefense = 10,
    baseAccuracy = 75,
    baseResource = 150,
    resourceName = "Mana",
    description = "Sábio e poderoso, esse especialista em magias ofensivas é a escolha certa para causar muito dano de uma só vez.",
    passive = PassiveAbility(
        "Armadura de Mana",
        "Ao receber dano, parte da mana do mago é convertida em uma nova camada de defesa contra os próximos ataques.",
        TriggerType.ON_TAKE_DAMAGE,
        0,
        AffectedStat.DEFENSE,
        2
    ),
    charMoveset =
) {
}