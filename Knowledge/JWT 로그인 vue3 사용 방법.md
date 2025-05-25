
# 🧩 Vue 3에서 JWT 로그인 구현 단계별 정리

이 문서는 Vue 3 환경에서 JWT를 이용해 로그인 후 토큰을 저장하고,  
모든 API 요청에 자동으로 토큰을 포함시키는 방법을 단계별로 정리한 것입니다.  
모든 예시는 Pinia + Axios 기준이며, 주석을 꼼꼼히 포함하고 있습니다.

---

## ✅ 1단계: Pinia 스토어에서 로그인 & 토큰 저장

```js
// 📁 src/stores/userStore.js
import { defineStore } from 'pinia';
import axios from 'axios';

export const useUserStore = defineStore('user', {
  state: () => ({
    token: null,           // JWT 토큰 저장
    userId: null,          // 로그인한 사용자 ID
    isLoggedIn: false,     // 로그인 여부
  }),

  actions: {
    // 로그인 요청 → 토큰 저장
    async login(userData) {
      try {
        const response = await axios.post('http://localhost:8080/api/user/login', userData);

        this.token = response.data.token;                // JWT 저장
        this.userId = userData.userId;
        this.isLoggedIn = true;

        localStorage.setItem('jwt', this.token);         // 새로고침 대비: localStorage 저장
      } catch (err) {
        console.error('로그인 실패:', err);
        throw err;
      }
    },

    // 로그아웃 시 상태 초기화
    logout() {
      this.token = null;
      this.userId = null;
      this.isLoggedIn = false;
      localStorage.removeItem('jwt');                    // 저장된 토큰도 제거
    },

    // 앱 시작 시 localStorage에서 토큰 복원
    restoreToken() {
      const token = localStorage.getItem('jwt');
      if (token) {
        this.token = token;
        this.isLoggedIn = true;
      }
    },
  },
});
```

---

## ✅ 2단계: Axios 인터셉터로 토큰 자동 포함

```js
// 📁 src/api/axiosInstance.js
import axios from 'axios';

const api = axios.create({
  baseURL: 'http://localhost:8080', // 백엔드 주소
});

// 요청 전에 토큰을 Authorization 헤더에 자동으로 추가
api.interceptors.request.use((config) => {
  const token = localStorage.getItem('jwt');            // 저장된 토큰 꺼냄
  if (token) {
    config.headers.Authorization = `Bearer ${token}`;   // 헤더에 삽입
  }
  return config;
});

export default api;
```

---

## ✅ 3단계: 로그인 컴포넌트에서 사용 예시

```vue
<!-- 📁 src/views/LoginView.vue -->
<script setup>
import { ref } from 'vue';
import { useUserStore } from '@/stores/userStore';
import { useRouter } from 'vue-router';

const userStore = useUserStore();
const router = useRouter();

const userId = ref('');
const userPw = ref('');

// 로그인 요청 처리
const onLogin = async () => {
  try {
    await userStore.login({ userId: userId.value, userPw: userPw.value });
    alert('로그인 성공!');
    router.push('/dashboard'); // 로그인 성공 후 이동
  } catch {
    alert('로그인 실패!');
  }
};
</script>

<template>
  <div>
    <h1>로그인</h1>
    <input v-model="userId" placeholder="아이디" />
    <input v-model="userPw" type="password" placeholder="비밀번호" />
    <button @click="onLogin">로그인</button>
  </div>
</template>
```

---

## ✅ 4단계: 인증 필요한 페이지 보호하기

```vue
<!-- 📁 src/views/DashboardView.vue -->
<script setup>
import { useUserStore } from '@/stores/userStore';
import { useRouter } from 'vue-router';
import { onMounted } from 'vue';

const store = useUserStore();
const router = useRouter();

// 페이지 접속 시 로그인 상태 확인
onMounted(() => {
  if (!store.isLoggedIn) {
    alert('로그인이 필요합니다');
    router.push('/login');
  }
});
</script>

<template>
  <div>
    <h1>대시보드</h1>
    <p>로그인한 사용자만 볼 수 있습니다.</p>
  </div>
</template>
```

---

## ✅ 5단계: 새로고침 시 로그인 유지

```js
// 📁 src/main.js 또는 App.vue
import { useUserStore } from '@/stores/userStore';

const store = useUserStore();
store.restoreToken(); // 앱 시작 시 저장된 토큰을 state에 반영
```

---

## ✅ 전체 요약

| 기능 | 구현 방식 |
|------|------------|
| 로그인 처리 | axios + JWT 저장 (Pinia + localStorage) |
| 요청 시 토큰 포함 | axios 인터셉터로 `Authorization` 자동 추가 |
| 로그아웃 | 상태 초기화 + localStorage 제거 |
| 새로고침 후 로그인 유지 | `restoreToken()` 호출 |
| 인증 페이지 보호 | `onMounted`에서 로그인 여부 체크 |

---

**💡 추가로 궁금한 내용:**
- refresh token 사용
- 토큰 만료 감지 및 자동 재로그인
- 사용자 권한(role)에 따라 UI 다르게 하기

필요하면 언제든지 더 확장해줄게요!
