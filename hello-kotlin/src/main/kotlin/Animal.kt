// open class Animal( // can be extended
abstract class Animal(
    // not callable directly
    val name: String,
    val legCount: Int = 4
) {
    init {
        println("Hello, my name is $name")
    }

    abstract fun makeSound() // must be implemented in subclass
}