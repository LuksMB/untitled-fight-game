package charClasses

import CharClass

class Fighter: CharClass(
    className = "Lutador",
    baseHp = 180,
    baseDefense = 30,
    baseAccuracy = 85,
    baseResource = 100,
    resourceName = "Fúria",
    description = "Combatente resistente especializado em combate corpo a corpo e capaz de absorver muito dano.",
    // passive = ,
    // charMoveset =
) {
}