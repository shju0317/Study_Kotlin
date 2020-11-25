package com.biz.hello

fun main(){
    val intNum : Int  = 123
    val binNum : Int = 0b1001001 //2진수
    val hexNum : Int  = 0xF0 // 16진수

    val oneMillion = 1_000_000
    val creditCardNum = 123_5678_9000_0525L
    var hexByte = 0xFF_FC_F1_F0
    var binByte = 0b0100_1001_1111_0000

    var num1 : Int = 10
    var num2 : Int = 20
    var num3 : Long = (num1 + num2).toLong()
    num3 = num1.toLong() + num2.toLong()

    var num4 : Long = num3 + num2

    var asciiA : Int = 'A'.toInt()
    println("문자 A의 ASCII코드 : $asciiA")

    var charA : Char = 'A'.toChar()
    println("문자 A의 Char문자 : $charA")

}