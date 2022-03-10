fun main() {
    //print("Pow!") // same line
    var x = 1
    println("Before the loop. x = $x") // new line
    while(x < 4) {
        println("In the loop. x = $x")
        x += 1
    }
    println("After the loop. x = $x") // 4
    var y = 2

    // if statements
    println(if (x > y) "x is greater than y" else "x is not greater than y")
}