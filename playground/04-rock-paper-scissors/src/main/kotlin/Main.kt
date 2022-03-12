fun main(args: Array<String>) {
    val options = arrayOf("Rock", "Paper", "Scissors")
    val gameChoice = getGameChoice(options)
    val userChoice = getUserChoice(options)
    printResult(userChoice, gameChoice)
}

fun getGameChoice(optionsParams: Array<String>) =
    optionsParams[(Math.random() * optionsParams.size).toInt()]

fun getUserChoice(optionsParams: Array<String>): String {
    var isValidChoice = false
    var userChoice = ""
    while(!isValidChoice) {
        // Ask the user for their choice
        print("Please enter one of the following:")
        for (item in optionsParams) print(" $item")
        println(".")
        // Read the user input
        val userInput = readLine()
        // Validate the user input
        if (userInput != null && userInput in optionsParams) {
            isValidChoice = true
            userChoice = userInput
        }
        if (!isValidChoice) println("You must enter a valid choice.")
    }
    return userChoice
}

fun printResult(userChoice: String, gameChoice: String) {
    val result: String
    // Figure out the result
    if (userChoice == gameChoice) result = "Tie!"
    else if ((userChoice == "Rock" && gameChoice == "Scissors") ||
        (userChoice == "Paper" && gameChoice == "Rock") ||
        (userChoice == "Scissors" && gameChoice == "Paper")) result = "You win!"
    else result = "You lose!"
    // Print the result
    println("You chose $userChoice. I chose $gameChoice. $result")
}
