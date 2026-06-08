import GameInfo.Companion.clearScreen
import components.PrinterConsoleBox

abstract class CharClass(
    val className: String,
    val resourceName: String,
    val description: String,
    val baseHp: Double,
    val baseDefense: Int,
    val baseAccuracy: Int,
    val baseResource: Int,
    val passive: PassiveAbility,
    val charMoveset: List<Ability>
) {

    fun presentClass() {
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

    fun AbilitiesInfo() {
        println("\n╔══════════════════════════════════╗")
        println("║  1. Ver atributos                ║")
        println("║  2. Ver habilidades              ║")
        println("║  3. Ver passiva                  ║")
        println("║  0. Voltar                       ║")
        println("╚══════════════════════════════════╝")
        print("\n➜ Escolha uma opção:")
    }

    fun showAbilitiesClass() {
        AbilitiesInfo()
        while (true){
            when (readln()) {
                "1" -> {
                    presentClass()
                    AbilitiesInfo()
                }
                "2" -> {
                    clearScreen()
                    charMoveset.forEach { it.showAbilities() }
                    AbilitiesInfo()
                }
                "3" -> {
                    clearScreen()
                    passive.showPassiveAbility()
                    AbilitiesInfo()
                }
                "0" -> {
                    break
                }
                else -> println("Opção inválida!")
            }
        }
    }
}
