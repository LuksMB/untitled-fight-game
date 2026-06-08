package components

object PrinterConsoleBox {

    fun printBox(
        title: String,
        attributes: List<String>,
        description: String,
        width: Int = 40
    ) {
        val contentWidth = width - 4

        println("╔${"═".repeat(width - 2)}╗")
        println("║ ${centerText(title, contentWidth)} ║")
        println("╠${"═".repeat(width - 2)}╣")

        for (attr in attributes) {
            println("║ ${attr.padEnd(contentWidth)} ║")
        }

        if (description.isNotEmpty()) {
            println("╠${"═".repeat(width - 2)}╣")
            println("║ ${"Descrição:".padEnd(contentWidth)} ║")

            val descLines = wrapText(description, contentWidth)
            for (line in descLines) {
                println("║ ${line.padEnd(contentWidth)} ║")
            }
        }

        println("╚${"═".repeat(width - 2)}╝")
    }

    private fun centerText(text: String, maxLength: Int): String {
        val spaces = (maxLength - text.length).coerceAtLeast(0)
        val left = spaces / 2
        val right = spaces - left
        return " ".repeat(left) + text + " ".repeat(right)
    }

    private fun wrapText(text: String, maxLength: Int): List<String> {
        val words = text.split(" ")
        val lines = mutableListOf<String>()
        var current = ""

        for (word in words) {
            if (("$current $word").trim().length <= maxLength) {
                current = ("$current $word").trim()
            } else {
                if (current.isNotEmpty()) lines.add(current)
                current = word
            }
        }
        if (current.isNotEmpty()) lines.add(current)
        return lines
    }
}