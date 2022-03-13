
fun main(args: Array<String>) {
    var myDog = Dog("Fido", 70, "Mixed")
    //println(myDog.name)
    myDog.bark()
    myDog.weight = 75
    println(myDog.weightInKgs)

    myDog.activities = arrayOf("Walks", "Fetching balls", "Frisbee")
    for(item in myDog.activities) {
        println("My dog enjoys $item")
    }

    val dogs = arrayOf(Dog("Kelpie", 20, "Westie"), Dog("Ripper", 10, "Poodle"))
    dogs[1].bark()
    dogs[1].weight = 15
    println("Weight for ${dogs[1].name} is ${dogs[1].weight}")

    val songOne = Song("The Mesopotanians", "They might be giants")
    val songTwo = Song("Going underground", "The Jam")
    val songThree = Song("Make me smile", "Steve Harley")
    // songTwo.play()
    //songTwo.stop()
    //songThree.play()

    val d = DrumKit(true, true)
    //d.playTopHat()
    //d.playSnare()
    d.hasShare = false
    //d.playTopHat()
    //d.playSnare()

    var myDuck = Duck()
}

class Dog (val name: String, var weight_param: Int, val breed_param: String) {
    var activities = arrayOf("Walks")
    var breed = breed_param.uppercase()
    // lateinit var temperament: String // will be initialized later

    // setter & getter
    var weight = weight_param
    set(value) {
        if(value > 0) field = value
    }
    val weightInKgs: Double
    get() = weight / 2.2

    init {
        println("Dog $name has been created. The breed is $breed")
    }

    fun bark() {
        println(if (weight < 20) "Yip!" else "Woof!")
    }
}

class Song (val title: String, val artist: String) {
    fun play() {
        println("Playing the song $title by $artist")
    }

    fun stop() {
        println("Stopped playing $title")
    }
}

class DrumKit (var hasTopHat: Boolean, var hasShare: Boolean) {
    fun playTopHat() {
        if(hasTopHat) println("ding ding ba-da-bing!")
    }
    fun playSnare() {
        if(hasShare) println("bang bang bang!")
    }
}

// empty constructor
class Duck {
    fun quack() {
        println("Quack! Quack! Quack!")
    }
}