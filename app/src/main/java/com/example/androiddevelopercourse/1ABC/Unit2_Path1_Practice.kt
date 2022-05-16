package com.example.androiddevelopercourse

fun main() {
    // Practice 2
    val morningNotification = 51
    val eveningNotification = 135

//    printNotificationSummary(morningNotification) // Comment
//    printNotificationSummary(eveningNotification) // Comment

    // Practice 3
    val child = 5
    val adult = 28
    val senior = 87

    val isMonday = true

//    println("The movie ticket price for a person aged $child is  \$${ticketPrice(child, isMonday)}.") // Comment
//    println("The movie ticket price for a person aged $adult is \$${ticketPrice(adult, isMonday)}.") // Comment
//    println("The movie ticket price for a person aged $senior is \$${ticketPrice(senior, isMonday)}.") // Comment

    // Practice 4
    val CtoF: (Double) -> Double = { // Celsius to Fahrenheit
        9*it/5 + 32
    }
    val KtoC: (Double) -> Double = { // Kelvin to Celsius
        it - 273.15
    }
    val FtoK: (Double) -> Double = { // Fahrenheit to Kelvin
        5*(it-32)/9 + 273.15
    }
//    printFinalTemperature(27.0, "Celsius", "Fahrenheit", CtoF) // Comment
//    printFinalTemperature(350.0, "Kelvin", "Celsius", KtoC) // Comment
//    printFinalTemperature(10.0, "Fahrenheit", "Kelvin", FtoK) // Comment

    // Practice 6
    val amanda = Person("Amanda", 33, "play tennis", null)
    val atiqah = Person("Atiqah", 28, "climb", amanda)

//    amanda.showProfile() // Comment
//    atiqah.showProfile() // Comment
}

// Practice 2 : Mobile notification
fun printNotificationSummary(numberOfMessages: Int) {
    if (numberOfMessages < 100 ) {
        println("You have $numberOfMessages notifications.")
    } else {
        println("Your phone is blowing up! You have 99+ notifications.")
    }
}

// Practice 3 : Movie-ticket price
fun ticketPrice(age: Int, isMonday: Boolean): Int {
    return when (age) {
        in 0..12 -> 15
        in 13..60 ->
            if (isMonday) {
                25
            } else {
                30
            }
        in 61..100 -> 20
        else -> -1
    }
}

// Practice 4 : Temperature converter
fun printFinalTemperature(
    initialMeasurement: Double,
    initialUnit: String,
    finalUnit: String,
    conversionFormula: (Double) -> Double
) {
    val finalMeasurement = String.format("%.2f", conversionFormula(initialMeasurement)) // two decimal places
    println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit.")
}

// Practice 5 : Song catalog
class Song(val title: String, val artist: String, val year: Int, val playCount: Int) {
    fun SongPopularity() {
        if (playCount < 1000 ) {
            println("Song is unpopular")
        } else {
            println("Song is popular")
        }
    }
    fun SongDetails() {
        println("$title, performed by $artist, was released in $year.")
    }
}

// Practice 6 : Internet Profile
class Person(val name: String, val age: Int, val hobby: String?, val referrer: Person?) {
    fun showProfile() {
        println("Name: $name")
        println("Age: $age")
        val textHobby = ""
        if (referrer != null) {
            println("Likes to $hobby. Has a referrer named ${referrer.name}, who likes to ${referrer.hobby}")
        } else {
            println("Likes to $hobby. Doesn't have a referrer.")
        }
        println()
    }
}
