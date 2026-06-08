import components.PrinterConsoleBox

abstract class CharClass(
    val className: String,
    val resourceName: String,
    val description: String,
    val baseHp: Int,
    val baseDefense: Int,
    val baseAccuracy: Int,
    val baseResource: Int,
    // val passive: PassiveAbility,
    // val charMoveset: CharMoveset
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

        println("Pressione ENTER para voltar")
        readln()
    }
}
