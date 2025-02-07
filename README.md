
## ⭐ 알고리즘 스터디 w/ 승언

> ### JANUARY
**0121 화요일**  
- [BOJ 13300. 방배정](https://www.acmicpc.net/problem/13300)
- [BOJ 1244. 스위치 켜고 끄기](https://www.acmicpc.net/problem/1244)

**0123 목요일**
- [BOJ 17413. 단어뒤집기2](https://www.acmicpc.net/problem/17413)

**0131 금요일**
- [BOJ 1012. 유기농배추](https://www.acmicpc.net/problem/1012)
- [BOJ 2493. 탑](https://www.acmicpc.net/problem/2493)

<br/>

> ### FEBRUARY
**0204 화요일**
- JAVA 과목시험 & 월말평가 대비

**0206 목요일**
- [BOJ 3986. 좋은 단어](https://www.acmicpc.net/problem/3986)
- [BOJ 4963. 섬의 개수](https://www.acmicpc.net/problem/4963)
- [BOJ 5427. 불](https://www.acmicpc.net/problem/5427)

**0211 화요일**
- [BOJ 2448.별 찍기](https://www.acmicpc.net/problem/2448)
- [BOJ 15651.N과 M(1)](https://www.acmicpc.net/problem/15649)
- [BOJ 15651.N과 M(3)](https://www.acmicpc.net/problem/15651)
- 이중연결리스트 만들기  
  > [!summary] 다음 코드를 활용해서 이중연결리스트 만들어오기
	> ```java
	> public class Node {
	> 	int value;
	>	Node prev;
	>	Node next;
	> }
	> ```
	>
	> ```java
	> public interface ILinkedList {
	>	public void add(int index, Node node);
	>	public void remove(int value);
	>	public void printAll();
	> }
  	> ```
	>
	> 인터페이스 implements 하고 아래 함수를 포함한 클래스 구현
	>
	> 1. 생성자로 n을 입력받고 1~n까지를 값으로 갖는 이중연결리스트 구현
	> 2. index번째 위치에 node를 추가하는 함수 // index가 범위를 초과하지 않는다고 전제  
    	>	- add(int index, Node node)
	> 3. value값을 가진 노드 삭제 // 중복된 값이 있으면 첫 번째 만나는 노드만 삭제  
    	>	- remove(int value)
	> 4. 순서대로 모든 노드를 순서대로 출력하는 함수  
   	>	-printAll()


</br>

---

</br>

## ⭐ 점심 스터디

> ### FEBRUARY
**0203 월요일**
- [백준_11723_집합](https://www.acmicpc.net/problem/11723)
- [백준_1620_포켓몬마스터](https://www.acmicpc.net/problem/1620)
  
**0204 화요일**
- [백준_1764_듣보잡](https://www.acmicpc.net/problem/1764)
- [백준_11047_동전0](https://www.acmicpc.net/problem/11047)
  
**0205 수요일**
- JAVA 과목시험 & 월말평가

**0206 목요일**
- [백준_17219_비밀번호찾기](https://www.acmicpc.net/problem/17219)
- [백준_1003_피보나치함수](https://www.acmicpc.net/problem/1003)
  
**0207 금요일**
- [백준_1463_1로만들기](https://www.acmicpc.net/problem/1463)
- [백준_2579_계단오르기](https://www.acmicpc.net/problem/2579)
