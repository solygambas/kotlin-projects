fun main() {
    // println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    // println("Program arguments: ${args.joinToString()}")

    // VARIABLES AND DATA TYPES
    var x: Int = 3
    // println("The value of x is $x") // 3
    x = 4
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
}