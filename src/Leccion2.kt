import java.util.*

fun main(args: Array<String>) {
    println("Hello, world!")
    println("Hello, ${args[0]}")

    val isUnit = println("Expression!")
    println(isUnit)

    val temperature = 10
    val isHot = if (temperature > 50) true else false
    println(isHot)

    val message = "The water temperature is ${ if (temperature > 50) "too warm" else "OK"}."

    feedTheFish()

    swim()
    swim("slow")
    swim(speed = "super fast")



    val decorations = listOf("rock", "pagoda", "plastic plant", "alligator", "flowerpot")
    println( decorations.filter {it[0] == 'p'} )

    val eager = decorations.filter {it[0] == 'p'}
    println("Eager: $eager")
    val filtered = decorations.asSequence().filter {it[0] == 'p'}
    println("Filtered: $filtered")
    val newList = filtered.toList()
    println("New List: $newList")

    val lazyMap = decorations.asSequence().map {
        println("Accesed: $it")
        it
    }
    println("Lazy: $lazyMap")
    println("First: ${lazyMap.first()}")
    println("All: ${lazyMap.toList()}")

    val lazyMap2 = decorations.asSequence().filter{it[0] == 'p'}.map{
        println("Access: $it")
        it
    }
    println("Filtered2: ${lazyMap2.toList()}")

    val mysports = listOf("basketball", "fishing", "running")
    val myplayers = listOf("LeBron James", "Ernest Hemingway", "Usain Bolt")
    val mycities = listOf("Los Angeles", "Chicago", "Jamaica")
    val mylist = listOf(mysports, myplayers, mycities)
    println("Flat: ${mylist.flatten()}")

    var dirtyLevel = 20
    val waterFilter = {dirty: Int -> dirty / 2}
    println(waterFilter(dirtyLevel))

    val waterFilter2: (Int) -> Int = {dirty -> dirty / 2}
    println(updateDirty(30, waterFilter2))

    println(updateDirty(15, ::increaseDirty))

    dirtyLevel = 19
    dirtyLevel = updateDirty(dirtyLevel) {dirtyLevel -> dirtyLevel + 23}
    print(dirtyLevel)
}

fun feedTheFish() {
    val day = randomDay()
    val food = fishFood(day)
    println ("Today is $day and the fish eat $food")
    println(if (shouldChangeWater(day)) "Change water" else "Don't change water")
}

fun randomDay() : String {
    val week = arrayOf ("Monday", "Tuesday", "Wednesday", "Thursday",
        "Friday", "Saturday", "Sunday")
    return week[Random().nextInt(week.size)]
}

fun fishFood (day : String) : String {
    return when (day) {
        "Monday" -> "flakes"
        "Wednesday" -> "redworms"
        "Thursday" -> "granules"
        "Friday" -> "mosquitoes"
        "Sunday" -> "plankton"
        else -> "nothing"
    }
}

fun swim(speed: String = "fast") {
    println("Swimming $speed")
}

fun shouldChangeWater (day: String, temperature: Int = 22, dirty: Int = 20): Boolean {
    return when {
        isTooHot(temperature) -> true
        isDirty(dirty) -> true
        isSunday(day) -> true
        else -> false
    }
}

fun isTooHot(temperature: Int) = temperature > 30
fun isDirty(dirty:Int) = dirty > 30
fun isSunday(day:String) = day == "Sunday"

fun updateDirty (dirty: Int, operation: (Int) -> Int): Int {
    return operation(dirty)
}

fun increaseDirty(start: Int) = start + 1