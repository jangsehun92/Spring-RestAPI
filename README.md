# RestAPI BoardProject
- 사용자가 페이지에 처음 접근할땐 서버에서, 그 이후로는 클라이언트에서 HTML을 그리는 Universal Rendering 방식 으로 구현
- ajax를 이용하여 RestAPI 호출
- js & jqery 를 이용하여 RestApi에서 받아온 JSON데이터 표현

## 기능 목록 
* 전체 게시글 보기
* 페이징 처리
* 단일 게시글 요청시 게시글 정보 표시
* 게시글 입력
* 해당 글의 비밀번호 입력 후 수정/삭제

## form data json 전송
* 프론트 단의 form 데이터를 javaScript를 이용하여 서버로 보낼 때 serializeObject()를 사용하여 json 모양의 object로 보낸다.
* 서버단에서 @RequestBody를 이용하여 데이터를 받고, jackson을 통해 DTO 매핑

## 관련 dependency 
* OracleDB : https://github.com/jangsehun92/SpringOracleDB
* jackson-databind 추가

<!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind -->
    <dependency>
        <groupId>com.fasterxml.jackson.core</groupId>
        <artifactId>jackson-databind</artifactId>
        <version>2.9.10</version>
    </dependency>
