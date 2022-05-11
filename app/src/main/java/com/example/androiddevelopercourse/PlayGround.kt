package com.example.androiddevelopercourse

class Company () {
    var name: String = "abc"
        private set

    fun myfunc(n: String) {
        name = n			 // we set the name here
    }
}

fun main(args: Array<String>) {
    var c = Company()
    println("Name of the company is: ${c.name}")
    c.myfunc("GeeksforGeeks")
    println("Name of the new company is: ${c.name}")
}
