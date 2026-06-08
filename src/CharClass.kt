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
            "$resourceName Base         : $baseResource"
        )

        PrinterConsoleBox.printBox(
            title = className,
            attributes = attributes,
            description = description,
            width = 50
        )

        println("Pressione ENTER para ver as habilidades")
        readln()

        // Aqui ficam as habilidades

        println("Pressione ENTER para voltar")
        readln()
    }
}
