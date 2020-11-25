package com.biz.hello

// 내부적으로 생성자, getter, setter, ToString이 기본적으로 만들어지고
// equals(), hashCode(), copy(), componentN() 메서드가 생성
data class BookVO(var title:String, var author:String, var comp:String, var price:Int){}
data class UserVO(var name:String="", var tel:String="", var age:Int=0)

fun main(){
    // 생성자가 변수 타입만 지정된 data class는 빈 값으로 객체를 생성할 수 없다
    // var bookVO = BookVO()
    var bookVO = BookVO("코틀린","나","출판사",20000)
    bookVO.title = "오라클"
    print(bookVO.toString())
    println(bookVO.hashCode())

    // data class를 빈 값의 객체로 생성하려면 클래스 선언문에 default값이 지정되어 있어야 한다
    var userVO = UserVO()
    print(userVO.toString())
    println(userVO.hashCode())
    println("bookVO야 너는 BookVO클래스로부터 만들어진 객체니? ${if(bookVO.equals(BookVO("","","",0))) "맞아" else "아니"}")
    println("userVO야 너는 UserVO클래스로부터 만들어진 객체니? ${if(userVO.equals(UserVO())) "맞아" else "아니"}")
    
    var userVO1 = UserVO(name="이몽룡", age=33)
    var bookVO1 = BookVO(price=12000,author="성춘향", title="제이쿼리", comp="이지즈")
    println(UserVO(name="장보고",tel="1990-0408").toString())

    var userVOCopy = userVO1.copy(name="임꺽정")
    println(userVOCopy.toString())

    // var title = bookVO1.title
    // var author = bookVO1.author
    var(title,author) = bookVO1
    println("$title, $author")
    
    var (first, second) = Pair("홍길동", "이몽룡")
    var (f,s,t) = Triple("010",1209, 0718)
}

class StaticClass{
    companion object NAVER_KEY{
        var ID = "1234567"
        var SECURITY = "000111000"
    }
}