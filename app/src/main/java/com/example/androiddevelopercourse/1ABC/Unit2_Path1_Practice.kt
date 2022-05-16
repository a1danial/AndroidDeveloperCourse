package com.example.androiddevelopercourse

fun main() {
    // Practice 2
    val morningNotification = 51
    val eveningNotification = 135

    printNotificationSummary(morningNotification)
    printNotificationSummary(eveningNotification)
}

// Practice 2
fun printNotificationSummary(numberOfMessages: Int) {
    if (numberOfMessages < 100 ) {
        println("You have $numberOfMessages notifications.")
    } else {
        println("Your phone is blowing up! You have 99+ notifications.")
    }
}

