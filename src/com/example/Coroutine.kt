package com.example

import kotlinx.coroutines.experimental.*
import kotlin.coroutines.experimental.coroutineContext
import kotlin.system.measureTimeMillis


fun main(string: Array<String>)= runBlocking {

    // myFirstCoroutine()


    //println("Hello,")
   // waitingForJob().join()

    //lightWeightFun()

    //demonThread()

   // cancelCoroutine()

    //coOperative()

    //isActiveSuspendFunction()

   // handleCancellationException()

    //nonCancellableBlock()

    //withTimeOutTest()

   // withTimeOutWithResult()

    //sequentialFunCalls()

   // asyncFunCalls()

   // asyncStyleFunTest()
    
    dispatchers()

}



private suspend fun dispatchers(){

    val jobs= arrayListOf<Job>()

    jobs+= launch(Unconfined) {  println("Unconfined: I am running on ${Thread.currentThread().name}") }

    jobs+= launch(coroutineContext) {  println("coroutineContext: I am running on ${Thread.currentThread().name}") }

    jobs+= launch(CommonPool) {  println("CommonPool: I am running on ${Thread.currentThread().name}") }

    jobs+= launch(newSingleThreadContext("MyOwnThread")) {  println("Unconfined: I am running on ${Thread.currentThread().name}") }

    jobs.forEach { it.join() }

}


private suspend fun asyncStyleFunTest(){

    val  time= measureTimeMillis {
        val one= asyncGetFirstNumber()
        val two= asyncGetSecondNumber()
        runBlocking {
            println("The answer is ${one.await() + two.await()}")
        }
    }
    println("Time taken in ms $time")
}




private suspend fun asyncFunCalls(){

    val  time= measureTimeMillis {
        val one= async {  getFirstNumber()}
        val two= async {  getSecondNumber()}
        println("The answer is ${one.await() + two.await()}")
    }
    println("Time taken in ms $time")
}



private fun asyncGetFirstNumber() = async {
    getFirstNumber()
}

private fun asyncGetSecondNumber()= async {
    getSecondNumber()
}


private suspend fun getFirstNumber():Int{
    delay(1000L)
    return 23
}

private suspend fun getSecondNumber(): Int{
    delay(1000L)
    return 25
}


private suspend fun sequentialFunCalls(){
    val  time= measureTimeMillis {

        val one= getFirstNumber()
        println("First $one")
        val two= getSecondNumber()
        println("Second $two")
        println("The answer is ${one + two}")
    }
    println("Time taken in ms $time")
}





private suspend fun withTimeOutWithResult(){

   val result= withTimeoutOrNull(1500L){
        repeat(1000){
            i-> println("I am sleeping $i...")
            delay(500L)
        }
        "Done"
    }

    println("Result =$result")

}


private suspend fun withTimeOutTest(){

    withTimeout(1500L){
        repeat(1000){
            i-> println("I am sleeping $i...")
            delay(500L)
        }
    }

}



private suspend fun nonCancellableBlock(){


    val job= launch {

        try{
            repeat(1000){
                i-> println("I am sleeping $i .....")
                delay(500L)
            }
        }finally {
            withContext(NonCancellable){
                println("I am running finally")
                delay(1000L)
                println("And I've just delayed for 1 sec because I'm non-cancellable")
            }
        }

    }
    delay(1500L)
    println("I am tired of waiting...")
    job.cancelAndJoin()
    println("Now i can quit")

}





private suspend fun handleCancellationException(){


    val job= launch {

        try{
            repeat(1000){
                i-> println("I am sleeping $i .....")
                delay(500L)
            }
        }finally {
            println("I am running finally.")
        }

    }
    delay(1500L)
    println("I am tired of waiting...")
    job.cancelAndJoin()
    println("Now i can quit")

}



private suspend fun  isActiveSuspendFunction(){

    val startTime=System.currentTimeMillis()
    val job= launch {

        var nextTime=startTime
        var i=0
        while (isActive){
            if(System.currentTimeMillis()>=nextTime){
                println("I am sleeping ${i++} ..")
                nextTime+=500L
            }
        }
    }
    delay(1500L)
    println("I am tired of waiting...")
    job.cancelAndJoin()
    println("Now i can quit")
}


private suspend fun  coOperative(){

    val startTime=System.currentTimeMillis()
    val job= launch {

        var nextTime=startTime
        var i=0
        while (i<10){
            if(System.currentTimeMillis()>=nextTime){
                println("I am sleeping ${i++} ..")
                nextTime+=500L
            }
        }
    }
    delay(1500L)
    println("I am tired of waiting...")
    job.cancelAndJoin()
    println("Now i can quit")
}


private suspend fun cancelCoroutine(){

    val job= launch {

        repeat(1000){
            i-> println("I am sleeping $i .....")
            delay(500L)
        }
    }
    delay(1500L)
    println("I am tired of waiting...")
    job.cancel()
    job.join()
    println("Now i can quit")


}



private suspend fun demonThread(){
    launch {
        repeat(1000){
            i-> println("I am sleeping $i")
            delay(500L)
        }
    }
    delay(1300L)
}



private suspend fun lightWeightFun(){
    val job= List(100_00){
        launch {
            delay(2000L)
            print(".")
        }
    }
    job.forEach { it.join() }
}




private fun waitingForJob(): Job{
    return launch {
        delay(1000L)
        println("waitingForJob")
    }
}


private suspend fun myFirstCoroutine() {
    launch {
        delay(1000L)
        println("World")
    }
    println("Hello,")

    delay(2000L)
}