package com.example.androiddevelopercourse


fun main() {
//    ABK_U3_P1_M2() // Module 2: Navigate between screens
    ABK_U3_P1_M3() // Module 3: Activities and Intent
//    ABK_U3_P1_M4() // Module 4: Stages of the activity lifecycle
}

fun ABK_U3_P1_M4() {
    TODO("Not yet implemented")
}

fun ABK_U3_P1_M3() {
    TODO("Not yet implemented")
}

fun ABK_U3_P1_M2() {
    /* STEP 2: Learn about collections */
    /* Create a list and sets */
    val numbers = listOf(0, 3, 8, 4, 0, 5, 5, 8, 9, 2)
    println("list:   ${numbers}")
    println("sorted: ${numbers.sorted()}")
    val setOfNumbers = numbers.toSet()
    println("set:    ${setOfNumbers}")
    val set1 = setOf(1,2,3)
    val set2 = mutableSetOf(3,2,1)
    println("$set1 == $set2: ${set1 == set2}")
    println("contains 7: ${setOfNumbers.contains(7)}")

    /* Learn about maps */
    val peopleAges = mutableMapOf<String, Int>(
        "Fred" to 30,
        "Ann" to 23
    )
    peopleAges.put("Barbara", 42)
    peopleAges["Joe"] = 51
    peopleAges["Fred"] = 31 // No new key is added but value is updated
    println(peopleAges)

    /* STEP 3: Working with collections */
    // Function types
//    val triple: (Int) -> Int = { a: Int -> a * 3 }
    // Concise coding by utilising a shorthand for lambda with single parameters
    val triple: (Int) -> Int = { it * 3 }
    println(triple(5))

    /* STEP 4: Learn about lambdas and higher-order functions */
    // Higher-order functions
    val peopleNames = listOf("Fred", "Ann", "Barbara", "Joe")
    println(peopleNames.sorted())
    println(peopleNames.sortedWith { str1: String, str2: String -> str1.length - str2.length })

    /* STEP 5: Make word lists */
    val words = listOf(
        "about",
        "acute",
        "awesome",
        "balloon",
        "best",
        "brief",
        "class",
        "coffee",
        "creative"
    )
    val filteredWords = words.filter { it.startsWith("b", ignoreCase = true) }
        .shuffled()
        .take(2)
        .sorted()
//    val filteredWords = words.filter { it.startsWith("c", ignoreCase = true) }
//        .shuffled()
//        .take(1)
    println(filteredWords)

}

