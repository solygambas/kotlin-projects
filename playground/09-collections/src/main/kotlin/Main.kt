fun main(args: Array<String>) {
    // Lists
    var mShoppingList = mutableListOf("Tea", "Eggs", "Milk")
    //println("mShoppingList original: $mShoppingList")
    val extraShopping = listOf("Cookies", "Sugar", "Eggs")
    mShoppingList.addAll(extraShopping)
    //println("mShoppingList items added: $mShoppingList")
    if (mShoppingList.contains("Tea")) {
        mShoppingList.set(mShoppingList.indexOf("Tea"), "Coffee")
    }
    mShoppingList.sort()
    //println("mShoppingList sorted: $mShoppingList") // [Coffee, Cookies, Eggs, Eggs, Milk, Sugar]
    mShoppingList.reverse()
    //println("mShoppingList reversed: $mShoppingList") // [Sugar, Milk, Eggs, Eggs, Cookies, Coffee]

    var a: MutableList<String> = mutableListOf()
    a.add(0, "Zero")
    a.add(1, "Two")
    a.add(2, "Four")
    a.add(3, "Six")
    //println(a)
    if (a.contains("Zero")) a.add("Eight")
    a.removeAt(0)
    //println(a)
    if (a.indexOf("Four") != 4) a.add("Ten")
    //println(a)
    if (a.contains("Zero")) a.add("Twelve")
    //println(a)

    // Sets
    val mShoppingSet = mShoppingList.toMutableSet() // remove duplicates
    //println("mShoppingSet: $mShoppingSet")
    val moreShopping = setOf("Chives", "Spinach", "Milk")
    mShoppingSet.addAll(moreShopping)
    //println("mShoppingSet items added: $mShoppingSet")
    mShoppingList = mShoppingSet.toMutableList()
    //println("mShoppingList new version: $mShoppingList")
}



