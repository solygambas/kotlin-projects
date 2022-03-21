data class Grocery(val name: String, val category: String, val unit: String, val unitPrice: Double, val quantity: Int)

fun main(args: Array<String>) {
    val groceries = listOf(Grocery("Tomatoes", "Vegetable", "1b", 3.0, 3),
        Grocery("Mushrooms", "Vegetable", "1b", 4.0, 1),
        Grocery("Bagels", "Bakery", "Pack", 1.5, 2),
        Grocery("Olive oil", "Pantry", "Bottle", 6.0, 1),
        Grocery("Ice cream", "Frozen", "Pack", 3.0, 2),
        )

    val highestUnitPrice = groceries.maxByOrNull { it.unitPrice * 5 }
    println("highestUnitPrice: $highestUnitPrice")
    val lowestQuantity = groceries.minByOrNull { it.quantity }
    println("lowestQuantity: $lowestQuantity")

    val sumQuantity = groceries.sumOf { it.quantity }
    println("sumQuantity: $sumQuantity")
    val totalPrice = groceries.sumOf { it.quantity * it.unitPrice }
    println("totalPrice: $totalPrice")
}



