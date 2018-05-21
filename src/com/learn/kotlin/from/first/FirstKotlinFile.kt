package com.learn.kotlin.from.first

fun sum(a: Int,b: Int):Int{
    return a+b
}

fun sum1(a: Int,b: Int)=a+b

fun sum2(a: Int,b: Int){
    println("sum of $a and $b is ${a+b}")
}

fun maxOf(a: Int,b: Int)=if (a>b) a else b


fun forLoop(){
    val items = listOf("apple", "banana", "kiwifruit")
    items.forEachIndexed { index, s -> println("Item at $index is $s") }

}

fun main (string: Array<String>){

    val testVisbilityModifiers=TestVisbilityModifiers()
    testVisbilityModifiers.f3()
    testVisbilityModifiers.f4()
}