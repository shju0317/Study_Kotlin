package com.biz.hello

import java.util.*

fun main(){
    val scan = Scanner(System.`in`)
    print("구의 반지름을 입력하세요>> ")
    val strRadius = scan.nextLine()
    val dRadius = strRadius.toDouble()
    
    // 구의 면적
    val area : Double = dRadius * Math.PI * 4.0
    
    // 구의 부피
    val volume : Double = dRadius * dRadius * (4/3).toDouble() * Math.PI

    println("반지름이 $dRadius 인 구의 면적 : $area, 부피 : $volume")
    
}