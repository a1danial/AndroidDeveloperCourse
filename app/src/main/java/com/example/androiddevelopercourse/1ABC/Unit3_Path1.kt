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

    val solarSystem = mutableListOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
    solarSystem.add("Pluto")
    solarSystem.add(3, "Theia")
    solarSystem[3] = "Future Moon"
    solarSystem.removeAt(9)
    solarSystem.remove("Future Moon")

    for (planet in solarSystem) {
        println(planet)
    }
    println(solarSystem.contains("Pluto"))
    println("Future Moon" in solarSystem)
}

