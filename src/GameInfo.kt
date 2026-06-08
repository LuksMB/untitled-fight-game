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

        fun showClassesInfo() {
            clearScreen()

            println("╔══════════════════════════════════╗")
            println("║      Classes Disponíveis         ║")
            println("╠══════════════════════════════════╣")
            println("║  1. Fighter                      ║")
            println("║  2. Ranger                       ║")
            println("║  3. Mage                         ║")
            println("║  0. Voltar ao menu principal     ║")
            println("╚══════════════════════════════════╝")
            print("\n➜ Escolha uma opção: ")
        }

        fun classesInfoMenu() {
            val mage: Mage = Mage()
            val fighter: Fighter = Fighter()
            val ranger: Ranger = Ranger()
            while (true){
                showClassesInfo()
                when (readln()) {
                    "1" -> fighter.presentClass()
                    "2" -> ranger.presentClass()
                    "3" -> mage.presentClass()
                    "0" -> {
                        break
                    }
                    else -> println("Opção inválida!")
                }
            }
        }
    }
}