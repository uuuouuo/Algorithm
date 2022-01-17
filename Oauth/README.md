# Spring Boot Oauth2 소셜 로그인 가이드

- Oauth2
  - 보안수준이 어느정도 검증된 플랫폼의 API를 이용하여 사용자 인증과 리소스에 대한 권한 획득(인가)을 할 수 있도록 해주는 역할
  - OAuth 구성 요소
    1. Resource Owner: 사용자
    2. Client: 리소스 서버에서 제공해주는 자원을 사용하는 외부 플랫폼
    3. Authorization Server: 외부 플랫폼이 리소스 서버의 사용자 자원을 사용하기 위한 인증 서버
    4. Resource Server: 사용자의 자원을 제공해주는 서버
    - ex) 페이스북 로그인 기능을 지원하는 외부 플랫폼에 로그인 하려고 할 때,
    1. 외부 플랫폼을 통해 페이스북 인증 서버(Authorization Server)에 인증 요청
    2. 외부 플랫폼은 저의 페이스북 정보들(이름, 나이, 프로필 사진 등)을 사용할 수 있는 권한을 얻음
  - 인증 종류
    1. Authorization Code Grant: 권한 코드 승인 방식
    2. Implicit Grant: 암시적 승인 방식
    3. Password Credentials Grant: 비밀번호 자격 증명 방식
    4. Client Credentials Grant: 클라이언트 자격 증명 방식
- Spring Security

  - Spring 기반의 어플리케이션 권한과 인증, 인가 등의 보안을 담당하는 하위 프레임워크
  - 스프링 시큐리티는 인증과 권한을 Filter 흐름에 따라 처리하게 구현되어 있음
  - 이미 대부분의 보안적인 로직들이 포함되어 있어 개발자가 추가로 개발하지 않아도 된다는 장점

- kakao 소셜 로그인 예제

  1. build.gradle 에 dependency 추가

     ```java
     implementation 'org.springframework.boot:spring-boot-starter-security'
     implementation 'org.springframework.boot:spring-boot-starter-oauth2-client'
     ```

  2. application-oauth.properties 추가

     ```
     #KAKAO
     spring.security.oauth2.client.registration.kakao.client-id = [클라이언트 id]
     spring.security.oauth2.client.registration.kakao.client-secret = [클라이언트 pw]
     spring.security.oauth2.client.registration.kakao.redirect-uri=http://localhost:8080/login/oauth2/code/kakao
     spring.security.oauth2.client.registration.kakao.authorization-grant-type=authorization_code
     spring.security.oauth2.client.registration.kakao.scope=profile,account_email
     spring.security.oauth2.client.registration.kakao.client-name=kakao
     spring.security.oauth2.client.registration.kakao.client-authentication-method=POST

     # kAKAO Provider 등록!
     spring.security.oauth2.client.provider.kakao.authorization-uri= https://kauth.kakao.com/oauth/authorize
     spring.security.oauth2.client.provider.kakao.token-uri=https://kauth.kakao.com/oauth/token
     spring.security.oauth2.client.provider.kakao.user-info-uri=https://kapi.kakao.com/v2/user/me
     # 카카오가 회원정보를 json으로 넘겨주는데, id라는 키값으로 리턴해준다.
     spring.security.oauth2.client.provider.kakao.user-name-attribute=id
     ```

  3. appliction.properties에 application-oauth.properties 명시

     - application-XXX.properties 의 XXX 부분 적기

     ```
     # application-oauth.properties
     spring.profiles.includes = oauth
     ```

  4. SecurityConfig.java 파일 생성
