fun main() {
    val menu = Menu()
        while (true) {
            menu.showMenu()
            when (readln()) {
                "1" -> println("Iniciando jogo...")
                "2" -> println("Personagens")
                "3" -> println("Créditos")
                "0" -> {
                    println("Até logo!")
                    break
                }
                else -> println("Opção inválida!")
            }
        }
}
