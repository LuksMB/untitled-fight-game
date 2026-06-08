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
        println("\n╔══════════════════════════════════╗")
        if (selector) println("║  1. Selecionar                   ║")
        println("║  2. Ver atributos                ║")
        println("║  3. Ver habilidades              ║")
        println("║  4. Ver passiva                  ║")
        println("║  0. Voltar                       ║")
        println("╚══════════════════════════════════╝")
        print("\n➜ Escolha uma opção:")
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
