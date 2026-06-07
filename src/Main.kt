fun main() {
    val menu = Menu()
    val credits = Credits()
        while (true) {
            menu.showMenu()
            when (readln()) {
                "1" -> println("Iniciando jogo...")
                "2" -> println("Personagens")
                "3" -> credits.showCredits()
                "0" -> {
                    println("Até logo!")
                    break
                }
                else -> println("Opção inválida!")
            }
        }
}
