import GameInfo.Companion.clearScreen

fun main() {
        while (true) {
            GameInfo.showMenu()
            when (readln()) {
                "1" -> {
                    val player = GameInfo.classesInfoMenu(true)
                    val game = Game(player)
                    game.start()
                }
                "2" -> GameInfo.classesInfoMenu(false)
                "3" -> GameInfo.showCredits()
                "0" -> {
                    println("Até logo!")
                    break
                }
                else -> println("Opção inválida!")
            }
        }
}
