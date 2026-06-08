import GameInfo.Companion.clearScreen
import charClasses.Fighter
import charClasses.Mage
import charClasses.Ranger

class Game(playerClass: String) {
    val player = when (playerClass){
        "Lutador" -> Character("Protagonista", Fighter())
        "Atirador" -> Character("Protagonista", Ranger())
        "Mago" -> Character("Protagonista", Mage())
        else -> throw IllegalArgumentException("Classe inválida!")
    }
    private var enemy: Character = Character("Mago do Mal", Mage())
    private var wins: Int = 0
    private var losses: Int = 0

    fun chooseEnemy() {
        when (this.wins) {
            0 -> this.enemy = Character("Mago do Mal", Mage())
            1 -> this.enemy = Character("Rei do Velho Oeste", Ranger())
            2 -> this.enemy = Character("Anderson Silva", Fighter())
            else -> this.enemy = Character("Lutador Lendário", Fighter())
        }
    }

    fun start(){
        player.charClass.warCry()
        print("\n➜ Pressione ENTER para iniciar sua jornada: ")
        readln()
        while (wins < 3 && losses < 3) {
            chooseEnemy()
            if (Match.matchMenu(player, enemy)) {
                wins++
            } else {
                losses++
            }
            player.resetHp()
            player.resetResource()
            print("\n➜ Pressione ENTER para iniciar a próxima batalha: ")
            readln()
        }
        endGame()
    }

    private fun endGame(){
        if (wins > losses){
            congratsScreen()
        } else {
            gameOverScreen()
        }
        print("\n➜ Pressione ENTER para voltar ao menu principal: ")
        readln()
    }

    private fun congratsScreen(){
        clearScreen()
        print("\nVocê é o campeão, parabéns!")
    }

    private fun gameOverScreen() {
        clearScreen()
        print("\nVocê perdeu, mais sorte da próxima vez!")
    }
}