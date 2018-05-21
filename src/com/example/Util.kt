package com.example

fun <T:Any?> T?.isNotNull(block:T.()->Unit)=this?.let(block)

fun <T:Any?> whenNotNull(r:T, block: T.() -> Unit)= r?.let(block)

fun <T:Any?>T?.isNotNull():Boolean= null!=this

fun <T:Any,R:Any>T.mapTo(block: T.() -> R):R=block()


