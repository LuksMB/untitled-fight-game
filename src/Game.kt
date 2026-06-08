import charClasses.Fighter
import charClasses.Mage
import charClasses.Ranger

class Game(val playerClass: String) {
    val player = when (playerClass){
        "Lutador" -> Character("Protagonista", Fighter())
        "Atirador" -> Character("Protagonista", Ranger())
        "Mago" -> Character("Protagonista", Mage())
        else -> throw IllegalArgumentException("Classe inválida!")
    }
    private var wins: Int = 0
    private var losses: Int = 0

    fun start(){
        val name = player.name
        val charClass = player.charClass.className
        println("Jogo começou com o $name de classe $charClass!")
    }
}