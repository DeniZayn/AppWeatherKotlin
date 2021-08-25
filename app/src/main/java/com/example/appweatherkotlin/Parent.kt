package com.example.appweatherkotlin

open class Parent {

    companion object{
        const val PI: Double = 3.14
    }
    private val first = "first"
    protected val second = "second"
    internal val third = "third"
    val fourth = "fourth"  //public

    protected inner class Inner {
        private val fifth = "fifth"
    }
}