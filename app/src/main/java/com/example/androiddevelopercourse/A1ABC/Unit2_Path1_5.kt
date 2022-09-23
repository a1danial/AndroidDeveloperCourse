package com.example.androiddevelopercourse

fun main() {
    // Function invocation 'trick()' expected ; as it recognises trick as the name of trick() function
//    val trickFunctionV1 = trickv1 // Version 1

    // Function reference operator :: needed to refer function as value
    val trickFunctionV2 = ::trickv2 // Version 2

    // Function reference operator :: removed because trick now refers to a variable rather
    // than a function name
    val trickFunctionV3 = trickv3 // Version 3
    trickv3() // Body of lambda expression is executed
    trickFunctionV3()
    treat()
    println()

    val treatFunctionV4 = trickOrTreat(false)
    val trickFunctionV4 = trickOrTreat(true)
    treatFunctionV4()
    trickFunctionV4()
    println()

    val coins: (Int) -> String = { quantity ->
        "$quantity quarters"
    }

    val cupcake: (Int) -> String = {
        "Have a cupcake"
    }

    val treatFunctionV5 = trickOrTreatV2(false, coins)
    val trickFunctionV5 = trickOrTreatV2(true, cupcake)
    treatFunctionV5()
    trickFunctionV5()
    println()

    val treatFunctionV5_2 = trickOrTreatV2(false, cupcake)
    treatFunctionV5_2()
    println()

    val treatFunctionV6 = trickOrTreatV3(false, coins)
    val trickFunctionV6 = trickOrTreatV3(true, null)
    treatFunctionV6()
    trickFunctionV6()
    println()

    val coins2: (Int) -> String = {
        "$it quarters"
    }
    val treatFunctionV7 = trickOrTreatV3(false, coins2)
    val trickFunctionV7 = trickOrTreatV3(true, null)
    // repeat() function is a concise way to express a for loop with functions
    repeat(4) {
        treatFunctionV7()
    }
    trickFunctionV7()
    println()

    // Pass a lambda expression directly into a function
    val treatFunctionV8 = trickOrTreatV3(false, { "$it quarters" })
    treatFunctionV8()
    println()

    // Use trailing lambda syntax
    val treatFunctionV9 = trickOrTreatV3(false) { "$it quarters" }
    treatFunctionV9()

}

// Version 1
fun trickv1() {
    println("No treats!")
}

// Version 2
fun trickv2() {
    println("No treats!")
}

// Version 3
// With lambda expressions, you can create variables that store functions, call these variables
// like functions, and store them in other variables that you can call like functions
val trickv3 = {
    println("No treats!")
}

// Specifying variable's data type as Unit
val treat: () -> Unit = {
    println("Have a treat!")
}

// Functions can return other functions
fun trickOrTreat(isTrick: Boolean): () -> Unit {
    if (isTrick) {
        return trickv3
    } else {
        return treat
    }
}

// Pass a function to another function as an argument
fun trickOrTreatV2(isTrick: Boolean, extraTreat: (Int) -> String): () -> Unit {
    if (isTrick) {
        return trickv3
    } else {
        println(extraTreat(5))
        return treat
    }
}

// Nullable function types
fun trickOrTreatV3(isTrick: Boolean, extraTreat: ((Int) -> String)?): () -> Unit {
    if (isTrick) {
        return trickv3
    } else {
        if (extraTreat != null) {
            println(extraTreat(5))
        }
        return treat
    }
}

