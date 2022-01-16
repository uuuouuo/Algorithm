# JPA

## JPA dependency

- implementation 'org.springframework.boot:spring-boot-starter-data-jpa'

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

  ```java
   private final IBoardItemService boardItemService;

   // 기존 생성자 생성 방법
   public BoardController(IBoardItemService boardItemService) {
       this.boardItemService = boardItemService;
  }
  ```

  - 어노테이션을 통해 생성자 주입 가능

- @Transactional
  - 트랜잭션 기능이 적용된 프록시 객체가 생성
  - readOnly 속성
    - 트랜잭션 읽기 전용
    - 성능 최적화를 위해 사용, 특정 트랜잭션 작업 안에서 쓰기 작업이 일어나는 것을 의도적으로 방지
