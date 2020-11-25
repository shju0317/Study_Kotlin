package com.biz.hello

fun main(){
    var intRange : IntRange = 0..100
    print("Range : ${intRange}\t")
    for(i in intRange){
        print("$i \t")
    }
}