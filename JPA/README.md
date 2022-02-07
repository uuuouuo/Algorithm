# JPA

- Java Persistennce API
- 자바 진영의 ORM 기술 표준

  - ORM (Object-relational Mapping)

- JPA 동작 설명
  ![image](https://user-images.githubusercontent.com/89640705/151112173-204cdb89-9586-450d-96dc-90f98ef8ab85.png)
  ![image](https://user-images.githubusercontent.com/89640705/151112215-b99be765-fb70-4f5a-a00f-30e91bd12d0f.png)
  ![image](https://user-images.githubusercontent.com/89640705/151112238-bbeebc3f-445e-4721-a825-5eced2103c9d.png)

- JPA 생산성  
  ![image](https://user-images.githubusercontent.com/89640705/151113473-bdbfc35b-860c-47f4-92e3-6b0f660a1e70.png)

  - 특히 update 유용

- 주의할 점

  1. 엔티티 매니저 팩토리는 하나만 생성해서 애플리케이션 전체에서 공유
  2. 엔티티 매니저는 쓰레드간 공유 X
  3. JPA의 모든 데이터 변경은 트랜잭션 안에서 실행 🎇

## application.property

- DB 설정
  > spring.datasouce.url=  
  > spring.datasource.driverClassName=  
  > spring.datasource.username=  
  > spring.datasource.password=
- JPA 설정
  > spring.jpa.hibernate.ddl-auto=update  
  > spring.jpa.generate-ddl=true  
  > spring.jpa.show-sql=true  
  > spring.jpa.database=h2  
  > spring.jpa.database-platform=

## JPA dependency

> implementation 'org.springframework.boot:spring-boot-starter-data-jpa'

- 추가적 기본 세팅
  >

## JPA Annotation

- @Entity
  - JPA 관리
- @Table(name = "테이블 명")
  - 생성안하면 class 이름으로
- @Column
  - ENtity 클래스에 정의된 모든 내부변수는 기본적으로 @Column 어노테이션 포함, name 속성 명시하지 않으면 변수 이름으로 생성
    - insertable=false : insert 시점에 막는 기능
    - updatable=false : update 시점에 막는 기능
    - ex) @Column(insertable = false, updatable = false)
- @Id: PK
- @GeneratiedValue(strategy = GenerationType.IDENTITY)
  - MySql에서 auto increment 명시 (유일값)
- @JsonIgnore
  - 응답페이지에서 숨김
- @Embeddable
  - 임베디드 타입 명시 (복합키 명시)
- @Embedded
  - Entity에서 복합키 명시
- @NoargsConstructor(AccessLevel.PROTECTED)
  - 기본 생성자의 접근 제어를 PROTECTED로 설정해놓게 되면 무분별한 객체 생성에 대해 한번 더 체크
- @NotNull
  - null만 허용하지 않음
  - "" 나 " " 는 허용
- @NotEmpty
  - null 과 "" 둘 다 허용하지 않음
  - " " 는 허용
- @NotBlank
  - null, "", " " 모두 허용하지 않음
- @Builder
  - 생성자에 명시
- @RequiredArgsConstructor

  - 어노테이션을 통해 생성자 주입 가능

  ```java
   private final IBoardItemService boardItemService;

   // 기존 생성자 생성 방법
   public BoardController(IBoardItemService boardItemService) {
       this.boardItemService = boardItemService;
  }
  ```

- @Transactional
  - 트랜잭션 기능이 적용된 프록시 객체가 생성
  - readOnly 속성
    - 트랜잭션 읽기 전용
    - 성능 최적화를 위해 사용, 특정 트랜잭션 작업 안에서 쓰기 작업이 일어나는 것을 의도적으로 방지
