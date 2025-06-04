
# 🔐 JWT 비밀키 길이 & 알고리즘 요구사항 정리

JWT를 사용할 때 `HS256`, `HS384`, `HS512`와 같은 HMAC 알고리즘에 따라 비밀키의 **최소 길이**가 요구됩니다.  
너무 짧은 키를 사용할 경우 JWT 서명 생성 시 예외가 발생합니다.

---

## 📏 알고리즘별 비밀키 최소 길이

| 알고리즘 | 최소 키 길이 (비트) | 바이트 기준 | 설명 |
|----------|----------------------|--------------|------|
| HS256    | 256 bits             | 32 bytes     | ✅ 실무에서 가장 많이 사용됨 |
| HS384    | 384 bits             | 48 bytes     | 보안 강도 더 높음 |
| HS512    | 512 bits             | 64 bytes     | 가장 강력한 보안, 키도 가장 김 |

---

## 🔍 예시 키 분석

```properties
jwt.secret = ssafyclassnineteambeonjiandhyunjae
```

- 문자열 길이: 36자 → 36바이트 (UTF-8 기준)
- 사용 가능 알고리즘:
  - ✅ HS256 → OK (32바이트 이상)
  - ❌ HS384 → 부족 (48바이트 필요)
  - ❌ HS512 → 더 부족 (64바이트 필요)

---

## ❌ 잘못된 키 사용 시 발생 에러

```text
java.lang.IllegalArgumentException: 
The signing key's size is too small for the signature algorithm
```

- 위 에러는 비밀키가 짧을 때 발생함
- 특히 `hmacShaKeyFor(secret.getBytes())` 사용할 때 자주 발생

---

## ✅ 비밀키 생성 추천 방식

### 🛠 랜덤 문자열 사용 (Base64 등)
```bash
openssl rand -base64 64
```

예시 출력:
```
sdfu9sd+WEURsdfslk2349sdfsf23r9asf8==...
```

- 안전하고, 키 길이도 충분
- 환경 변수나 secrets manager에 저장해서 사용

---

## 🧠 결론

- **HS256을 사용할 경우, 32바이트 이상의 키면 충분하다**
- HS384/HS512를 사용할 경우에는 더 긴 키를 사용해야 함
- 보안을 위해 임의의 난수로 생성된 키 사용을 권장함
