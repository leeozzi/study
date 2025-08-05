# Frontend

React + Vite + TypeScript 기반 프론트엔드 애플리케이션입니다.

## 기술 스택

- React 18
- Vite
- TypeScript
- Axios (API 호출)

## 실행 방법

### 개발 환경 실행

```bash
npm install
npm run dev
```

### 빌드

```bash
# 기본 빌드 (모든 환경에서 동일)
npm run build
npm run build:prod
npm run build:dev
```

### 빌드 결과 미리보기

```bash
npm run preview
```

## 환경 변수

- `VITE_API_BASE_URL`: 백엔드 API 기본 URL (기본값: http://localhost:8080/api)

### 환경 변수 설정 방법

1. 프로덕션 환경: `.env.production` 파일 생성
2. 개발 환경: `.env.development` 파일 생성

예시:
```bash
# .env.production
VITE_API_BASE_URL=http://localhost:8080/api

# .env.development  
VITE_API_BASE_URL=http://localhost:8080/api
```

## 주요 기능

- 백엔드 API 호출 테스트
- 실시간 API 응답 표시
- 에러 처리
- 로딩 상태 표시

## 개발 서버

개발 서버는 http://localhost:5173 에서 실행됩니다.
