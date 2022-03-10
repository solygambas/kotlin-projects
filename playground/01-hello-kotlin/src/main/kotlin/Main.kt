fun main() {
    // println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    // println("Program arguments: ${args.joinToString()}")

    // VARIABLES AND DATA TYPES
    // var x: Int = 3
    // println("The value of x is $x") // 3
    // x = 4
    // println("The value of x is now $x") // 4
    val y: Int = 11 // can't be reassigned
    // val bigNumber = 3L // long (64 number)
    // val preciseDecimal = 3.33 // double
    // val decimal = 3.33f // float

    // BOOLEANS
    val iLovePizza = true
    val iLoveVeggies = false
    val iLoveBoth = iLovePizza && iLoveVeggies
    val iLoveOne = iLovePizza || iLoveVeggies
    val iLoveEquallyBoth = iLovePizza == iLoveVeggies
    val iDontLoveEquallyBoth = iLovePizza != iLoveVeggies
    // println(iLoveBoth) // false
    // println(iLoveOne) // true
    // println(iLoveEquallyBoth) // false
    // println(iDontLoveEquallyBoth) // true

    val iAmALetter = 'a'

    // ARITHMETIC OPERATORS
    val z = 3 * 4
    // println("The value of z is $z") // 12
    val floatResult = 3f / 4f
    // println("The value of floatResult is $floatResult") // 0.75
    // val moduloNine = 10 % 3 // 1

    // STRINGS
    val catchLine = "Kotlin is the best language"
    // println(catchLine.uppercase())

    // IF CONDITIONS
    val a = 1 + 3
    if(a == 2) {
        println("a is 2")
    } else if(a == 3) {
        println("a is 3")
    } else {
        // println("a is not 2 or 3")
    }
    val b = if(a == 2) 2 else 3

    //  NULL SAFETY
    // val number1 = readLine() // 2
    // val number2 = readLine() // 4
    // val result = number1!!.toInt() + number2!!.toInt() // ? can be null, !! trust me it won't be null (crash otherwise)
    // it's better to have a fallback value
    // val number1 = readLine() ?: "0"
    // val number2 = readLine() ?: "0"
    // val result = number1.toInt() + number2.toInt()
    // println(result) // 6

    // LISTS
    val shoppingList = listOf<String>("Lamborghini", "Penthouse", "Rolex")
    // println(shoppingList[0]) // Lamborghini
    val shoppingList2 = mutableListOf("Lamborghini", "Penthouse", "Rolex")
    shoppingList2.add("Ferrari")
    // println(shoppingList2[3])

    // WHILE LOOPS
    var counter = 0
    while(counter < shoppingList2.size) {
        // println(shoppingList2[counter])
        counter++
    }

    // FOR LOOPS
    for(shoppingItem in shoppingList2) {
        // println(shoppingItem)
    }

    for(i in 1..10) {
        // println(i) // 1, 2, ..., 10
    }

    // WHEN EXPRESSIONS
    val x = 3
    /* when(x) {
        in 1..2 -> print("x is between 1 and 2")
        in 3..10 -> println("x is between 3 and 10")
        else -> {
            println("x is not in the range of 1 to 10")
        }
    } */

    // FUNCTIONS
    // print10numbers()
    // val odd = isEven(5)
    // val odd = isEven()
    // val odd = isEven(number = 5)
    // println(odd) // false
    val extended = 3
    // println(extended.isOdd()) // true

    // CLASSES
    // val dog = Animal("Dog")
    // val dog = Dog()
    // dog.bark()
    // val cat = Cat()
    // cat.meow()

    // ANONYMOUS CLASSES
    /* val bear = object : Animal("Camembear") {
        override fun makeSound() {
            print("ROOOAR!!!")
        }
    } */
    // bear.makeSound()

    // TRY / CATCH
    /* val number = readLine() ?: "0"
    val parsedNum = try {
        number.toInt()
    } catch (e: Exception) {
        0
    }
    println(parsedNum) */

    // LAMBDA FUNCTIONS
    val funList = listOf("Kotlin", "is", "fun")
    //val count = funList.count { currentString ->
    //    currentString.length == 3
    //}
    val count = funList.customCount { currentString ->
        currentString.length == 3
    }
    println(count) // 1
}

fun print10numbers() {
    for(i in 1..10) {
        println(i) // 1, 2, ..., 10
    }
}

fun isEven(number: Int = 11): Boolean {
    return number % 2 == 0
}

// extending functions with types
fun Int.isOdd(): Boolean {
    return this % 2 == 1
}

// fun List<String>.customCount(funnyFunction: (String) -> Boolean): Int {
fun <T> List<T>.customCount(funnyFunction: (T) -> Boolean): Int {
    var counter = 0
    for(item in this) {
        if(funnyFunction(item)) {
            counter++
        }
    }// list
    return counter
}