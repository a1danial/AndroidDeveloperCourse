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


