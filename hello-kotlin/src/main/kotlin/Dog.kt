class Dog: Animal("Dog") {
    init {
        println("Hello, I have $legCount legs")
    }

    // fun bark() {
    override fun makeSound() {
        println("WUFF!!!")
    }
}