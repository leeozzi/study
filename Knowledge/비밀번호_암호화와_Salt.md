# 🔐 비밀번호 암호화와 Salt에 대한 쉬운 설명

---

## 🧩 왜 비밀번호를 "암호화"해야 할까?

> 평문(Plain Text) 비밀번호를 저장하면, 데이터베이스가 털릴 경우 **모든 유저의 비밀번호가 그대로 노출**됨.  
> 그래서 우리는 **암호화(정확히는 해싱)** 를 사용해서 비밀번호를 안전하게 보호해야 해!

---

## 🔁 해싱(Hashing) vs 암호화(Encryption)

| 항목         | 해싱(Hashing)                      | 암호화(Encryption)                      |
|--------------|------------------------------------|-----------------------------------------|
| 목적         | 데이터 무결성 확인, 비밀번호 저장 | 기밀성 보장                             |
| 방향성       | **일방향** (한 번 변환하면 끝)     | **양방향** (복호화 가능)                |
| 복구 가능 여부 | ❌ 복구 불가                         | ✅ 복호화 가능                            |
| 예시         | SHA-256, bcrypt, PBKDF2            | AES, RSA                                |

→ 비밀번호는 **복호화할 일이 없으니까 해싱**으로 처리함!

---

## 🔐 그럼 해싱만 하면 되는 거 아님?

❌ **절대 안 됨!** 예를 들어 `123456` 같은 흔한 비밀번호는 이미 많은 해시값이 인터넷에 **공개된 딕셔너리**에 존재함.

### 예: SHA-256 해시
```
123456 → e10adc3949ba59abbe56e057f20f883e
```

해커가 이걸 딱 보고 “아 저거 123456이네~” 하고 알아챌 수 있음.  
그래서 등장한 것이 바로…

---

## 🧂 Salt란?

**Salt는 비밀번호에 "첨가하는 랜덤 문자열"이야.**

### 🌰 예시
```
비밀번호:        123456
Salt:           abcd1234
해싱 대상:       abcd1234 + 123456
해시 결과:      8fa2a3c2f1b03bc2...
```

→ **같은 비밀번호라도 해시값이 전혀 달라짐!**  
→ 해커가 딕셔너리 공격을 해도 막을 수 있음.

---

## 🔐 실무에서의 사용 예시 (Java + Spring Security)

```java
// PasswordEncoder는 내부적으로 Salt와 해시를 같이 처리해줌
@Autowired
private PasswordEncoder passwordEncoder;

String rawPassword = "123456";
String hashedPassword = passwordEncoder.encode(rawPassword);

// 저장된 비밀번호와 비교할 땐?
boolean match = passwordEncoder.matches("123456", hashedPassword);
```

> ✅ `BCryptPasswordEncoder`는 자동으로 **랜덤 Salt 생성 + 저장**까지 해줌!

---

## 🧠 정리

| 개념       | 설명 |
|------------|------|
| 해싱       | 비밀번호를 단방향으로 변환해서 저장하는 방식 |
| Salt       | 해싱 전에 추가하는 랜덤 문자열. 같은 비밀번호도 해시값 다르게 만듦 |
| 암호화     | 일반 텍스트를 복호화 가능한 형태로 바꾸는 방식. 비밀번호에는 잘 안 씀 |
| PasswordEncoder | Spring Security에서 제공하는 해싱 처리기. 보통 `bcrypt` 사용 |

---

## 🛡️ 보안 팁

- ✅ 반드시 `Salt + 해시` 조합을 사용하자
- ✅ Spring에서는 `BCryptPasswordEncoder`를 써주자
- ❌ 절대 평문 비밀번호 저장하지 말자
- ❌ 단순 해시(SHA-256 단독)만 사용하는 건 위험!

---

## 참고 자료

- [OWASP Password Storage Cheat Sheet](https://cheatsheetseries.owasp.org/cheatsheets/Password_Storage_Cheat_Sheet.html)
- [Spring Security Docs](https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/crypto/bcrypt/BCryptPasswordEncoder.html)
