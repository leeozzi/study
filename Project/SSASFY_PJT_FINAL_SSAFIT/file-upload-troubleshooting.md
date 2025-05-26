# 📂 파일 업로드 트러블슈팅 기록 (`2025-05-26`)

## 🧩 상황 요약

- 프로젝트 구조: **Vue 3 + Spring Boot 3.4.4 + Maven + JWT 인증**
- 요구사항: 유저 프로필 사진을 **업로드 → 서버에 저장 → DB에 경로 저장 → 프론트에서 불러오기**
- 목표: 사용자가 프사 변경 시 이미지를 서버에 업로드하고, 이후 프론트에서 즉시 반영

---

## 🧨 주요 문제 & 원인

### ⚠️ 문제 1. `file.transferTo(dest)` 에서 IOException

**오류 메시지**
```
FileNotFoundException: 지정된 경로를 찾을 수 없습니다
```

**원인 분석**
- 파일을 저장하려던 경로가 `src/main/resources/static/upload/` → **jar 실행 시점엔 존재하지 않음**
- Spring Boot는 `resources` 아래 디렉토리를 정적으로 패키징함 → **런타임에 파일 저장 불가능**

**해결 방법**
- 저장 경로를 `System.getProperty("user.dir") + "/upload/"`로 변경
- 실제 로컬 파일 시스템에 존재하는 디렉토리 사용

---

### ⚠️ 문제 2. 이미지 요청 시 403 Forbidden 발생

**오류 메시지**
```
GET http://localhost:8080/upload/파일명.jpeg 403 (Forbidden)
```

**원인 분석**
- Spring Security가 `/upload/**` 경로 요청을 차단 중
- Security 설정에 해당 경로 허용 설정이 없음

**해결 방법**
```java
.requestMatchers("/upload/**").permitAll()
```
를 `SecurityConfig`의 `filterChain`에 추가하여 허용

---

### ⚠️ 문제 3. 정적 리소스가 브라우저에서 서빙되지 않음

**원인 분석**
- Spring MVC가 정적 리소스를 찾을 수 있도록 매핑이 필요함
- WebConfig에 `addResourceHandlers()` 누락

**해결 방법**
```java
registry.addResourceHandler("/upload/**")
        .addResourceLocations("file:" + System.getProperty("user.dir") + "/upload/");
```

---

### ⚠️ 문제 4. Vue에서 이미지가 안 뜸 (`403` 포함)

**원인**
```vue
<img :src="http://localhost:8080/${user.profileImg}" />
```
- 이 코드는 Vue 템플릿 리터럴 아님 → 문자열 그대로 요청됨

**해결**
```vue
<img :src="`http://localhost:8080${user.profileImg}`" />
```
- 백틱(`) 사용하여 동적 문자열 처리해야 제대로 동작

---

## ✅ 최종 구현 구조

### 📁 백엔드 저장 경로
```java
String uploadPath = System.getProperty("user.dir") + "/upload/";
```

### 🧩 DB 저장 경로 예시
```java
String fileUrl = "/upload/" + fileName;
```

### 🌐 WebConfig.java
```java
registry.addResourceHandler("/upload/**")
        .addResourceLocations("file:" + System.getProperty("user.dir") + "/upload/");
```

### 🔐 SecurityConfig.java
```java
.authorizeHttpRequests(auth -> auth
    .requestMatchers("/upload/**").permitAll()
    .anyRequest().authenticated()
)
```

### 📸 프론트 이미지 렌더링 (Vue)
```vue
<img :src="`http://localhost:8080${user.profileImg}`" />
```

---

## 🏁 정리

| 항목 | 상태 |
|------|------|
| 파일 업로드 성공 여부 | ✅ 완료 |
| DB 경로 저장 | ✅ 완료 |
| 정적 리소스 접근 허용 | ✅ Security + WebConfig 완료 |
| 프론트 렌더링 | ✅ 백틱 템플릿 리터럴로 수정 |
| 확장성 (S3로 대체 가능) | 🔜 구조적 준비 완료 |

---

👉 **이제 이 구조로 실무에서도 안정적인 프로필 사진 업로드 시스템 운영 가능!**
