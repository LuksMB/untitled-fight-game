fun main() {
        while (true) {
            GameInfo.showMenu()
            when (readln()) {
                "1" -> Game.start()
                "2" -> GameInfo.classesInfoMenu()
                "3" -> GameInfo.showCredits()
                "0" -> {
                    println("Até logo!")
                    break
                }
                else -> println("Opção inválida!")
            }
        }
}
