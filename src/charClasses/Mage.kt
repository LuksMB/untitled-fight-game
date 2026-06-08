package charClasses

import Ability
import CharClass
import PassiveAbility
import enum.AffectedStat
import enum.TriggerType

class Mage: CharClass(
    className = "Mago",
    baseHp = 90.0,
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
    charMoveset = listOf(
        Ability(
            "Bola de Fogo",
            30,
            50,
            "Conjura uma bola de fogo imensa em direção ao oponente."),
        Ability(
            "Relâmpago",
            40,
            100,
            "Controlando as nuvens no céu, o mago provoca um raio logo acima do seu oponente."
        ),
        Ability(
            "Canalizar Mana",
            10,
            -60,
            "O mago fecha os olhos e se concentra, buscando mais mana nos seus arredores para reabastecer sua capacidade mágica."

        )
    )
)