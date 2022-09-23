package com.example.androiddevelopercourse

class Unit3_Path1 {

}

data class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
    )

enum class Difficulty {
    EASY, MEDIUM, HARD
}

class Quiz {
    val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
    val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)

    companion object StudentProgress {
        var total: Int = 10
        var answered: Int = 3
    }

    fun printQuiz() {
        question1.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
        question2.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
        question3.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
    }
}

val Quiz.StudentProgress.progressText: String
    get() = "${answered} of ${total} answered"

fun Quiz.StudentProgress.printProgressBar() {
    repeat(Quiz.answered) { print("▓") }
    repeat(Quiz.total - Quiz.answered) { print("▒") }
    println()
    println(Quiz.progressText)
}

class Cookie(
    val name: String,
    val softBaked: Boolean,
    val hasFilling: Boolean,
    val price: Double
)

val cookies = listOf(
    Cookie(
        name = "Chocolate chip",
        softBaked = false,
        hasFilling = false,
        price = 1.69
    ),
    Cookie(
        name = "Banana Walnut",
        softBaked = true,
        hasFilling = false,
        price = 1.49
    ),
    Cookie(
        name = "Vanilla Creme",
        softBaked = false,
        hasFilling = true,
        price = 1.59
    ),
    Cookie(
        name = "Chocolate Peanut Butter",
        softBaked = false,
        hasFilling = true,
        price = 1.49
    ),
    Cookie(
        name = "Snickerdoodle",
        softBaked = true,
        hasFilling = false,
        price = 1.39
    ),
    Cookie(
        name = "Blueberry Tart",
        softBaked = true,
        hasFilling = true,
        price = 1.79
    ),
    Cookie(
        name = "Sugar and Sprinkles",
        softBaked = false,
        hasFilling = false,
        price = 1.39
    )
)

fun main(args: Array<String>) {
//    println(question1.toString())
//    println(Quiz.progressText)
//    println(Quiz.printProgressBar())

//    Quiz.printProgressBar()

//    val quiz = Quiz()
//    quiz.printQuiz()

//    Quiz().apply {
//        printQuiz()
//    }

//    val rockPlanets = arrayOf<String> ("Mercury", "Venus", "Earth", "Mars")
//    val gasPlanets = arrayOf("Jupiter", "Saturn", "Uranus", "Neptune")
//    val solarSystem = rockPlanets + gasPlanets

//    println(solarSystem[0])
//    println(solarSystem[1])
//    println(solarSystem[2])
//    println(solarSystem[3])
//    println(solarSystem[4])
//    println(solarSystem[5])
//    println(solarSystem[6])
//    println(solarSystem[7])

//    solarSystem[3] = "Little Earth"
//    println(solarSystem[3])

//    solarSystem[8] = "Pluto" // ArrayIndexOutOfBoundsException: Index 8 out of bounds for length 8
//    val newSolarSystem = arrayOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune", "Pluto")
//    println(newSolarSystem[8])

//    val solarSystem = listOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
//    println(solarSystem.size)
//    println(solarSystem[2])
//    println(solarSystem.get(3))
//    println(solarSystem.indexOf("Earth"))
//    println(solarSystem.indexOf("Pluto"))

    // Step 3: Lists
//    val solarSystem = mutableListOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
//    solarSystem.add("Pluto")
//    solarSystem.add(3, "Theia")
//    solarSystem[3] = "Future Moon"
//    solarSystem.removeAt(9)
//    solarSystem.remove("Future Moon")
//
//    for (planet in solarSystem) {
//        println(planet)
//    }
//    println(solarSystem.contains("Pluto"))
//    println("Future Moon" in solarSystem)

    // Step 4: Sets
//    val solarSystem = mutableSetOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
//    println(solarSystem.size)
//    solarSystem.add("Pluto")
//    println(solarSystem.size)
//    println(solarSystem.contains("Pluto"))
//
//    solarSystem.add("Pluto")
//    println(solarSystem.size)
//
//    solarSystem.remove("Pluto")
//    println(solarSystem.size)
//    println(solarSystem.contains("Pluto"))

    // Step 5: Map collection
//    val solarSystem = mutableMapOf(
//        "Mercury" to 0,
//        "Venus" to 0,
//        "Earth" to 1,
//        "Mars" to 2,
//        "Jupiter" to 79,
//        "Saturn" to 82,
//        "Uranus" to 27,
//        "Neptune" to 14
//    )
//    println(solarSystem.size)
//    solarSystem["Pluto"] = 5
//    println(solarSystem.size)
//    println(solarSystem["Pluto"])
//    println(solarSystem["Theia"])
//
//    solarSystem.remove("Pluto")
//    println(solarSystem.size)
//
//    solarSystem["Jupiter"] = 78
//    println(solarSystem["Jupiter"])

    // MODULE 4
    // Step 2
//    cookies.forEach {
//        println("Menu item: ${it.name}")
//    }

    // Step 3: map()
    val fullMenu = cookies.map {
        "${it.name} - $${it.price}"
    }
//    println("Full menu:")
//    fullMenu.forEach {
//        println(it)
//    }

    // Step 4: filter()
    val softBakedMenu = cookies.filter {
        it.softBaked
    }
//    println("Soft cookies:")
//    softBakedMenu.forEach {
//        println("${it.name} - $${it.price}")
//    }

    // Step 5: groupBy()
    val groupedMenu = cookies.groupBy { it.softBaked }
    val softBakedMenuS5 = groupedMenu[true] ?: listOf()
    val crunchyMenu = groupedMenu[false] ?: listOf()
//    groupedMenu.forEach {
//        println("${it.key} - ${it.value}")
//    }
//    println("Soft cookies:")
//    softBakedMenu.forEach {
//        println("${it.name} - $${it.price}")
//    }
//    println("Crunchy cookies:")
//    crunchyMenu.forEach {
//        println("${it.name} - $${it.price}")
//    }

    // Step 6: fold()
    val totalPrice = cookies.fold(0.0) {total, cookie ->
        total + cookie.price
    }
//    println("Total price: $${totalPrice}")

    // Step 7: sortedBy()
    val alphabeticalMenu = cookies.sortedBy {
//    val alphabeticalMenu = cookies.sortedByDescending { // For descending
        it.name
    }
    println("Alphabetical menu:")
    alphabeticalMenu.forEach {
        println(it.name)
    }
}

