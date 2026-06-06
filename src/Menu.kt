class Menu {
    fun clearScreen() {
        print("\u001b[H\u001b[2J")
        System.out.flush()
    }

    fun showMenu() {
        clearScreen()

        println("╔══════════════════════════════════╗")
        println("║      Untitled Fight Game         ║")
        println("╠══════════════════════════════════╣")
        println("║  1. Jogar                        ║")
        println("║  2. Personagens                  ║")
        println("║  3. Créditos                     ║")
        println("║  0. Sair                         ║")
        println("╚══════════════════════════════════╝")
        print("\n➜ Escolha uma opção: ")
    }
}