# 풀스택 503반
## JSP 수업 자료

---

1. 1일차 수업 (jsp_20241226)
    	1. javascript 기본 문법 (변수, 데이터 타입, 연산자, 제어문, 반복문, 함수)
2. 2일차 수업 (jsp_20241227)
	1. jsp 기본 파일 구조, 디렉티브 태그
	2. page 디렉티브 태그 속성 (import, 오류 처리, try ~ catch, errorPage, isErrorPage, trimDirectiveWhitespace)
	3. include 디렉티브 태그 (include로 파일 다른 파일 포함하기)
	4. 스크립트 태그 (선언부, 스크립틀릿, 표현식)
	5. request 내장 객체 (환경 정보 읽기, 전달 데이터 가져오기, 헤더정보읽기)
3. 3일차 수업 (jsp_20241230)
	1. response 내장 객체 (sendRedirect, header 정보 저장)
	2. out 내장 객체 (print, println, out, flush, clearBuffer, getRemaining)
	3. application 내장 객체 (getInitParameter, getRealPath)
	4. 내장 객체에 데이터 저장, 사용 (pageContext)
	5. 내장 객체에 데이터 저장, 사용 (request)
	6. 내장 객체에 데이터 저장, 사용 (session)
	7. 내장 객체에 데이터 저장, 사용 (application)
4. 4일차 수업 (jsp_20241231)
	1. 쿠키사용하기 (쿠키정보설정, 쿠키정보읽기, 쿠키를 사용한 팝업창)
	2. JSP와 MySql 연동하기 (JDBC 드라이버 추가, JDBC 연결 테스트)
	3. JDBC 사용방법 3가지 (DB접속 JSP 파일 호출, DB접속용 Class 파일 사용, web.xml 파일 사용)
5. 5일차 수업 (jsp_20250102)
	1. 커넥션 풀 사용하기 (server.xml을 사용한 방식, context.xml 만 사용한 방식)
	2. Statement로 데이터 추가, 수정, 삭제하기
	3. Statement로 데이터 조회하기
	4. PreparedStatement로 데이터 추가하기
	5. PreparedStatement로 데이터 조회하기 (설명은 내일)
6. 6일차 수업 (jsp_20250103)
	1. PreparedStatement로 데이터 조회하여 html 화면에 출력하기 설명
	2. 세션 사용하기
	3. 세션을 사용한 로그인 폼, 로그인 처리, 로그인 성공, 로그인 실패, 로그아웃 페이지
	4. DTO, DAO 를 사용한 로그인, 로그인 처리
	5. DTO, DAO 를 사용한 회원 가입, 회원가입 처리, 회원 가입 성공, 회원 가입 실패 페이지
7. 7일차 수업 (jsp_20250106)
	1. JSP 게시판 만들기 (게시판 DB 설계)
	2. JSP 게시물 목록 페이지
	3. JSP 게시물 쓰기 페이지
	4. JSP 게시물 상세 페이지
8. 8일차 수업 (jsp_20250107)
	1. JSP 게시물 삭제, 조회수 업데이트
	2. JSP 게시물 수정 페이지
	3. 액션태그 (include, forward)
	4. 액션태그 (useBean, getProperty, setProperty)
	5. 액션태그 (param
9. 9일차 수업 (jspMemberBoard)
	1. JSP 회원제 게시판 DB 설계
	2. JSP 회원제 게시판 (JSFunction)
	3. JSP 회원제 게시판 (JDBConnect, JSPBoardDTO, JSPBoardDAO, JSPMemberDTO, JSPMemberDAO)
	4. JSP 회원제 게시판 process 파일 생성 (EditProcess, DeleteProcess, WriteProcess, LoginProcess, MemberJoinProcess, LogoutProcess)
	5. JSP 회원제 게시판 layout 파일 생성 (Header, Footer, Menu)
	6. JSP 회원제 게시판 View 파일 생성(List, View, Edit, Write, Login, MemberJoin), List 페이지 목록 출력
10. 10일차 수업 (jspMemberBoard)
	1. JSP 회원제 게시판 View 파일 내용 완성 (Edit, View)
	2. JSP 회원제 게시판 process 파일 완성 (EditProcess, DeleteProcess, WriteProcess, LoginProcess, MemberJoinProcess, LogoutProcess)
	3. JSP 회원제 게시판 로그인 체크 파일 생성 및 적용(LoginCheck)
	4. JSP 회원제 게시판 각 페이지마다 Header 에 다른 이름이 나오도록 수정, layout 파일 include 설정
	5. JSP 회원제 게시판 주석 추가
11. 11일차 수업 (jspMemberBoard)
	1. JSP 회원제 게시판 페이징 기능 추가
	2. JSP 회원제 게시판 ajax를 통한 추천수 증가 기능 추가
12. 12일차 수업 (jsp_20250110)
	1. JSP 파일 업로드 (DB설정, DAO, DTO, JSFunction 클래스 추가)
	2. JSP 파일 업로드 (파일 업로드 폼 페이지, 파일 업로드 처리 페이지, 파일 업로드 리스트 페이지)
	3. JSP 파일 업로드 (파일 업로드 처리를 위한 FileUtil 클래스)
	4. JSP 파일 다운로드 
	