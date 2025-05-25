
# 🛡️ CSRF (Cross-Site Request Forgery) 개념 정리

---

## ✅ CSRF란?

**CSRF (Cross-Site Request Forgery)**  
: 사용자가 의도하지 않았는데도, **다른 사이트에서 인증된 사용자 권한으로 요청을 보내는 공격**

---

## 🧨 예시 시나리오

1. 사용자가 `https://bank.com`에 로그인한 상태에서 세션이 유지됨 (쿠키 인증).
2. 공격자가 만든 악성 사이트(`https://evil.com`)에 사용자가 접속.
3. 해당 사이트에서 다음과 같은 코드를 실행:
```html
<form action="https://bank.com/transfer" method="POST">
  <input type="hidden" name="to" value="hacker">
  <input type="hidden" name="amount" value="1000000">
</form>
<script>document.forms[0].submit();</script>
```
4. 사용자 브라우저는 `bank.com`에 로그인된 상태이므로 쿠키를 함께 전송하고, 은행 서버는 요청을 처리함.

> ✅ 사용자는 아무런 클릭 없이, 본인의 계정으로 요청이 전송된 것처럼 보임

---

## 🛡️ Spring Security에서의 CSRF 방어

Spring Security는 기본적으로 **CSRF 보호를 활성화**하고 있으며 다음과 같이 작동합니다:

- 서버는 클라이언트에게 **CSRF 토큰을 발급**
- 클라이언트는 매 요청마다 이 토큰을 **헤더 또는 숨은 필드에 담아 전송**
- 서버는 "정상적인 사용자인지" 이 토큰을 통해 판단함

---

## ⚙️ REST API에서는 왜 `.csrf().disable()`을 사용하는가?

REST API는 일반적으로 다음과 같은 특성을 가짐:

- **세션/쿠키 인증이 아니라 토큰(JWT 등) 기반 인증**을 사용
- 클라이언트에서 명시적으로 요청을 보냄 → 브라우저 자동 전송 아님

### ✅ 그래서:
```java
http.csrf().disable();
```
이렇게 비활성화하는 게 일반적이며, 보안에 큰 문제가 되지 않음.

---

## 📌 정리

| 항목 | 설명 |
|------|------|
| CSRF 정의 | 인증된 사용자의 권한을 이용해 공격자가 요청을 보내는 것 |
| 주로 발생 환경 | 세션 기반 인증, 쿠키가 자동 전송되는 구조 |
| 방어 방식 | 서버가 CSRF 토큰을 발급하고 검증 |
| REST API에서는? | JWT 기반 인증이므로 보통 `csrf().disable()` 설정 사용 |

---

## 🧠 참고

- **쿠키가 자동 전송되는 환경에서는 항상 CSRF를 신경 써야 함**
- JWT 등 **토큰 기반 인증에서는 CSRF 위험이 낮음**
