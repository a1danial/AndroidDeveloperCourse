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

    // Above correct, but here takes advantage of trailing lambda syntax
//    printFinalTemperature(27.0, "Celsius", "Fahrenheit") { 9.0 / 5.0 * it + 32 }
//    printFinalTemperature(350.0, "Kelvin", "Celsius") { it - 273.15 }
//    printFinalTemperature(10.0, "Fahrenheit", "Kelvin") { 5.0 / 9.0 * (it - 32) + 273.15 }

    // Practice 5
    val brunoSong = Song("We Don't Talk About Bruno", "Encanto Cast", 2022, 1_000_000)
//    brunoSong.SongDetails() // Comment
//    println(brunoSong.isPopular) // Comment

    // Practice 6
    val amanda = Person("Amanda", 33, "play tennis", null)
    val atiqah = Person("Atiqah", 28, "climb", amanda)

//    amanda.showProfile() // Comment
//    atiqah.showProfile() // Comment

    // Practice 7
    val newFoldablePhone = FoldablePhone(false)

//    newFoldablePhone.switchOn() // Comment
//    newFoldablePhone.checkPhoneScreenLight() // Comment
//    newFoldablePhone.unfoldPhone() // Comment
//    newFoldablePhone.switchOn() // Comment
//    newFoldablePhone.checkPhoneScreenLight() // Comment

    // Practice 8
    val winningBid = Bid(5000, "Private Collector")

    println("Item A is sold at ${auctionPrice(winningBid, 2000)}.") // Comment
    println("Item B is sold at ${auctionPrice(null, 3000)}.") // Comment
}

// Practice 2 : Mobile notification
fun printNotificationSummary(numberOfMessages: Int) {
    if (numberOfMessages < 100 ) {
//        println("You have $numberOfMessages notifications.") // Original; no curly brackets but still worked
        println("You have ${numberOfMessages} notifications.")
    } else {
        println("Your phone is blowing up! You have 99+ notifications.")
    }
}

// Practice 3 : Movie-ticket price
fun ticketPrice(age: Int, isMonday: Boolean): Int {
    return when (age) {
        in 0..12 -> 15
//        in 13..60 -> // Original; Correct but below is simplied
//            if (isMonday) {
//                25
//            } else {
//                30
//            }
        in 13..60 -> if (isMonday) 25 else 30
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
    // uses customer getter function and a method that prints the description of itself
//        fun SongPopularity() {
//        if (playCount < 1000 ) {
//            println("Song is unpopular")
//        } else {
//            println("Song is popular")
//        }
//    }
    val isPopular: Boolean
        get() = playCount >= 1000

    // Correct
    fun SongDetails() {
        println("$title, performed by $artist, was released in $year.")
    }
}

// Practice 6 : Internet profile
class Person(val name: String, val age: Int, val hobby: String?, val referrer: Person?) {
    fun showProfile() {
        println("Name: $name")
        println("Age: $age")
        // Missed out null check for hobby
        if (hobby != null) {
            println("Likes to $hobby. ")
        }
        // Null checks for both referrer, and the referrer's property hobby
        // print continues text on same row unlike println
        if (referrer != null) {
            print("Has a referrer named ${referrer.name}, who likes to ${referrer.hobby}")
            if (referrer.hobby != null) {
                print(", who likes to ${referrer.hobby}")
            } else { print(".") }
        } else {
            print("Doesn't have a referrer.")
        }
        print("\n\n")
    }
}

// Practice 7 : Foldable phones
open class Phone(var isScreenLightOn: Boolean = false) {
    open fun switchOn() {
        isScreenLightOn = true
    }

    fun switchOff() {
        isScreenLightOn = false
    }

    fun checkPhoneScreenLight() {
        val phoneScreenLight = if(isScreenLightOn) "on" else "off"
        println("The phone screen's light is $phoneScreenLight.")
    }
}

class FoldablePhone(deviceIsScreenLightOn: Boolean, var deviceFolded: Boolean = true) :
        Phone(isScreenLightOn = deviceIsScreenLightOn) {

    override fun switchOn() {
        if (!deviceFolded) { // If device is NOT folded
            super.switchOn()
        }
    }

    fun foldPhone() {
        deviceFolded = true
    }

    fun unfoldPhone() {
        deviceFolded = false
    }
}

// Practice 8 : Special auction
class Bid(val amount: Int, val bidder: String)

fun auctionPrice(bid: Bid?, minimumPrice: Int): Int {
    // Technically correct
//    if (bid != null) {
//        return bid.amount
//    } else {
//        return minimumPrice
//    }

    // Solution uses safe call and elvis operator to correct price
    return bid?.amount ?: minimumPrice
}

