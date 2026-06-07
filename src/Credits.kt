class Credits {
    fun clearScreen() {
        print("\u001b[H\u001b[2J")
        System.out.flush()
    }

    fun showCredits() {
        clearScreen()

        println("╔══════════════════════════════════╗")
        println("║             CRÉDITOS             ║")
        println("╠══════════════════════════════════╣")
        println("║  [ PLAYER 1 - DEVELOPER ]        ║")
        println("║  » Fuscas Brega                  ║")
        println("║    Classe: Code Master           ║")
        println("║    Habilidade: Debug Infinito    ║")
        println("║                                  ║")
        println("║  [ PLAYER 2 - DEVELOPER ]        ║")
        println("║  » Belmont (vampire hunter)      ║")
        println("║    Classe: Game Designer         ║")
        println("║    Habilidade: Combo de Ideias   ║")
        println("╠══════════════════════════════════╣")
        println("║     Obrigado por jogar!          ║")
        println("╚══════════════════════════════════╝")
        print("\n➜ Precione ENTER para voltar: ")
        readln()
    }
}