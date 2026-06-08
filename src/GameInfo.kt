import charClasses.Fighter
import charClasses.Mage
import charClasses.Ranger

class GameInfo {
    companion object {
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
            println("║  2. Classes                      ║")
            println("║  3. Créditos                     ║")
            println("║  0. Sair                         ║")
            println("╚══════════════════════════════════╝")
            print("\n➜ Escolha uma opção: ")
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

        fun showClassesInfo(selector: Boolean) {
            clearScreen()

            println("╔══════════════════════════════════╗")
            println("║      Classes Disponíveis         ║")
            println("╠══════════════════════════════════╣")
            println("║  1. Lutador                      ║")
            println("║  2. Atirador                     ║")
            println("║  3. Mago                         ║")
            if (!selector) println("║  0. Voltar ao menu principal     ║")
            println("╚══════════════════════════════════╝")
            print("\n➜ Escolha uma opção: ")
        }

        fun classesInfoMenu(selector: Boolean): String {
            val mage = Mage()
            val fighter = Fighter()
            val ranger = Ranger()
            var escolha = "exit"
            while (true){
                if (escolha != "exit") return escolha
                showClassesInfo(selector)
                when (readln()) {
                    "1" -> escolha = fighter.showAbilitiesClass(selector)
                    "2" -> escolha = ranger.showAbilitiesClass(selector)
                    "3" -> escolha = mage.showAbilitiesClass(selector)
                    "0" -> {
                        if (!selector) break else println("Opção inválida!")
                    }
                    else -> println("Opção inválida!")
                }
            }
            return escolha
        }
    }
}