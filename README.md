# basic-springboot-2024
Java 빅데이터 개발자과정 Spring Boot 학습 리포지토리

## 1일차
- Spring Boot 개요
	- 개발환경, 개발 난이도를 낮추는 작업
	- Servlet > EJB > JSP > Spring(부흥기!) > Spring Boot(끝판왕!!)
	- 장점
		- Spring 의 기술을 그대로 사용가능(마이그레이션 간단)
		- JPA를 사용하면 ERD나 DB설계를 하지 않고도 손쉽게 DB 생성
		- Tomcat Webserver가 내장(따로 설치필요X)
		- 서포트 기능 다수 존재(개발을 쉽게 도와줌)
		- JUnit 테스트, Log4J2 로그도 모두 포함
		- JSP, **Thymeleaf**, Mustache 등... 편하게 사용가능
		- DB 연동이 무지 쉽다

	- MVC
		<img src="https://raw.githubusercontent.com/hugoMGSung/basic-springboot-2024/main/images/sp002.png" width="730">

- Spring Boot 개발환경 설정
	- Java JDK 확인 > 17버전 이상
		- https://jdk.java.net/archive/
		- 시스템 속성 > 고급 > 환경변수 중 JAVA_HOME 설정
		
	- Visual Studio Code
		- VSCodeUserSetup-x64-1.90.0.exe 아님 설치하지 말것
		- VSCodeSetup-x64-1.90.0.exe 로 설치할 것
		- Extensions > Korean 검색, 설치		
		- Extensions > Java 검색, Extension Pack for Java 설치
			- Debugger for Java 등 여섯개 확장팩이 같이 설치
		- Extensions > Spring 검색, Spring Extension Pack 설치
			- Spring Initializr Java Support 등 3개 확장팩 같이 설치
		- Extensions > Gradle for Java 검색, 설치
	- Gradle build tool 설치 고려
		- https://gradle.org/releases/
	- Oracle latest version Docker - 보류

- Spring Boot 프로젝트 생성
	- 메뉴 보기 > 명령 팔레트(Ctrl + Shift + P)
		- Spring Initializr: Create a Gradle Project...
		- Specify Spring Boot version : 3.2.6
		- Specify project language : Java
		- Input Group Id : com.hugo83 (개인적 변경할 것)
		- Input Artifact Id : spring01 (대문자 불가!)
		- Specify packaing type : Jar
		- Specify Java version : 21
		- Choose dependencies : Selected 0 dependencies 
		- 폴더 선택 Diaglog 팝업 : 원하는 폴더 선택 Generate ... 버튼 클릭
		- 오른쪽하단 팝업에서 Open 버튼 클릭 
		- Git 설정 옵션, Language Support for Java(TM) by Red Hat 설정 항상버튼 클릭

	- TroubleShooting
		1. 프로젝트 생성이 진행되다 Gradle Connection 에러가 뜨면,
			- Extensions > Gradle for Java를 제거
			- VS Code 재시작한뒤 프로젝트 재생성
		2. Gradle 빌드시 버전 에러로 빌드가 실패하면
			- Gradle build tool 사이트에서 에러에 표시된 버전의 Gradle bt 다운로드 
			- 개발 컴퓨터에 설치
		3. ':compileJava' execution failed... 
			- JDK 17 ..... error 메시지
			- Java JDK 잘못된 설치 x86(32bit) x64비트 혼용 설치
			- eclipse adoptium jdk 17 새로 설치, 시스템 환경설정
			- VS Code 재시작
			- build.gradle SpringBoot Framework 버전을 다운 3.3.0 -> 3.1.5

	- 프로젝트 생성 후
		- /build.gradle 확인
		- src/main/resources/application.properties(또는 .yml) 확인
		- src/java/groupid/arifactid/ Java 소스파일 위치, 작업
		- src/main/resources/ 프로젝트설정 파일, 웹 리소스 파일(css, js, html, jsp, ...)
		- Spring01Application.java,  Run | Debug 메뉴 
		- Gradle 빌드
			- 터미널에서 .\gradlew.bat 실행
			- Gradle for java(코끼리 아이콘) > Tasks > Build > Build play icon(Run task) 실행
		- Spring Boot Dashboard 
			- Apps > Spring01 Run | Debug 중에서 하나 아이콘 클릭 서버 실행
			- 디버그로 실행해야 Hot code replace 가 동작!!!

				<img src="https://raw.githubusercontent.com/hugoMGSung/basic-springboot-2024/main/images/sp001.png" width="350">

		- 브라우저 변경설정
			- 설정 (Ctrl + ,) > browser > Spring>Dashboard Open With 'Internal' -> 'external'로 변경
			- Chrome 을 기본브라우저 사용 추천


## 2일차
- Oracle 도커로 설치
	- Docker는 Virtual Machine을 업그레이드한 시스템
	- 윈도우 서비스 내(services.msc) Oracle 관련 서비스 종료
	- Docker에서 Oracle 이미지 컨테이너를 다운로드 후 실행
	- Docker 설치시 오류 Docker Desktop - WSL Update failed
		- Docker Desktop 실행종료 후
		- Windows 업데이트 실행 최신판 재부팅
		- https://github.com/microsoft/WSL/releases, wsl.2.x.x.x64.msi 다운로드 설치 한 뒤
		- Docker Desktop 재실행
	- Oracle 최신판 설치
	```shell
	> docker --version
	Docker version 26.1.1, build 4cf5afa
	> docker pull container-registry.oracle.com/database/free:latest
	latest: ....
	... : Download complete
	> docker images
	REPOSITORY                                    TAG       IMAGE ID       CREATED       SIZE
	container-registry.oracle.com/database/free   latest    7510f8869b04   7 weeks ago   8.7GB
	> docker run -d -p 1521:1521 --name oracle container-registry.oracle.com/database/free
	....
	> docker logs oracle
	...
	#########################
	DATABASE IS READY TO USE!
	#########################
	...	
	> docker exec -it oracle bash
	bash-4.4$ 
	```

	- Oracle system 사용자 비번 oracle로 설정
	```shell
	bash-4.4$ ./setPassword.sh oracle
	```

	- Oracle 접속확인
		- DBeaver 탐색기 > Create > Connection

- Database 설정
	- Oracle - 운영시 사용할 DB
	- Oracle PKNUSB / pknu_p@ss 로 생성
	- 콘솔(도커 / 일반 Oracle)
	```shell
	> sqlplus system/password
	SQL> select name from v$database;
	// 서비스명 확인
	// 최신버전에서 사용자 생성시 C## prefix 방지 쿼리
	SQL> ALTER SESSION SET "_ORACLE_SCRIPT"=true;
	// 사용자 생성
	SQL> create user pknusb identified by "pknu_p@ss";
	// 사용자 권한
	SQL> grant CONNECT, RESOURCE, CREATE SESSION, CREATE TABLE, CREATE SEQUENCE, CREATE VIEW to pknusb;
	// 사용자 계정 테이블 공간설정, 공간쿼터
	SQL> alter user pknusb default tablespace users;
	SQL> alter user pknusb quota unlimited on users;
	```

	- H2 DB - Spring Boot에서 손쉽게 사용한 Inmemory DB, Oracle, MySql, SQLServer과 쉽게 호환
	- MySQL - Optional 설명할 DB	
	
- Spring Boot + MyBatis
	- application name : spring02
	- Spring Boot 3.3.x 에는 MyBatis 없음
	- Dependency 중 DB(H2, Oracle, MySQL)가 선택되어 있으면 웹서버 실행이 안됨

	- build.gradle 확인
	- application.properties 추가작성
	```properties
	spring.application.name=spring02

	## 포트변경
	server.port=8091

	## 로그색상
	spring.output.ansi.enabled=always

	## 수정사항이 있으면 서버 자동 재빌드 설정
	spring.devtools.livereload.enabled=true
	spring.devtools.restart.enabled=true

	## 로그레벨 설정
	logging.level.org.springframework=info
	logging.level.org.zerock=debug

	## Oracle 설정
	spring.datasource.username=pknusb
	spring.datasource.password=pknu_p@ss
	#spring.datasource.url=jdbc:oracle:thin@localhost:1521:XE 
	spring.datasource.url=jdbc:oracle:thin@localhost:11521:FREE
	spring.datasource.driver-class-name=oracle.jdbc.OracleDriver

	## MyBatis 설정
	## mapper 폴더 및에 여러가지 폴더가 내재, 확장자는 .xml이지만 파일명은 뭐든지 
	mybatis.mapper-locations=classpath:mapper/**/*.xml
	mybatis.type-aliases-package=com.hugo83.spring02.domain
	```

	- MyBatis 적용 
		- Spring, resource/WEB-INF 위치에 root-context.xml에 DB, Mybatis 설정
		- SPringBoot, application.properties + Config.java 로 변경

	- 개발시 순서
		1. Database 테이블 생성
		2. MyBatis 설정 -> /config/MyBatisConfig.java
		3. 테이블과 일치하는 클래스 