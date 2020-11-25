package com.biz.hello

fun main(){
    // 연산의 중위표기법으로 만들기
    // Int클래스에 원래는 없는 multi라는 함수를 추가하고
    // 추가된 함수를 사용하여 연산을 수행하는 코드
    // js 프로토타입을 흉내낸 코드
    fun Int.multi(value:Int) = this * value

    var num = 30.multi(30)
}