class Character(
    val name: String,
    val charClass: CharClass
) {
    private var maxHp: Double = charClass.baseHp
    private var maxResource: Int = charClass.baseResource
    private var resourceName: String = charClass.resourceName

    private var hp: Double = maxHp
    private var resource: Int = maxResource
    private var accuracy: Int = charClass.baseAccuracy
    private var defense: Int = charClass.baseDefense
    private var passiveStatus: Boolean = false

    fun getPassiveStatus(): Boolean = passiveStatus
    fun activatePassive() { passiveStatus = true }
    fun deactivatePassive() { passiveStatus = false }

    fun getHp(): Double = hp
    fun getResourceName(): String { return resourceName }
    fun getAccuracy(): Int { return accuracy }

    fun isAlive(): Boolean = hp > 0
    fun takeDamage(damage: Double) {
        hp -= damage
        if (hp < 0) hp = 0.0
    }

    fun getDefense(): Int = defense

    fun getResource(): Int = resource
    fun useResource(cost: Int) {
        resource -= cost
        if (resource < 0) resource = 0
    }
    fun gainResource(cost: Int) {
        resource += cost
        if (resource > maxResource) resource = maxResource
    }

    fun increaseDefense(cost: Int) {
        defense += cost
        if (defense > 100) defense = 100
    }

    fun increaseDamage(cost: Int) {
        hp += cost
        if (hp > 100) hp = 100.0
    }

    fun resetHp() {
        this.hp = this.maxHp
    }

    fun resetResource() {
        this.resource = this.maxResource
    }


}