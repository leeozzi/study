# JSP (Java Server Pages)
- Servlet 표준을 기반으로 작성된 웹 어플리케이션 개발 언어
- HTML 내에 Java 코드를 포함하여 동적으로 웹페이지를 생성해 브라우저에게 돌려주는 페이지
- 실행 시 Servlet으로 변환된 후 실행

<br>

# JSP 구성요소
1. 지시자 (Directive)
- JSP에 대한 설정 정보를 지정하기 위해  사용
2. 스크립트 요소  
=> 스크립트릿(Scriptlet), 표현식(Expression), 선언부(Declaration)
- JSP에서 문서의 내용을 동적으로 생성하기 위해서 사용
3. JSP 기본 객체
- 요청 및 응답 관련 정보를 얻거나, 응답 결과를 만들기 위해서 사용
4. 표현 언어 (Expression Language)
- JSP를 좀 더 간결하게 작성하기 위해서 사용
5. Action Tag 와 JSTL
- 자주 사용하는 기능을 모아 미리 정의하여 Tag 형태로 작성한다.  
JSP에서 자바 코드를 쉽게 작성할 수 있도록 사용


# JSP 기본 태그
## JSP 태그 종류 
- <% %> 스크립트릿 : 자바 코드 작성 
- <%! %> 선언 : 변수와 메소드 선언
- <%= %> 표현식 : 계산식이나 함수를 호출한 결과를 문자열 형태로 출력
- <%-- --%> 주석 : JSP 페이지 설명 작성
- <%@ %> 지시자 : JSP 페이지 속성 지정 

### 스크립트릿 <% %>
- 스크립팅 언어(java)로 작성된 코드 조각을 포함하는 데 사용된다
```
<%
    int A = 10;
    int B = 20;
    int sum = A + B;
    out.print(A + "+" + B + "=" + sum);
%>
```

### 선언부 <%! %>
- 멤버 변수 선언이나 메서드를 선언하는 영역
```
<%!
String name = "SSAFY";
public int add(int a, int b) {
    return a+b;
}
%>
```

### 표현식
- 변수의 값이나 계싼식 혹은 함수를 호출한 결과를 문자열 형태로 웹 문서에 출력
- <%=변수%>  
<%=수식%>  
<%=메서드 호출%>
```
<%!
    String name = "양명균";
%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
    <%= name %> <%-- out.print(name) --%>
</body>

</html>
```

###  주석
- 작성한 코드에 대한 설명을 기술할 경우 사용
- HTML 주석문과 동일한 기능을 하지만, HTML 주석은 클라이언트에게 보여지고, JSP 주석은 보여지지 않는다.
```
<!-- 이것은 HTML 주석입니다 -->
<%-- 이것은 JSP 주석입니다 -->
<h1>Hello</h1>
<%= "이언지" %>

<%-- response 내용 --%>
<!-- 이것은 HTML 주석입니다 -->
<h1>Hello</h1>
"이언지"
```

### 지시자
```
<%@ 지시자 속성 = "값" %>
```
- 웹 컨테이너(Tomcat)가 JSP 번역하고 실행하는 방법 서술
- page : 해당 JSP 페이지 전반적으로 환경 설정할 내용 지정
    - JSP 페이지 실행 매개변수를 제어
    - 출력처리, 오류처리 등의 내용을 포함
    ```
    <%@ page language = "java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    ```
    - 속성
        - language  
        : 스크립트에서 사용할 언어 지정 (기본값 java)
        - contentType  
        : JSP가 생성할 문서의 MIME 타입과 캐릭터 인코딩 (기본값 text/html)
        - import  
        : JSP에서 사용할 Java 클래스 지정
        - session  
        : JSP가 세션을 사용할지 여부 지정 (기본값 true)
        - buffer  
        : JSP의 출력 버퍼 크기 지정, 'none'일 경우 출력 버퍼를 사용하지 않음
        - errorPage  
        : JSP 실행 중 에러 발생시 출력할 페이지 지정
        - isErrorPage  
        : 에러가 발생했을 때 보여줄 페이지인지 지정 (기본값 false)
        - pageEncoding  
        : JSP 소스코드의 인코딩 지정 (기본값 ISO-8859-1)
        - info  
        : 현재 JSP 페이지에 대한 설명
        - autoflush  
        : 버퍼의 내용을 자동으로 브라우저로 보낼지에 대한 설정 (기본값 true)
        - isThreadsafe  
        : 현재 JSP가 멀티스레드로 동작해도 안전한지 여부를 설정, 'false'인 경우 SingleThread로 동작 (기본값 true)
        - extends  
        : JSP 페이지를 기본 클래스가 아닌 다른 클래스를 상속받도록 변경
- include : 현재 페이지에 다른 파일의 내용 삽입할 때 사용  
    - JSP 내애ㅔ 다른 HTML 문서나 JSP 페이지의 내용을 삽입할 때 사용
    - 반복적으로 사용되는 부분(header, footer 등)을 별도로 작성하여 페이지 내에 삽입하면 반복되는 코드의 재작성을 줄일 수 있다.
    ```
    <%@ include file = "/template/header.jsp" %>
    ```
- taglib : 태그 라이브러리에서 태그를 사용할 수 있는 기능 제공
    - JSTL 또는 사용자가 작성한 커스텀 태그를 사용할 때 작성
    - 불필요한 자바 코드를 줄일 수 있다.
    ```
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
    ```

<br>

# 페이지 이동
- request를 받아서 화면을 변경하는 방법은 두 가지가 있다.
1. 포워드 방식  
: 요청이 들어오면 요청을 받은 JSP 또는 Servlet이 직접 응답을 작성하지 않고, 요청을 서버 내부에서 전달하여 해당 요청을 처리하게 하는 방식
2. 리다이렉트 방식  
: 요청이 들어오면 내부 로직 실행 후, 브라우저의 URL을 변경하도록 하여 새로운 요청을 생성함으로써 페이지를 이동한다.

## 포워드 방식
```
RequestDispatcher diispatcher = request.getRequestDispatcher("이동할 페이지);
dispatcher.forward(request, response);
```
- request, response 객체가 전달되어 사용되기 때문에 객체가 사라지지 않는다. 
- 브라우저에는 최초 요청한 주소가 표시된다


## 리다이렉트 방식
```
response.sendRedirect("location");
```
- 브라우저가 새로운 요청을 만들어 내기 때문에 최초 요청 주소와 다른 요청 주소가 화면에 보여진다.