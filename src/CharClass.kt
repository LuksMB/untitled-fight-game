import GameInfo.Companion.clearScreen
import components.PrinterConsoleBox

interface CharClass {
    val className: String
    val resourceName: String
    val description: String
    val baseHp: Double
    val baseDefense: Int
    val baseAccuracy: Int
    val baseResource: Int
    val passive: PassiveAbility
    val charMoveset: List<Ability>

    fun presentClass() {
        clearScreen()
        val attributes = listOf(
            "HP Base                    : $baseHp",
            "Defesa Base                : $baseDefense",
            "Precisão Base              : $baseAccuracy",
            "$resourceName Base         : $baseResource" // Criar regra para cada resourse
        )

        PrinterConsoleBox.printBox(
            title = className,
            attributes = attributes,
            description = description,
            width = 50
        )
    }

    fun abilitiesInfo(selector: Boolean) {
        clearScreen()
        val attributesWithSelection = listOf(
            "1. Jogar como $className",
            "2. Atributos",
            "3. Habilidades",
            "4. Passiva",
            "0. Voltar"
        )

        val attibutesWithoutSelection = listOf(
            "2. Atributos",
            "3. Habilidades",
            "4. Passiva",
            "0. Voltar"
        )

        PrinterConsoleBox.printBox(
            title = className,
            attributes = if (selector) attributesWithSelection else attibutesWithoutSelection,
            description = "",
            width = 50
        )
    }

    fun showAbilitiesClass(selector: Boolean): String {
        abilitiesInfo(selector)
        while (true){
            when (readln()) {
                "1" -> {
                    if (selector) return this.className else println("Opção inválida!")
                }
                "2" -> {
                    presentClass()
                    abilitiesInfo(selector)
                }
                "3" -> {
                    charMoveset.forEach { it.showAbilities() }
                    abilitiesInfo(selector)
                }
                "4" -> {
                    passive.showPassiveAbility()
                    abilitiesInfo(selector)
                }
                "0" -> {
                    break
                }
                else -> println("Opção inválida!")
            }
        }
        return "exit"
    }
}
