package com.biz.hello

fun main(){
    
    // KT에서는 자료형이 지정되지 않은 변수에 null값을 저장하면 안된다
    // 반드시 자료형을 지정하고 자료형 뒤에 ? 첨가해야 한다
    var anyVar1 : Int? = null
    println(anyVar1)
    
    // Any키워드는 모든 타입의 값을 저장할 수 있는 변수
    // Object 타입 변수
    var anyVar2 : Any = 123
    anyVar2 = "Korea"
    anyVar2 = 30.2F
    
    // any type에 저장된 값의 자료형은 무엇인가?
    when(anyVar2){
        is String -> println("문자열형")
        is Int -> println("int형")
        is Float  -> println("float형")
        is Double  -> println("double형")
        else -> println("몰라아")
    }
}