# Servlet이란?
- Server + Applet의 합성어
- Java 코드 안에 HTML 포함
- Java 언어로 작성된 웹 어플리케이션의 서버 측 프로그램
- Java를 이용하여 웹페이지를 동적으로 생성할 수 있음

<br>

# Servlet 등록 방법
## 1. web.xml
Servlet 클래스 만들고, 아래 코드를 추가해줌

```
<servlet>
	<servlet-name>MyServlet</servlet-name>
	<servlet-class>com.ssafy.myservlet.MyServlet4</servlet-class>
	// 풀패키지명으로 써줄 것!
</servlet> // 여기까지 하면 서블릿 컨테이너에는 등록 끝남
<servlet-mapping>
	<servlet-name>MyServlet</servlet-name>
	<url-pattern>/MyServlet</url-pattern>
</servlet-mapping>
```

## 2. Annotation
만든 Servlet 클래스 위에다가 @WebServlet(/MyServlet) 적어줌  
괄호 안에 들어가는 url 다른 서블릿이랑 중복되면 안 됨

<br>

# Servlet 생명 주기
- Servlet 인스턴스는 웹 컨테이너에 의해 제어  
Servlet Container -> new 로 Servlet 인스턴스 만들지 않아도 대신 관리해줌

- Servlet 인스턴스가 존재하지 않으면 ?  
    1. Servlet 클래스 로드
    2. Servlet 클래스 인스턴스 생성
    3. Servlet 인스턴스 초기화
    - 대기 -
    4. 웹 컨테이너에 의한 service 메서드 호출
    5. destroy 메서드를 호출하여 Servlet 종료

- Servlet은 기본적으로 싱글턴으로 관리되고 있다.  
    service 메서드만 여러번 호출 가능

<br>

# Front Controller
- 기존에는 매핑 주소마다 servlet이 존재했기 때문에 많은 servlet 필요  
    -> 웹에서 발생하는 모든 요청에 대해 호출되는 공통 Servlet 만들어서 처리하게 함

---
# 실습
## MainServlet
```
package com.ssafy.ws.step2.servlet;

import java.io.IOException;

import com.ssafy.ws.step2.dto.Movie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 이 서블릿이 호출되기 위해서는 url 상에 http://server_ip:port/context_name/main 이 필요하다.

@WebServlet("/lab")
public class MainServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		
		if("regist".equals(action)) {
			String title = req.getParameter("title");
			String director = req.getParameter("director");
			String genre = req.getParameter("genre");
			int runningTime = Integer.parseInt(req.getParameter("runningTime"));
			
			// Movie 객체 생성
			Movie movie = new Movie(runningTime, title, director, genre, runningTime);
			
			// 브라우저에 출력
			resp.setContentType("text/html; charset=UTF-8");
			resp.getWriter().println("<h1>영화 정보</h1>");
			resp.getWriter().println("<p>Movie [영화ID = " + movie.getId() + ", 영화 제목 = " + movie.getTitle() + ", 감독 = " + movie.getDirector() + ", 장르 = " + movie.getGenre() + ", 상영시간 = " + movie.getRunningTime() + "]");
		}
	}
}

```