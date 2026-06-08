package charClasses

import Ability
import CharClass
import PassiveAbility
import enum.TriggerType
import enum.AffectedStat

class Ranger: CharClass(
    className = "Atirador",
    baseHp = 120,
    baseDefense = 15,
    baseAccuracy = 90,
    baseResource = 6,
    resourceName = "Balas",
    description = "Agente persistente, ágil em combates longos e capaz de entregar dano de forma constante enquanto se esquiva.",
    passive = PassiveAbility(
        "Contra-Ataque",
        "Ao esquivar com sucesso de um ataque, o atirador usa a oportunidade para jogar um cartucho vazio como um ataque simples e rápido, sem gastar balas.",
        TriggerType.ON_OPPONENT_MISS,
        0,
        AffectedStat.NONE,
        10
    ),
    charMoveset = listOf(
        Ability(
            "Tiro Rápido",
            10,
            1,
            "Um tiro simples com seu révolver, conte bem as balas..."),
        Ability(
            "Tiros Consecutivos",
            25,
            3,
            "Não é muito preciso, mas serve pra assustar."
        ),
        Ability(
            "Recarregar",
            10,
            0,
            "Rebola o tambor vazio no inimigo e recarrega as balas, para tudo se tem uma utilidade."

        )
    )
) {

}