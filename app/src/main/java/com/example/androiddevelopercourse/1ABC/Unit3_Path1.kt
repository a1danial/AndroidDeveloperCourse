package com.example.androiddevelopercourse

import android.os.Build
import androidx.annotation.RequiresApi

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

// MODULE 5: Practice: Classes and Collections
// Task 1
data class Event(
    val title: String,
//    val description: String?, // Task 1
    val description: String? = null, // Task 1: Correct answer
//    val daypart: String, // Task 1
    val daypart: Daypart, // Task 2
    val duration: Int
)

// Task 2
enum class Daypart {
    MORNING, AFTERNOON, EVENING
}

// Task 7
val Event.durationText: String
//    get() = if (duration < 60) "short" else "long"
    get() = if (this.duration < 60) "short" else "long" // Correct answer

@RequiresApi(Build.VERSION_CODES.N)
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
//    println("Alphabetical menu:")
//    alphabeticalMenu.forEach {
//        println(it.name)
//    }

    // MODULE 5: Practice: Classes and Collections
    // Task 1
    val event = Event(
        title = "Study Kotlin",
        description = "Commit to studying Kotlin at least 15 minutes per day.",
        daypart = Daypart.EVENING,
        duration = 15
    )
    println(event)

    // Task 3
    val event1 = Event(title = "Wake up", description = "Time to get up", daypart = Daypart.MORNING, duration = 0)
    val event2 = Event(title = "Eat breakfast", daypart = Daypart.MORNING, duration = 15)
    val event3 = Event(title = "Learn about Kotlin", daypart = Daypart.AFTERNOON, duration = 30)
    val event4 = Event(title = "Practice Compose", daypart = Daypart.AFTERNOON, duration = 60)
    val event5 = Event(title = "Watch latest DevBytes video", daypart = Daypart.AFTERNOON, duration = 10)
    val event6 = Event(title = "Check out latest Android Jetpack library", daypart = Daypart.EVENING, duration = 45)
    val eventList = mutableListOf<Event>(
//        Event(title = "Wake up", description = "Time to get up", daypart = Daypart.MORNING, duration = 0),
//        Event(title = "Eat breakfast", daypart = Daypart.MORNING, duration = 15),
//        Event(title = "Learn about Kotlin", daypart = Daypart.AFTERNOON, duration = 30),
//        Event(title = "Practice Compose", daypart = Daypart.AFTERNOON, duration = 60),
//        Event(title = "Watch latest DevBytes video", daypart = Daypart.AFTERNOON, duration = 10),
//        Event(title = "Check out latest Android Jetpack library", daypart = Daypart.NIGHT, duration = 45)
        event1, event2, event3, event4, event5, event6 // Correct answer
    )

    // Task 4
    val eventShort = eventList.filter { it.duration < 60 }
    println("You have ${eventShort.size} short events")

    // Task 5
    val eventDaypart = eventList.groupBy { it.daypart }
    eventDaypart.forEach { daypart, events -> // Correct answer
        println("$daypart: ${events.size ?: "0"} events")
    }
//    println("Morning: ${eventDaypart[Daypart.MORNING]?.size ?: "0"} events")
//    println("Afternoon: ${eventDaypart[Daypart.AFTERNOON]?.size ?: "0"} events")
//    println("Evening: ${eventDaypart[Daypart.EVENING]?.size ?: "0"} events")

    // Task 6
    println("Last event of the day: ${eventList.last().title}")

    // Task 7
    println("Duration of first event of the day: ${eventList[0].durationText}")
}

