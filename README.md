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

### 9. Null
- 타입 뒤에 ?가 오면 해당 타입은 nullable
- ?가 붙은 Data는 항상 null check


익명함수 내부에서는 마지막 값을 반환한다.
- if else 항상 반환한다.
- {} 블럭으로 있을 경우 마지막 줄의 값을 반환함
- if, else을 표현식으로 사용할 경우에는 if가 있으면 else가 항상 있어야함
**- kotlin에서 if/else는 표현식이다. ~~~~**

### 10. Any
- 최상위 객체인 Object 의미 (in Java)

### 11. for each
```java
for((index, value) 
```
- kotlin for loop, list.withIndex()
### 12. Property
- 자바의 맴버변수와 같은 역할
- val 은 set 안됨
- var 

// 그냥 필드 
class Person(firstName : String, lastName : String, age: INt)

// property 
class Person2(val .... )


- 생성자 호출 후, init 함수 호출 
- 생성자 오버로딩
- data class : 제약사항 존재 / default value
- distructing
- copy 
- enum class, sealed class( interface와 비교하기 ) -> 대수적 타입이다
- enum 굉장히 flat, sealed class -> 다양한 타입 // 다양한 타입을 처리해야하는 경우, compile 단에서 에러 체크가 가능하므로 유용하게 사용할 수 있다. 
- kotlin class ( defalut is final ) // open과 abstract는 차이가 있다
- lambda -> interface가 하나일 경우에만 가능 // 파라미터 하나면 생략 

- `joinToString()`
- 확장함수 
- 라이브러리에 함수 추가 확장하여 사용
- 마지막 인자가 함수면 밖으로 뺄 수 있다 
- [standard lib](https://academy.realm.io/kr/posts/kotlin-let-run-apply-lateinit/)
- apply와 with 거의 비슷하다
- it // this ;; 
- standard 코드 까보면 람다식 반환하는 흐름을 익히며 좋음 
- syntax, standar lib
- use :  stream closable -> .close(); // file io
- reapeat :
- range


http://tourspace.tistory.com/56
http://blog.import.re/post/kotlin-let-apply-run-with-use/
https://academy.realm.io/kr/posts/kotlin-let-run-apply-lateinit/
http://kunny.github.io/lecture/kotlin/2016/07/06/kotlin_let_apply_run_with/


### Collections (default immutable)
- element들에 대한 update 
- val/var 
##### 1.1. Mutable
##### 1.2. Immutable
- ex) `List<Int>`, `List<String>`
- `.plus()` = 새로운 인스턴스 반환 
- 비효율적 x, 같은 자료를 사용함


- fold : 재귀적으로 돌아감 
- take, take last
- Mapping operation ( map // T -> R 타입변환 )
- flatMap ( boxing data -> making list in list )
- groupBy()
- elementOrNull()
- 



### 코틀린 파일 level에서 코드작성 가능하다

- `@file:JvmName("MyUtils")` : 컴파일러가 CallKotilnKt object 자동 생성
- `@file:JvmMultifileClass` : 해당 각기 다 `.kt` 파일에 이름을 붙힌다. 
- `@JvmField` : 해당 어노테이션을 사용하면 java에서도 kotlin의 property로 접근할 수 있다. // 일반 프로퍼티에서만 사용가능하다. 
-  `companion object` : 클래스 이름과 같은 obj를 생성한다. // static 성 프로퍼티들 
-  `@JvmField` : var에만 사용할 수 있음 
-  `companion object` : Java 때.... ㅜ 
-  `@JvmOverload` : 
-  calling java code in kotlin : get, set prefix가 있어야 프로퍼티로 호출 가능하다. 
-  kotlin 예약어들 사용할 때, 근데 java에선 그렇지 않을 경우 ex) objectSet, in, is.. `is` 붙혀줘야함  
-  java 클래스 던지기 => Intent(cxt, Activity::class.java)


### Delegates
- lazy 관련된 것들의 문제는 호출시점이 명확하지 않기 때문에 라이프 사이클을 항상 생각해야한다. 
##### 1.1. by lazy
- `by lazy` : 최초 call 후, 결과값이 같으면 최초 결과를 캐싱해놓았다가 반환한다. resource 관리에 효과적이다. 빈번하게 호출하는데, 리소스를 많이 잡아먹을 경우에 해당된다.
- life cycle 생각하고, `lateinit`, `by lazy` 사용할 때 주의해야함!!!!!
- 다른 결과값을 반환할 경우에 사용하면 안됨 
- call 되는 시점의 확신이 있을 때 사용하면 좋다!  
- by lazy는 val에서만 사용가능 -> 콜될 때, 캐싱


##### 1.2. lateinit
- 무조건 한 번은 셋이 될 거고, 값이 있는 상태에서 사용할 거야
- 캐싱되지 않음 


### 함수적 자료구조
- 함수적 자료구조 = 오직 순수 함수로만 조작되는 자료구조
- data	변경, 기타 side effect 발생 x
- 함수적 자료구조 불변





















