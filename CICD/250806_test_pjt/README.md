# Full Stack Test Project

React + Vite 프론트엔드와 Spring Boot 백엔드로 구성된 테스트용 풀스택 프로젝트입니다.

## 프로젝트 구조

```
test_pjt/
├── frontend/          # React + Vite + TypeScript 프론트엔드
├── backend/           # Spring Boot + Gradle 백엔드
└── README.md          # 프로젝트 설명서
```

## 기술 스택

### Frontend

- React 18
- Vite
- TypeScript
- Axios (API 호출)

### Backend

- Java 17
- Spring Boot 3.x
- Gradle
- Spring Web

## 실행 방법

### Backend 실행

```bash
cd backend
./gradlew bootRun
```

백엔드는 http://localhost:8080 에서 실행됩니다.

### Frontend 실행

```bash
cd frontend
npm install
npm run dev
```

프론트엔드는 http://localhost:5173 에서 실행됩니다.

## 빌드 방법

### Backend 빌드

```bash
cd backend
./gradlew build
```

### Frontend 빌드

```bash
cd frontend
npm run build
```

## API 엔드포인트

- `GET /api/hello` - 서버에서 인사말을 반환합니다.

## 환경 설정

프론트엔드의 `.env.production` 파일에서 백엔드 API 주소를 설정할 수 있습니다.
