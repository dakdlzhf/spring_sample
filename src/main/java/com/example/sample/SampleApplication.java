package com.example.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.*"})
public class SampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleApplication.class, args); //패키지 하위 까지 모든 객체들을찾아서 ioc 생성을 해주는 main 다른패키지면 ComponentScan 을해준다
	}

}

/*
 * - @SpringBootApplication는 스프링 부트의 핵심 어노테이션이며,    
   세 개의 스프링 부트 어노테이션으로 구성되어 있다.

  @EnableAutoConfiguration : 스프링의 다양한 설정을 자동으로 구성한다.
  @ComponentScan : 컴포넌트 클래스를 검색하고 검색된 컴포넌트 및 클래스를
                             스프링 애플리케이션 컨텍스트에 등록한다.
  @Configuration : 자바기반 설정 파일임을 의미한다.(XML설정대신 사용)

- main메소드는 스프링 부트의 SampleApplication.run() 메소드를 사용하여 스프링
  부트 프로젝트 애플리케이션을 실행할 수 있게 한다.
   
  SampleApplication 클래스
 - 스프링 부트 애플리케이션의 구성과 실행을 담당하는 중요한 클래스이다.
 - 스프링 부트의 장점 중 하나는 자동구성으로 기존의 복잡하고 다양한 스프링
   설정을 제거하고 최소한의 설정으로 바로 실행할 수 있는 애플리케이션을
   만들어 준다는 점이다.
      ■ src/main/java 
   - 자바소스 폴더
 
  ■ SampleApplication 
  - 애플리케이션을 시작할 수 있는 main메소드가 존재하는 스프링 구성
    메인 클래스
 
  ■ src/main/resources/static
  - HTML, 스타일 시트, 자바스크립트, 이미지 등의 정적 리소스 폴더

  ■ application.properties  
  - 애플리케이션 및 스프링의 설정 등에서 사용할 여러 가지 프로퍼티(property)정의

  ■ Project and External Dependencies :
  - Gradle에 명시된 프로젝트의 필수 라이브러리 모음   

  ■ src 
  - JSP등 리소스 디렉토리
  
 * */
 