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
        val width = 50

        fun line(text: String = "") {
            println("║ ${text.padEnd(width - 4)} ║")
        }

        fun separator() {
            println("╠${"═".repeat(width - 2)}╣")
        }

        fun center(text: String): String {
            val spaces = ((width - 4) - text.length).coerceAtLeast(0)
            val left = spaces / 2
            val right = spaces - left
            return " ".repeat(left) + text + "".repeat(right)
        }

        fun wrap(text: String, maxLength: Int): List<String> {
            val words = text.split(" ")
            val lines = mutableListOf<String>()
            var current = ""

            for (word in words) {
                if (("$current $word").trim().length <= maxLength) {
                    current = ("$current $word").trim()
                } else {
                    if (current.isNotEmpty()) {
                        lines.add(current)
                    }
                    current = word
                }
            }

            if (current.isNotEmpty()) {
                lines.add(current)
            }

            return lines
        }

        println("╔${"═".repeat(width - 2)}╗")
        line(center(className))
        separator()

        line("HP Base       : $baseHp")
        line("Defesa Base   : $baseDefense")
        line("Precisão Base : $baseAccuracy")
        line("$resourceName Base : $baseResource")

        separator()

        line("Descrição:")
        wrap(description, width - 6).forEach {
            line(it)
        }

        println("╚${"═".repeat(width - 2)}╝")
        println("Pressione ENTER para voltar")
        readln()
    }
}
