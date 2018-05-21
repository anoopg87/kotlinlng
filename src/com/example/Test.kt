package com.example

import com.learn.kotlin.from.first.TestVisbilityModifiers

fun main(args: Array<String>){
//    val myFirstKotlin= MyFirstKotlin()
//   myFirstKotlin.add(5,10)
//
//  println(myFirstKotlin.max(5,10))
//
//   println(myFirstKotlin.stringLength(111))
//   println(myFirstKotlin.stringLength("anoop"))
//
//    myFirstKotlin.loopTest()
//
//   println(myFirstKotlin.whenFun(null))
//   println(myFirstKotlin.whenFun("Hello"))
//   println(myFirstKotlin.whenFun(12123123123123131))
//   println(myFirstKotlin.whenFun("Str"))
//   println(myFirstKotlin.whenFun(1))
//
//
//    myFirstKotlin.rangeIteration()
//    myFirstKotlin.collectionFun()
//
//    myFirstKotlin.dataClassManipulation()
//    myFirstKotlin.defaultValue("Hello")
//    myFirstKotlin.defaultValue("Stupid","Getlost")
//
//    myFirstKotlin.mapFunc()
//    myFirstKotlin.filterFun()
//
//    myFirstKotlin.stringExtensionMethodTest()
//    myFirstKotlin.ifToReturnFun(2)
//
//    with(myFirstKotlin){
//        mapFunc()
//        filterFun()
//        stringExtensionMethodTest()
//    }

    val abc:String?="Abc"


    val customer:Customer= Customer("Anoop","0449076435")

    customer.isNotNull {
       name="Reeshma"
        phone="04234234234"
    }


    whenNotNull(customer){
        println(name.toUpperCase())
        println(phone)
    }

    if (customer.isNotNull()){

    }

    val user:User=customer.mapTo {
         User(name+"@gmail.com",phone)
    }
    println(user.firstName)
    println(user.phone)

    val num=10.00
    num.isNaN()

    val testVisbilityModifiers=TestVisbilityModifiers()
    testVisbilityModifiers.f3()
    testVisbilityModifiers.f4()




}
data class Customer(var name:String,var phone:String)
data class User(var firstName:String,var phone:String)



