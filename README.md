# Spring_RestApi_BoardProject
- ajax를 이용하여 RestAPI 호출
- js & jqery 를 이용하여 RestApi에서 받아온 값을 처리

## 기능 목록 
* 전체 게시글 페이징
* 단일 게시글 요청시 게시글 정보 표시
  * [예외] 해당 게시글이 없는 경우
* 게시글 입력
* 해당 글의 비밀번호가 같아야 수정/삭제 가능
  * [예외] 비밀번호가 다른 경우

## 관련 dependency 
* OracleDB : https://github.com/jangsehun92/SpringOracleDB
* jackson-databind 추가

<!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind -->
    <dependency>
        <groupId>com.fasterxml.jackson.core</groupId>
        <artifactId>jackson-databind</artifactId>
        <version>2.9.10</version>
    </dependency>
