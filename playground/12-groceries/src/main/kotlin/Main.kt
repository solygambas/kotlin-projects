data class Grocery(val name: String, val category: String, val unit: String, val unitPrice: Double, val quantity: Int)

fun main(args: Array<String>) {
    val groceries = listOf(Grocery("Tomatoes", "Vegetable", "1b", 3.0, 3),
        Grocery("Mushrooms", "Vegetable", "1b", 4.0, 1),
        Grocery("Bagels", "Bakery", "Pack", 1.5, 2),
        Grocery("Olive oil", "Pantry", "Bottle", 6.0, 1),
        Grocery("Ice cream", "Frozen", "Pack", 3.0, 2),
        )

    val highestUnitPrice = groceries.maxByOrNull { it.unitPrice * 5 }
    //println("highestUnitPrice: $highestUnitPrice")
    val lowestQuantity = groceries.minByOrNull { it.quantity }
    //println("lowestQuantity: $lowestQuantity")

    val sumQuantity = groceries.sumOf { it.quantity }
    //println("sumQuantity: $sumQuantity")
    val totalPrice = groceries.sumOf { it.quantity * it.unitPrice }
    //println("totalPrice: $totalPrice")

    // filter
    val vegetables = groceries.filter { it.category == "Vegetable" }
    //println("vegetables: $vegetables")
    val notFrozen = groceries.filterNot { it.category == "Frozen" }
    //println("notFrozen: $notFrozen")

    // map
    val groceryNames = groceries.map { it.name }
    //println("groceryNames: $groceryNames")
    val halfUnitPrice = groceries.map { it.unitPrice * 0.5 }
    //println("halfUnitPrice: $halfUnitPrice")

    // chaining
    val newPrices = groceries.filter { it.unitPrice > 3.0 }
        .map { it.unitPrice * 2 }
    //println("newPrices: $newPrices")

    // forEach
    //println("Grocery names: ")
    //groceries.forEach { println(it.name) }

    //println("Groceries with unitPrices > 3.0: ")
    //groceries.filter { it.unitPrice > 3 }
       // .forEach { println(it.name) }

    var itemNames = ""
    groceries.forEach({ itemNames += "${it.name} " })
    //println("itemNames: $itemNames")

    // groupBy
    groceries.groupBy { it.category }.forEach {
        println(it.key)
        it.value.forEach { println("   ${it.name}") }
    }

    // fold
    // use reduce if you don't need an initial value
    val ints = listOf(1, 2, 3)
    val sumOfInts = ints.fold(0) { runningSum, item -> runningSum + item }
    println("sumOfInts: $sumOfInts")

    val productOfInts = ints.fold(1) { runningProduct, item -> runningProduct * item }
    println("productOfInts: $productOfInts")

    val names = groceries.fold("") { string, item -> string + " ${item.name}" }
    println("names: $names")

    val changeFrom50 = groceries.fold(50.0) { change, item
        -> change - item.unitPrice * item.quantity
    }
    println("changeFrom50: $changeFrom50")
}



