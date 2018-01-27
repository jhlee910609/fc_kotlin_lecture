# <실무에 바로 적용하는 Kotlin>
### 1. First Week
##### 1.1. What is the Kotlin?
- `OOP`와 `FP` 둘 다 가능한 멀티 패러다임 언어
- `JetBrains`에서 개발한 언어 
- JVM에서 실행되는 언어
- JAVA와 100% 호환 (점진적으로 확대 적용 가능)
- Google I/O에서 Android 공식언어
- Spring 5에서 공식 지원
- [Official trial site](https://try.kotlinlang.org/#/Examples/Hello,%20world!/Simplest%20version/Simplest%20version.kt)

##### 1.2. FP(Functional Programming)
- Functional Programming이란 OOP와 전혀 다른 개념이 아니다.
- OOP를 잘 이해하고 있어야 FP를 잘 사용할 수 있다.
- `Immutable`한 자료구조를 사용해 Side effect 최소화
- 상태를 바꾸기 보다는 변경 불가능한 데이터와 순수 함수를 이용한 프로그래밍
- 모든 것은 객체다. (func도 object)

### 2. 변수
##### 2.1. `var`과 `val`
```kotlin
// 1. data type 명시 가능
var testInt : Int = 32

// 2. data type 명시 X
// 2.1. auto 추론 O
var testInt = 32
```
- fp 해보고 싶거나 sideEffect를 피하고 싶다면 var보다는 val을 사용하는 습관이 좋다.
- 변수 선언 시 : **타입**을 생략하면 컴파일러가 추론한다. 하지만 명시적으로 타입을 선언해 주는 게 가독성이나 유지보수 측면에 좋다. > kotlin이 익숙하지 않은 초반에는 타입을 명시해주는 것이 좋다. 

### 3. 함수
``` java
// 1.1. basic
// func	// @param			// return type
fun add(x: Int, y: Int) : Int {
	return x+y
}


// 1.2. shorten > 사용 가능 
fun add(x: Int, y: Int) : Int = x+y 

```
- `fun` 키워드 사용
- 함수의 반환 타입을 생략할 수 없음. 반환 타입이 Unit 경우에 생략 가능
- Unit은 Java의 Void와 비슷하게 생각하면 된다, 실제로 Unit은 Signleton 객체다.
- `return type`을 생략할 경우, default로 Unit 간주 
- 함수의 body가 한 줄인 경우에 {...} 대신 = 로 대신 가능
- class나 object 내부에 선언하지 않고 **파일 레벨**에 선언할 수 있음
- > util 성 함수들 처리할 때 좋음


### 4. 1급 객체
- 객체의 인자로 전달할 수 있어야 한다.
- 객체의 반환값으로 반환할 수 있어야 한다.
- 자료구조에 넣을 수 있어야 한다.
- java의 클래스는 1급 객체라고 말할 수 있다.
- kotlin의 함수는 1급 객체라고 말할 수 있다.

### 5. Pure Function
- call할 때마다 도출하는 output이 같다.
- 상태가 없고, 아웃풋이 예상 가능해야한다. 

```java
fun pureFucntion(str : String) : Stint {
	return str + "test"
}

```


### 6. Higher-Order Function > [자료](https://medium.com/@lazysoul/high-order-function-%EA%B3%A0%EC%B0%A8%ED%95%A8%EC%88%98-22b147d0c4a5)

- 함수를 파라미터로 전달 받거나, 함수를 리턴하는 함수를 말한다.


### 7. CallByValue
```java 
val function : () -> Unit = { println("Kotlin") }
// parameter에 대한 결과값을 도출
fun callByValue() : Unit {
	return function()
}
```

### 8. CallByName
- 상황에 따라 특정 함수를 호출할 수도 있고, 호출하지 않을 수 있다면 함수의 평가를 Lazy하게 효율적으로 처리할 수 있음
- 함수 처리되는 시점이 콜된 시점에 이미 결과를 다 계산해놓는데, CallByName의 경우 함수를 넘겨 놓고, 처리되는 시점을 컨트롤하여 lazy하게 접근할 수 있다. 효율이 좋아진다. (thread 혹은 res가 많이 드는 작업의 경우, java에 비해 훨씬 유리) 

```
fun callByName() : () -> Unit {
	return function
}
callByName() // nothing
callByName().invoke() // Kotlin
callByName()() // Kotlin
```







