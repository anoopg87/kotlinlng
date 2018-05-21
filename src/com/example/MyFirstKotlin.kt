package com.example

class MyFirstKotlin {



    fun add(a: Int,b: Int)=a+b

    fun max(a:Int,b: Int)= if (a>b) a else b

    fun stringLength(obj: Any)= (obj as? String)?.length

    fun loopTest(){
        val list= listOf("Anoop","Reeshma","Leela","Aneesh","Purushothaman","Geetha","Rintu")
        for (item in list){
            System.out.println(item)
        }

        for (index in list.indices){
            System.out.println("$index is ${list[index]}" )
        }
    }

    fun whenFun(obj: Any?):String=
        when(obj){

            String-> "String"
            Long-> "Long"
            "Hello"-> "Greeting"
            !is String -> "Not a string"
            null-> "null"
            else-> "None of these"

        }


    fun rangeIteration(){

        for (x in 1..10){
            System.out.println(x)
        }

        for (x in 1..10 step 2){
            System.out.println(x)
        }

        for (x in 10 downTo 0 step 3){
            System.out.println(x)
        }
    }


    fun collectionFun(){
        val list= listOf("Anoop","Reeshma","Leela","Aneesh","Purushothaman","Geetha","Rintu")
        for (item in list){
            System.out.println(item)
        }


        when{
            "Anoop" in list-> println("nice guy")
            "Leela" in list-> println("beautiful women")
        }


        list.filter { it.startsWith("A") }.sortedBy { it }.map { it.toUpperCase() }.forEach { it-> println(it) }



    }

    data class User(val firstName:String, val lastName:String )

    fun dataClassManipulation(){

        val  user=User("Anoop","Gopalakrishnan")
        val user1=user.copy(firstName = "Aneesh")
        println(user.toString())
        println(user1.toString())
    }

    fun defaultValue(str1: String,str2: String=" Welcome"){
        println(str1+" "+str2)
    }

    fun mapFunc(){
        val  map= mapOf("a" to 1,"b" to 2,"c" to 3)

        for ((k,v) in map){

            println("$k-> $v")
        }
    }


    fun filterFun(){
        val list=ArrayList<Int>()
        list += -1..10
        val positives=list.filter { it>0 }
        for (x in positives)println(x)

    }

     private fun String.doubleLength():Int{
        return length*2
    }

    fun stringExtensionMethodTest(){
        println("Anoop".doubleLength())
    }


    fun ifToReturnFun(int: Int){
        val result=if(int==0)"zero" else if (int==1) "one" else   "two"
        println(result)
    }



}