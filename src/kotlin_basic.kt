fun main(args: Array<String>) {
    var name = "junhee"
    println(name)
    println(add_1(13, 12, { x, y -> x - y }))

    val sum: (Int, Int) -> Int = { a, b -> a + b }
    val minus: (Int, Int) -> Int = { a, b -> a - b }
    val multiple: (Int, Int) -> Int = { a, b -> a * b }

    println(simpleHigherOderFunc(sum, 2, 10))
    println(simpleHigherOderFunc(minus, 20, 10))
    println(simpleHigherOderFunc(multiple, 4, 5))
}

fun add_2(x: Int, y: Int): Int = x + y

fun add_1(x: Int, y: Int, func: (Int, Int) -> Int): Int {
    return func(x, y)
}

fun simpleHigherOderFunc(calc: (Int, Int) -> Int, x: Int, y: Int): Int {
    return calc(x, y)
}



