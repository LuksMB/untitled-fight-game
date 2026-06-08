class Character(
    val name: String,
    val charClass: CharClass
) {
    private var maxHp: Int = charClass.baseHp
    private var maxResource: Int = charClass.baseResource
    private var resourceName: String = charClass.resourceName

    private var hp: Int = maxHp
    private var resource: Int = maxResource
    private var accuracy: Int = charClass.baseAccuracy
    private var defense: Int = charClass.baseDefense

    fun isAlive(): Boolean = hp > 0
    fun takeDamage(damage: Int) {
        hp -= damage
        if (hp < 0) hp = 0
    }

    fun useResource(cost: Int) {
        resource -= cost
        if (resource < 0) resource = 0
    }
}