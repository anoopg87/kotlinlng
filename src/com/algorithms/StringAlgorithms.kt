package com.algorithms


fun main(args: Array<String>){

    printDuplicateChar("Programming")

}


fun printDuplicateChar(str:String){
    
    val charMap=HashMap<Char,Int>()
   for(chr in str){
       if(charMap.containsKey(chr))
           charMap[chr] = charMap[chr]!!.plus(1)
       else
           charMap[chr] = 1
   }
    for ((k,v) in charMap){
        if (v>=2)
            println("$k -> $v")
    }


}
