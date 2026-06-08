package charClasses

import CharClass

class Ranger: CharClass(
    className = "Atirador",
    baseHp = 120,
    baseDefense = 15,
    baseAccuracy = 90,
    baseResource = 6,
    resourceName = "Balas",
    description = "Agente persistente, ágil em combates longos e capaz de entregar dano de forma constante enquanto se esquiva."
) {
}