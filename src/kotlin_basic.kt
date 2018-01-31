enum class Position {
    TOP,
    BOTTOM,
    MID,
    JUNGLE
}

fun main(args: Array<String>) {

    var name = "junhee"
    println(name)
    println(add_1(13, 12, { x, y -> x - y }))

    val sum: (Int, Int) -> Int = { a, b -> a + b }
    val minus: (Int, Int) -> Int = { a, b -> a - b }
    val multiple: (Int, Int) -> Int = { a, b -> a * b }

    // higher-order function
    // 함수를 리턴 받거나, 함수를 파라미터로 받는 함수
    println(simpleHigherOderFunc(sum, 2, 10))
    println(simpleHigherOderFunc(minus, 20, 10))
    println(simpleHigherOderFunc(multiple, 4, 5))

    // class
    val junhee = Person_1("Junhee, Lee", 28)
    println("name : ${junhee.name}, age : ${junhee.age} ")
    println(checkNumber(23))
}

class Person_1(val name: String, val age: Int) {
    init {
        println("I'm $name. My age is $age")
    }

}

fun checkNumber(num: Int): String =
        if (num % 2 == 0) {
            "짝수"
        } else {
            "홀수"
        }


class Person_2(name: String, age: Int)

fun add_2(x: Int, y: Int): Int = x + y

fun add_1(x: Int, y: Int, calc: (Int, Int) -> Int): Int {
    return calc(x, y)
}

fun simpleHigherOderFunc(calc: (Int, Int) -> Int, x: Int, y: Int): Int {
    return calc(x, y)
}



