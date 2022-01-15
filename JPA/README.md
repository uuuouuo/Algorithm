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
