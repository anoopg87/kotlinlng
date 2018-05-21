package com.learn.kotlin.from.first

fun main (string: Array<String>){

}


data class Customer(val name: String,val  email:String)


interface MyInterface{
    fun add()
    fun sub()
}

class IniterfaceTest(myInterface: MyInterface):MyInterface by myInterface{

   fun addAndSub(){
       add()
       sub()
   }

}


open class Base{
    open fun v(){}
    fun x(){}
}

class Derivied: Base(){
    override fun v() {
    }

}

interface Foo{
    val count:Int
}


class Bar1(override val count:Int):Foo


open class TestVisbilityModifiers{

    private fun f1(){

    }


    protected fun f2(){

    }

    fun f3(){

    }

    internal fun f4(){

    }
}

class TestClass: TestVisbilityModifiers(){

    fun test(){
        f2()
        f3()
        f4()
    }
}


sealed class Response
data class Sucess(val result: String):Response()
data class Error(val error: String):Response()


fun eval(response: Response)=when(response){
    is Sucess->response.result
    is Error->response.error
}