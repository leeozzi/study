# Backend

Spring Boot 기반 백엔드 애플리케이션입니다.

## 기술 스택

- Java 17
- Spring Boot 3.2.0
- Gradle
- Spring Web

## 실행 방법

### 개발 환경 실행

```bash
./gradlew bootRun
```

### 빌드

```bash
./gradlew build
```

### JAR 파일 실행

```bash
java -jar build/libs/backend-0.0.1-SNAPSHOT.jar
```

## API 엔드포인트

- `GET /api/hello` - 서버에서 인사말을 반환합니다.

## CORS 설정

프론트엔드에서 API 호출이 가능하도록 CORS가 설정되어 있습니다.

- 허용된 Origin: `http://localhost:5173`, `http://localhost:3000`
- 허용된 메서드: GET, POST, PUT, DELETE, OPTIONS
