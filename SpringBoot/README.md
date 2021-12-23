# JAVA

## 1. 객체 지향

</br>

## 2. 함수형 인터페이스

### - 인터페이스를 구현하기 위한 단계

</br>

- 인터페이스 A 가 있다고 가정

```java
public interface A {
    void print();
}
```

</br>

### 1. 클래스에서 직접 구현

- implement한 클래스 생성한 후 Override

```java
public class ImplA implements A {
    @Override
    public void print() {
        System.out.println("Hello World !");
    }
}
```

- main 클래스에서 A 객체 생성

```java
public class Main {
    public static void main(String[] args) {
        A a = new ImplA();

        // console로 확인
        a.print();
    }
}
```

### 2. 익명 클래스로 구현

```java
public class Main {
    public static void main(String[] args) {
        // 새로운 클래스를 생성하는 대신 Main 클래스에 바로 작성
        A a = new A(){
            @Override
            public void print() {
                System.out.println("Hello World !");
            }
        };

        // console로 확인
        a.print();
    }
}
```

### 3. 함수형 인터페이스 (람다)

- 메소드가 하나일 때만 가능함 !

```java
public class Main {
    public static void main(String[] args) {
        // 익명 클래스에서 더 간단한 느낌
        A a = () -> {
            System.out.println("Hello World !");
        };

        // console로 확인
        a.print();
    }
}
```
