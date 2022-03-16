class Wolf {
    var hunger = 10
    val food = "meat"

    fun eat() {
        println("The wolf is eating $food")
    }
}

class MyWolf {
    var wolf: Wolf? = Wolf()

    fun myFunction() {
        wolf?.eat()
    }
}

class BadException : Exception()

fun myFunction(test: String) {
    try {
        print("t")
        riskyCode(test)
        print("o")
    } catch (e: BadException) {
        print("a")
    } finally {
        print("w")
    }
    print("s")
}

fun riskyCode(test: String) {
    print("h")
    if (test == "Yes") {
        throw BadException()
    }
    print("r")
}

fun getAlphaWolf() : Wolf? {
    return Wolf()
}

fun main(args: Array<String>) {
    var w: Wolf? = Wolf()
    if (w != null) {
        w.eat()
    }
    var x = w?.hunger
    println("The value of x is $x")

    var y = w?.hunger ?: -1 // the elvis operator
    println("The value of y is $y")

    var myWolf = MyWolf()
    myWolf?.wolf?.hunger = 8
    println("The value of myWolf?.wolf?.hunger is ${myWolf?.wolf?.hunger}")

    var myArray = arrayOf("Hi", "Hello", null)
    for (item in myArray) {
        item?.let { println(it)} // "it" is a non-nullable version of item
    }

    getAlphaWolf()?.let { it.eat() }

    w = null
    //var z = w!!.hunger // NullPointerException error

    myFunction("No") // throws
    myFunction("Yes") // thaws
}



