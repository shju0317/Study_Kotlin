package com.biz.hello

// 다형성

fun main(){
    var sum = add(100, 200)
    println(sum)

    println(add(3.5F, 4.5F))
    println(add("안","녕"))
}

fun add(num1 : Int, num2 : Int) : Int{
    return num1 + num2
}

fun add(num1 : Float, num2 : Float) : Float{
    return num1 + num2;
}

fun add(str1 : String, str2 : String) : String{
    return str1 + str2
}