package com.example.androiddevelopercourse

// Pathway complete
fun main() {
    /* Module 3: Write your first program in Kotlin */
    println("Happy Birthday!")
    println("Jhansi")
    println("You are 25!")

    println("Happy Birthday, Rover!")

    // Let's print a cake!
    println("   ,,,,,   ")
    println("   |||||   ")
    println(" =========")
    println("@@@@@@@@@@@")
    println("{~@~@~@~@~}")
    println("@@@@@@@@@@@")

    // This prints an empty line.
    println("")

    println("You are already 5!")
    println("5 is the very best age to celebrate!")

    println("\n\n")

    /* Module 4: Create a birthday message in Kotlin */
    var age = 5 * 365
    val name = "Rover"

    println("Happy Birthday, ${name}!")

    // Let's print a cake!
    println("   ,,,,,   ")
    println("   |||||   ")
    println(" =========")
    println("@@@@@@@@@@@")
    println("{~@~@~@~@~}")
    println("@@@@@@@@@@@")

    // This prints an empty line.
    println("")

    println("You are already ${age} days old, ${name}!")
    println("${age} days old is the very best age to celebrate!")

    printBorder()
    println("Happy Birthday, Jhansi!")
    printBorder()

    var border = "%"
    printBorder(border)
    println("Happy Birthday, Jhansi!")
    printBorder(border)

    border = "`-._,-'"
    val timesToRepeat = 4
    printBorder(border, timesToRepeat)
    println("Happy Birthday, Jhansi!")
    printBorder(border, timesToRepeat)

    println("\n\n")

    age = 24
    val layers = 5
     printCakeCandles(age)
     printCakeTop(age)
     printCakeBottom(age, layers)

    println("\n\n")
}

fun printBorder(border: String = "=", timesToRepeat: Int = 23) {
    repeat(timesToRepeat) {
        print(border)
    }
    println()
}

fun printCakeTop(age: Int) {
    repeat(age + 2) {
        print("=")
    }
    println()
}

fun printCakeCandles(age: Int) {
    print(" ")
    repeat(age) {
        print(",")
    }
    println() // Print an empty line

    print(" ") // Print the inset of the candles on the cake
    repeat(age) {
        print("|")
    }
    println()
}

fun printCakeBottom(age: Int, layers: Int) {
    repeat(layers) {
        repeat(age + 2) {
            print("@")
        }
        println()
    }
}

