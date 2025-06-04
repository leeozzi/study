# 🔐 Spring Boot에서 JWT 로그인 구현 (Maven 기반)

JWT(Json Web Token)를 사용해 로그인 기능을 구현하는 방법을 1단계부터 6단계까지 차근차근 정리한 문서입니다.  
처음 JWT를 사용하는 초보자도 따라 할 수 있도록 예제 코드와 함께 설명되어 있습니다.

---

## ✅ 목표

- Spring Boot + Maven 기반에서
- ID/PW 로그인 → JWT 발급 → 이후 요청 시 JWT로 인증
- Stateless 인증 구조 구현

---

## 1단계: Maven 의존성 설정

**📄 pom.xml**

```xml
<dependencies>
  <!-- Web -->
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
  </dependency>

  <!-- Security -->
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
  </dependency>

  <!-- JWT -->
  <dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-api</artifactId>
    <version>0.11.5</version>
  </dependency>
  <dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-impl</artifactId>
    <version>0.11.5</version>
    <scope>runtime</scope>
  </dependency>
  <dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-jackson</artifactId>
    <version>0.11.5</version>
    <scope>runtime</scope>
  </dependency>
</dependencies>
```

---

## 2단계: JWT 유틸 클래스 작성

**📄 JwtUtil.java**

```java
// 이 클래스는 JWT 생성, 검증, 파싱을 담당하는 유틸리티 클래스
@Component // 스프링이 자동으로 빈으로 등록해줌 (@Autowired 가능)
public class JwtUtil {

    // application.properties에 설정한 비밀키를 주입받음
    @Value("${jwt.secret}")
    private String secretKey;

    // 토큰 만료 시간 설정 (현재는 1시간)
    private final long expiration = 1000 * 60 * 60; // 밀리초 단위 (1시간 = 3600000ms)

    // -------------------------------------------------------------
    // ✅ 토큰 생성 메서드
    // username을 기반으로 JWT를 생성함
    public String generateToken(String username) {
        return Jwts.builder() // 토큰 빌더 시작
                .setSubject(username) // 토큰의 "주제"는 사용자 이름 (payload의 sub에 들어감)
                .setIssuedAt(new Date()) // 현재 시간 기준 발급일 설정
                .setExpiration(new Date(System.currentTimeMillis() + expiration)) // 만료 시간 설정
                .signWith( // 서명 알고리즘과 키 지정
                    Keys.hmacShaKeyFor(secretKey.getBytes()), // 비밀키를 byte 배열로 변환해서 사용
                    SignatureAlgorithm.HS256 // HMAC + SHA-256 알고리즘 사용
                )
                .compact(); // 최종적으로 JWT 문자열로 직렬화
    }

    // -------------------------------------------------------------
    // ✅ 토큰 검증 메서드
    // 유효한 서명이고, 만료되지 않았는지 확인
    public boolean validateToken(String token) {
        try {
            // 파서 객체를 만든 뒤 서명키로 토큰을 검증하며 파싱
            Jwts.parserBuilder()
                .setSigningKey(secretKey.getBytes()) // 시크릿 키 설정
                .build()
                .parseClaimsJws(token); // 토큰 파싱 및 서명 검증
            return true; // 예외가 안 나면 유효한 토큰임
        } catch (JwtException e) {
            // 서명 위조, 만료 등 모든 JWT 예외를 잡아서 false 반환
            return false;
        }
    }

    // -------------------------------------------------------------
    // ✅ 토큰에서 username(주제) 추출
    public String extractUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey.getBytes()) // 시크릿 키 설정
                .build()
                .parseClaimsJws(token) // 토큰 파싱
                .getBody() // payload(claims) 꺼내기
                .getSubject(); // 그중에서 subject (= username) 추출
    }
}

```

**📄 application.properties**

```properties
jwt.secret=너의아주긴비밀키를여기에넣어
```

---

## 3단계: 로그인 컨트롤러 작성

**📄 AuthController.java**

```java
// 로그인 관련 요청을 처리하는 컨트롤러
@RestController
@RequestMapping("/api/auth") // API 엔드포인트: /api/auth/**
public class AuthController {

    private final AuthenticationManager authenticationManager; // 로그인 검증을 위한 스프링 시큐리티 객체
    private final JwtUtil jwtUtil; // JWT 유틸 클래스

    // 생성자를 통해 의존성 주입
    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    // POST 요청으로 로그인 처리
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        try {
            // 사용자 이름과 비밀번호로 인증 시도
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );

            // 인증 성공하면 JWT 발급
            String token = jwtUtil.generateToken(request.getUsername());

            // 클라이언트에게 토큰 응답
            return ResponseEntity.ok(new LoginResponse(token));

        } catch (AuthenticationException e) {
            // 인증 실패 (비밀번호 틀림 등)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인 실패");
        }
    }
}

```

**📄 DTO 클래스들**

```java
@Getter @Setter
public class LoginRequest {
    private String username;
    private String password;
}

@Getter @AllArgsConstructor
public class LoginResponse {
    private String token;
}
```

---

## 4단계: Spring Security 설정

**📄 SecurityConfig.java**

```java
@Configuration
@EnableWebSecurity // Spring Security 설정 클래스임을 나타냄
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtFilter jwtFilter; // 우리가 만든 JWT 필터를 주입받음

    // Security 설정
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf().disable() // CSRF 비활성화 (JWT는 세션 안 쓰니까)
                .sessionManagement(session -> session
                            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                ) // 세션을 생성하지 않음
                .and()
                .authorizeHttpRequests()
                .requestMatchers("/api/auth/**").permitAll() // 로그인 관련 API는 인증 없이 접근 가능
                .anyRequest().authenticated() // 그 외 모든 요청은 인증 필요
                .and()
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class) // JWT 필터를 UsernamePasswordAuthenticationFilter 앞에 추가
                .build();
    }

    // 인증 매니저 빈 등록 (로그인 인증 처리용)
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}

```

---

## 5단계: JWT 인증 필터 작성

**📄 JwtFilter.java**

```java
@Component // 빈 등록
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;
    private final UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        // 1. 요청 헤더에서 Authorization 값을 꺼냄
        String authHeader = request.getHeader("Authorization");

        // 2. "Bearer "로 시작하면 JWT 토큰이라 판단
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            // 3. "Bearer " 다음부터가 실제 토큰임
            String token = authHeader.substring(7);

            // 4. 토큰 유효성 검사
            if (jwtUtil.validateToken(token)) {
                // 5. 유효하면 토큰에서 사용자 이름 추출
                String username = jwtUtil.extractUsername(token);

                // 6. DB나 메모리에서 사용자 정보 조회
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);

                // 7. 사용자 정보를 시큐리티 컨텍스트에 등록
                UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }

        // 8. 다음 필터로 요청 넘기기
        filterChain.doFilter(request, response);
    }
}

```

---

## 6단계: 사용자 정보 서비스

**📄 CustomUserDetailsService.java**

```java
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository; // DB에서 사용자 정보를 조회하기 위한 Repository

    // 사용자 이름으로 UserDetails 객체 반환 (로그인, 토큰 검증 등에 사용)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 사용자 찾기 (없으면 예외 발생)
        User user = userRepository.findByUsername(username)
                      .orElseThrow(() -> new UsernameNotFoundException("사용자 없음"));

        // 스프링 시큐리티가 이해할 수 있는 형태로 변환
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(), // ID
                user.getPassword(), // 암호화된 비번
                List.of(new SimpleGrantedAuthority("ROLE_USER")) // 권한 (기본 사용자)
        );
    }
}

```

---

## ✅ 전체 흐름 요약

1. POST `/api/auth/login` → ID/PW로 인증 시도
2. 성공 시 JWT 발급
3. 이후 요청은 Authorization 헤더에 `Bearer <token>` 담아서 전송
4. 필터가 토큰 검증 → SecurityContext에 사용자 등록 → 인증된 요청 처리 완료
