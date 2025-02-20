# Feb 2025

**2025.02.09 일요일**
> ### BOJ15647. N과 M (1)
> ***백트래킹, 재귀함수, DFS***  
> 함수 구조 설계하는 게 어려웠다.  
> 어찌어찌 풀었지만 나중에 다시 풀었을 때 할 수 있을지 모르겠다.  
> 재귀함수 돌아가는 과정 하나하나 따라가면서 작동원리는 이해했는데  
> 백지에서 다시 구조 생각해내라고 하면 못할 것 같음.  
> 코드 여러 번 더 봐야 할 것 같다.  
```
package groupstudy.algorithm_study;

import java.util.*;

public class BOJ15649_N과M1 {
    /**
     * N과 M (1)
     * <a href="https://www.acmicpc.net/problem/15649">...</a>
     */

    static int[] arr;
    static int[] visited;
    static int[] combi;

    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();

        int n = sc.nextInt();
        int m = sc.nextInt();
        arr = new int[n];
        visited = new int[n];
        combi = new int[m];

        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        dfs(n, m, 0);

        System.out.println(sb);
    }

    public static void dfs(int n, int m, int depth) {

        if (depth == m) {
            for (int e : combi) {
                sb.append(e + " ");
            }
            sb.append("\n");

            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] != 1) {
                combi[depth] = arr[i];
                visited[i] = 1;
                dfs(n, m, depth + 1);
                visited[i] = 0;
            }

        }

    }


}
```

<br>  

> ### BOJ15647. N과 M (3)
> ***백트래킹, 재귀함수, DFS***  
> N과 M (1) 풀고 나서 풀어서 훨씬 쉬웠음
```
package groupstudy.algorithm_study;

import java.util.Scanner;

public class BOJ15651_N과M3 {
    /**
     * N과 M (3)
     * <a href="https://www.acmicpc.net/problem/15651">...</a>
     */

    static int[] arr;
    static StringBuilder sb;
    static int[] com;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();

        int n = sc.nextInt();
        int m = sc.nextInt();

        arr = new int[n];
        com = new int[m];

        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        dfs(n, m, 0);

        System.out.println(sb);
    }

    public static void dfs(int n, int m, int depth) {

        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(com[i]).append(" ");
            }
            sb.append("\n");

            return;
        }

        for (int i = 0; i < n; i++) {
            com[depth] = arr[i];
            dfs(n, m, depth + 1);
        }

    }

}

```

<br>

> ### DoublyLinkedList 구현하기
> ***이중연결리스트***  
> 재밌었다 ! 처음에는 ArrayList로 하는 건가 싶었는데  
> 생각해보니 그럴 거면 그냥 인덱스 쓰면 되는데 왜 굳이 구현하라고 하겠나 싶어서 오로지 Node 간의 관계만으로 구현하려고 고민했다.
> head부터 next로 하나씩 건너가면서 순회하는 코드 생각했을 때가 젤 재밌었음  
> 

```
package groupstudy.algorithm_study.doublyLinkedList;

import java.util.ArrayList;
import java.util.List;

public class DoublyLinkedList implements ILinkedList {

    // 수인이 의견. add 할 때 추가하려는 위치까지 가는 걸 앞에서부터 갈지 뒤에서부터 갈지 정해주는 로직 있으면 좋겠다

    Node head;
    Node tail;
    int size = 0;

    @Override
    public void add(int index, Node node) {
        if (size == 0) {
            head = node;
            tail = node;
            head.prev = tail;
            tail.next = head;
            size++;
        } else {

            if (index != 0 && index != size) {
                Node cur = head;
                while (index-- > 0) {
                    // head에서부터 index 만큼 이동
                    Node next = cur.next;
                    cur = next;
                }

                Node temp = cur;    // 원래 index 위치에 있던 old node 따로 저장해두고

                // index-1 위치에 있는 node랑 연결해주기
                temp.prev.next = node;
                node.prev = temp.prev;

                // 아까 빼뒀던 old node랑 연결해주기
                temp.prev = node;
                node.next = temp;

                // node 추가됐으니까 size 키워주기
                size++;
            } else if (index == 0) {
                Node temp = head;
                head = node;

                temp.prev = node;
                node.next = temp;

                node.prev = tail;
                tail.next = node;

                size++;

            } else if (index == size) {
                Node temp = tail;
                tail = node;

                temp.next = node;
                node.prev = temp;

                node.next = head;
                head.prev = node;

                size++;

            }
        }

    }


    @Override
    public void remove(int value) {
        Node cur = head;

        // 하나씩 이동하면서 value 같은 애 만나면 내 전에 애랑 내 뒤에 애랑 이어주고 나는 빠지기
        for (int i = 0; i < size; i++) {
            if (cur.value == value) {
                cur.prev.next = cur.next;
                cur.next.prev = cur.prev;

                size--;
                return;
            }
            Node next = cur.next;
            cur = next;
        }
    }

    @Override
    public void printAll() {
        Node cur = head;
        for (int i = 0; i < size; i++) {
            System.out.print(cur + "\t");

            Node next = cur.next;
            cur = next;
        }
    }
}
```
```
package groupstudy.algorithm_study.doublyLinkedList;

public class Node {
    int value;
    Node prev;
    Node next;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value + "";
    }
}
```

<br>

**2025.02.11 화요일**
> ### SWEA2001. 파리퇴치
> - for문 4번 중첩 너무 찝찝한데...  
> 👉 공식 배웠음 ! 연습해볼 것  
> `우하단 + 좌상단 - 우상단 - 좌하단`
```
package SWEA;

import java.util.Scanner;

public class SWEA12712_파리퇴치3 {
    /**
     * 파리퇴치3
     * <a href="https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AXuARWAqDkQDFARa">...</a>
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[][] map = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

//            for(int i= 0 ; i < N ; i++) {
//                for(int j = 0 ; j < N ; j++) {
//                    System.out.print(map[i][j] + " ");
//                }
//                System.out.println();
//            }

            int max = 0;

            int[] dx1 = {-1, 0, 1, 0};
            int[] dy1 = {0, 1, 0, -1};

            int[] dx2 = {-1, -1, 1, 1};
            int[] dy2 = {-1, 1, -1, 1};

            // 한 위치에서 +, x 둘 다 검사해야 함
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
//                    System.out.println("현재 위치 : (" + i + "," + j + ")");
                    // + 검사
                    int plussum = map[i][j];
                    for (int m = 1; m < M; m++) {
                        for (int d = 0; d < 4; d++) {
                            int nx = i + dx1[d] * m;
                            int ny = j + dy1[d] * m;

                            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
//                                System.out.print(map[nx][ny] + " ");
                                plussum += map[nx][ny];
//                                System.out.println("현재 plussum : " + plussum);
                            }
                        }
//                        System.out.println();

                    }

                    // x 검사
                    int xsum = map[i][j];
                    for (int m = 1; m < M; m++) {
                        for (int d = 0; d < 4; d++) {
                            int nx = i + dx2[d] * m;
                            int ny = j + dy2[d] * m;

                            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                                xsum += map[nx][ny];
                            }

                        }
                    }

                    // 두 개 중 더 큰 값 비교
//                    System.out.println("현재 위치 : (" + i + "," + j + ")");
//                    System.out.println("xsum : " + xsum + " plussum : " + plussum);
                    max = Math.max(max, Math.max(xsum, plussum));
                }

            }

            System.out.println("#" + t + " " + max);
        }
    }
}

```


> ### 배열 90도 돌리기 공식 (외울 것 !!!)
> - newArr[j][n - i - 1] = arr[i][j]

<br>

**2025.02.12 수요일**
> ### SWEA1216. 회문2  
> - **ISSUE 1**  
    처음에는
    회문 길이가 홀수인 경우와 짝수인 경우를 나눠서 생각하려고 했음.  
    홀수인 경우 나를 기준으로 양옆으로 뻗어나가면서 비교하고  
    짝수인 경우에는 괄호쌍 맞추기 문제처럼 연속된 문자 만나면 stack에서 비워주는 방식으로 하려고 생각했는데  
    알고보니 ABBACACBBB이런 식으로 한 줄 안에 회문이 두 개 이상 나오면 값이 유효하지 않아짐.    
> - **ISSUE 2**  
    세로 탐색은 그냥 i랑 j만 바꿔주면 된다고 생각했는데 
    지금 palindrome  함수 안에서 [i][j-len] ~ [i][j+len]로 가로로 뻗어나가면서 검사하게 만들어 놔서 제대로 작동 안 함… 따로 만들어줘야 했음
> - **ISSUE 3**  
>   홀수 길이 출력할 때 마지막에 len++ 해주고 나서 종료되는 걸 고려 못해서 len * 2 + 1이라고 생각했음

```
import java.util.Scanner;
public class SWEA1216_회문2 {

    static char[][] board;
    static int max;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int t = 0; t < 10; t++) {
            int tc = sc.nextInt();

            // board 만들기
            board = new char[100][100];


            for (int i = 0; i < 100; i++) {
                String line = sc.next();
                for (int j = 0; j < 100; j++) {
                    board[i][j] = line.charAt(j);
                }
            }

            max = 0;
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    palindrome(i, j);
                }
            }

            System.out.println("#" + tc + " " + max);

        }

    }

    public static void palindrome(int i, int j) {
        // 홀수 길이의 회문일 때
        int len = 1;
        while (j - len >= 0 && j + len < board[0].length) {
            if (board[i][j - len] == board[i][j + len]) {
                len++;
            } else {
                break;
            }
        }
        max = Math.max(len * 2 - 1, max);

        // 짝수 길이의 회문일 때
        len = 0;
        while (j - len >= 0 && j + len + 1 < board[0].length) {
            if (board[i][j - len] == board[i][j + 1 + len]) {
                len++;
            } else {
                break;
            }
        }
        max = Math.max(len * 2, max);

        // 세로 방향 회문 검사
        // 홀수일 때
        len = 1;
        while (i - len >= 0 && i + len < board.length) {
            if (board[i - len][j] == board[i + len][j]) {
                len++;
            } else {
                break;
            }
        }
        max = Math.max(len * 2 - 1, max);

        // 짝수일 때
        len = 0;
        while (i - len >= 0 && i + len + 1 < board.length) {
            if (board[i - len][j] == board[i + 1 + len][j]) {
                len++;
            } else {
                break;
            }
        }
        max = Math.max(len * 2, max);
    }

}

```

<br>

> ### SWEA 풍선껌  
> - 크게 어렵진 않았다… 본인까지 더해주는 걸 깜빡해서 약간 시간 썼지만 구상 자체는 쉬웠음  
> 다만 for문 중첩 너무 많아서 찜찜할 뿐
> - 터뜨리려는 풍선의 꽃가루 수를 변수로 담아주고 반복하면서 델타값이랑 곱해서 뻗어나가기  
> 델타값이랑 곱하는 부분이 keypoint라고 함 ! 

```
import java.util.Scanner;

public class Balloon {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			int[][] arr = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			int[] dx = { -1, 0, 1, 0 };
			int[] dy = { 0, 1, 0, -1 };

			int max = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					int num = arr[i][j];
					int sum = arr[i][j];
					
					for (int n = 1 ; n <= num ; n++) {
						for (int d = 0; d < 4; d++) {
							int nx = i + dx[d]*n;
							int ny = j + dy[d]*n;

							if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
								sum += arr[nx][ny];
							}
							
						}

					}
					max = Math.max(max, sum);
				}

			}

			System.out.println("#" + t + " " + max);
		}

	}
}

```

<br>

**2025.02.13 목요일**
> ### BOJ9375. 패션왕 신해빈  
> ***HashMap***  
> -  getOrDefault(key, new value) 함수 쓰는 법을 배웠다 !  
> - 옷 이름은 저장하지 않고 개수만 value로 저장해서 쓰는 방법  
> - 입지 않는 경우의 수를 하나 더해서 그냥 순열 뽑아주는 방식은 전혀 생각 못했다...

```
package groupstudy.algorithm_lunchStudy;

import java.io.*;
import java.util.*;

public class BOJ9375_패션왕신해빈 {
    /**
     * 패션왕 신해빈
     * <a href="https://www.acmicpc.net/problem/9375">...</a>
     */

    /*
    chatGPT한테 힌트 받은 부분
    - value를 name 말고 개수로 받아라
    - 안 입는 경우를 포함해서 곱하면 된다!
    */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());

            // hashmap 만들어주기
//            Map<String, ArrayList<String>> hashmap = new HashMap<>();
            Map<String, Integer> hashmap = new HashMap<>();

            for (int i = 0; i < n; i++) {
                String line = br.readLine();
                StringTokenizer st = new StringTokenizer(line);
                st.nextToken(); // String name = st.nextToken();
                String type = st.nextToken();

                hashmap.put(type, hashmap.getOrDefault(type, 0) + 1);

//                if (hashmap.containsKey(type)) {
//                    hashmap.get(type).add(name);
//                } else {
//                    hashmap.put(type, new ArrayList<>());
//                    hashmap.get(type).add(name);
            }


            // 입는 옷의 종류 개수 * 그 종류에 속한 옷의 개수
            // 1개만 입을 때 -> name list 개수 다 합해주면 됨
            // 2개만 입을 때 -> 뭐 입을 거임? 종류 두 개 골라주고 -> 그 종류에 속한 옷들 개수 곱해줘
            int result = 1;

            for (int cnt : hashmap.values()) {
                result *= cnt+1;
            }

                System.out.println(result - 1); // 알몸(모든 종류에서 아무것도 안 입는 경우) 제외

        }
    }
}

```

<br>

> ### BOJ9461. 파도반수열
> ***DP***
> - 규칙 찾느라 노가다 좀 했음
> - int 배열로 dp 저장해주니까 int가 표현할 수 있는 값을 벗어나서 long으로 바꿔줌  
> 근데 이걸 어떻게 문제 보면서 바로 int 쓸 지 long 쓸 지 파악할 수 있을까?

```
package groupstudy.algorithm_lunchStudy;

import java.util.Scanner;

public class BOJ9461_파도반수열 {
    /**
     * 파도반수열
     * <a href="https://www.acmicpc.net/problem/9461">...</a>
     */

    /*
    dp 배열을 int로 쓰니까 틀렸다고 함... 범위를 넘어갔나봄...그래서 long으로 썼어
    근데 이걸 문제만 보고 어케 int 써야할지 long 써야할지 판단하지?
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        long[] dp = new long[101];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;
        dp[6] = dp[3] + dp[5];
        dp[7] = dp[2] + dp[6];
        dp[8] = dp[1] + dp[7];
        for(int i = 9 ; i < 101 ; i++){
            dp[i] = dp[i-1] + dp[i-5];
        }

        for(int t = 1 ; t <= T ; t++) {
            int N = sc.nextInt();

            System.out.println(dp[N]);
        }
    }
}

```

<br>

> ### SWEA8931. 제로
> ***Stack***
> - stack 기본 중의 기본 중의 기본. 걍 바로 풀고 바로 맞았음.

```
import java.util.Scanner;
//import java.util.Stack;

public class SWEA8931_제로 {
	/**
	 * 제로
	 */
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T ; t++) {
			int K = sc.nextInt();
			MyStack<Integer> stack = new MyStack<>();
			
			for(int k = 0 ; k < K ; k++) {
				int num = sc.nextInt();
				if(num != 0) {
					stack.add(num);
				} else {
					stack.pop();
				}
			}
			
			int sum = 0;
			while(!stack.isEmpty()) {
				sum += stack.pop();
			}
			
			System.out.println("#" + t + " " + sum);
		}
	}
}

```

<br>

> ### Stack 구현해보기  
> ***Stack***  
> 전에 DoublyLinkedList 구현했던 것보단 훨씬 간단했다  
> 근데 일반 배열로 구현하자니 남는 메모리가 너무 거슬려서  
> ArrayList로 써서 편하게 하긴 함...  
> 구현 자체보다는 제네릭 문법이 조금 헷갈려서 찾아봐가면서 했다  

```
import java.util.ArrayList;

public class MyStack<T> {
	ArrayList<T> stack = new ArrayList<>();
	T top;

	public void add(T data) {
		stack.add(data);
		top = data;
	}

	public T pop() {
		if (!stack.isEmpty()) {
			T temp = top;
			stack.remove(stack.size()-1);
			if (!stack.isEmpty()) {
				top = stack.get(stack.size() - 1);
			} else {
				top = null;
			}
			return temp;
		} else {
			return null;
		}
	}

	public int size() {
		return stack.size();
	}

	public T peek() {
		return this.top;
	}

	public void clear() {
		stack.clear();
	}

	public boolean isEmpty() {
		if (stack.size() == 0)
			return true;
		else
			return false;
	}
}

```

<br>

**2025.02.14 금요일**  
> ### BOJ11659. 구간 합 구하기 4  
> ***누적합***  
> - 처음에는 arr에 숫자 담아주고 i-1 부터 j-1까지 더해줬는데 당연히 시간초과. 사실 좀 예상했음.  
> - 누적합 쓰는 걸 생각 못하고 있었던 건 아니라서... 실패 뜨자마자 쓰고 통과

```
package groupstudy.algorithm_lunchStudy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11659_구간합구하기4 {
    /**
     * 구간합구하기4
     * <a href="https://www.acmicpc.net/problem/11659">...</a>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            if (i == 0) {
                arr[i] = Integer.parseInt(st.nextToken());
            } else {
                arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
            }
        }

        for(int m = 0 ; m < M ; m++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            if(i == 1) {
                bw.write(arr[j-1] + "\n");
                bw.flush();
            } else {
                bw.write((arr[j - 1] - arr[i - 2]) + "\n");
                bw.flush();
            }
        }
    }
}

```
<br>

> ### SWEA5356. 의석이의 세로로 말해요  
> ***배열순회***  
> - 이거 걍 열 우선 탐색 하면서 null 인 애들 패스해주면 되겠는데?
> - 쉬웠음... 배열 크기 최대값으로 맞춰주니까 편함

```
import java.util.Scanner;

public class SWEA5356_의석이의세로로말해요 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			// 2차원 배열을 만들어야 할 거야
			// 길이를 어떻게 정해주지? -> 길이 15 이하래 걍 다 15로 맞추자
			String[][] map = new String[15][15];

			// 각 테스트 케이스는 다섯 줄
			for (int i = 0; i < 5; i++) {
				// 한 줄 읽어오면 쪼개주고
				String line = sc.next();
				String[] parts = line.split("");
				// 쪼갠 거 차곡차곡 넣어줌
				for (int j = 0; j < parts.length; j++) {
					map[i][j] = parts[j];
				}
			}

			// 이제 출력해줘야 해
			System.out.print("#" + t + " ");
			
			for (int j = 0; j < 15; j++) {
				for (int i = 0; i < 15; i++) {
					if (map[i][j] != null) {
						System.out.print(map[i][j]);
					}
				}
			}
			
			System.out.println();

		}
	}
}

```

<br>

> ### SWEA4613. 러시아 국기 같은 깃발      
> - 진심 어이 없는 데서 실수해서 계속 틀린 거였음…  
> red 세는 조건 시작지점을 endB로 해야 하는데 startB로 해가지고… 바본가 진짜;;  
> 어쩐지 논리는 아무리 생각해도 맞는데 답은 틀렸더라ㅠ  
> - 시간복잡도 가늠 안 됨………
> - cnts 배열 따로 만들어주는 걸 떠올린 게 진짜 뿌듯했다 !
> - 나는 파란색 범위를 시작이랑 끝 정하고 좁혀줬는데, 솔빈이 코드 보니까 파란색 범위 정하는 부분을 나랑 다르게 구현해놨음.  
> 다른 부분은 전체적으로 비슷하게 풀었길래 뿌듯했다.

```
// 솔빈이 풀이
for (int i=1;i<=n-2;i++) {
    int wSum = 0;
    for (int j=0;j<i;j++) {
        wSum+=m-cnt[j][0];
    }
    for (int j=i+1;j<=n-1;j++) {
        int bSum = 0;
        for (int k=i;k<j;k++) {
            bSum+=m-cnt[k][1];
        }
        int rSum = 0;
        for (int k=j;k<n;k++) {
            rSum+=m-cnt[k][2];
        }
        min = Math.min(min, wSum+bSum+rSum);
    }
}
```
```
// 내 풀이
import java.util.Scanner;

public class SWEA4613_러시아국기같은깃발 {

	// 첫 번째 줄은 무조건 흰색이어야 해
	// -> 두 번째 줄 흰색할지 파랑할지 개수 세어 보고 정하자
	// -> 흰색이면 그 다음 줄에서도 방금 단계 반복하고
	// 파랑이면 그 다음 줄 파랑할지 빨강할지 정해야 해
	// 마지막 줄은 무조건 빨강이어야 함

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			int mincnt = n*m ;	// 답 담아줄 변수 미리 선언

			// 일단 입력대로 이차원배열 만들어주기
			String[][] map = new String[n][m];
			for (int i = 0; i < n; i++) {
				String line = sc.next();
				String[] split = line.split("");
				for (int j = 0; j < m; j++) {
					map[i][j] = split[j];
				}
			}

			// 각 줄마다 각 색깔로 바꿨을 때 몇 개씩 바꿔줘야 하는지 담아줄 것
			int[][] cnts = new int[n][3];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (!map[i][j].equals("W")) {
						cnts[i][0]++;
					}

					if (!map[i][j].equals("B")) {
						cnts[i][1]++;
					}

					if (!map[i][j].equals("R")) {
						cnts[i][2]++;
					}
				}
			}

//			// cnts 배열 테스트 출력
//			for(int i= 0 ; i < n ; i++) {
//				for(int j = 0 ; j < 3; j++) {
//					System.out.print(cnts[i][j]);
//				}
//				System.out.println();
//			}

			// 약간 계단 오르기 문제처럼 풀어야 하나? 한 칸 갔을 때와 두 칸 갔을 때 구분했던 것처럼...
			// 근데 이때는 행이 계단이 아니라 색깔이 계단이어야지. 단계가 있잖아.

			// 맨 뒤에서부터 봤을 때 마지막은 무조건 R
			// 얘는 B에서 왔을 수도 있고, R에서 왔을 수도 있어
			// B에서 왔으면
			// W에서 왔을 수도 있고 B에서 왔을 수도 있고
			// W에서 왔으면 그 앞은 쭉 W여야 해
			// B에서 왔으면 그 앞은 W에서 왔을 수도 있고 B에서 왔을 수도 있어...
			// R에서 왔으면
			// B에서 왔을 수도 있고 R에서 왔을 수도 있어

			// 정리하자면
			// 1. 무조건 첫째줄은 W, 마지막 줄은 R
			// 2. 전체 행 개수 - W행 개수 - R행 개수 했을 때 남은 개수가 2 이상이면
			// 매번 W인지 B인지 or B인지 R인지 탐색해줘야 한다

			// B인 줄의 시작 위치와 마지막줄 위치가 관건
			// 시작 위치는 1 -> n-2
			// 끝 위치는 n-2 -> 1
			// 근데 둘이 똑같아지면 끝나야 함


			for (int startB = 1; startB <= n - 2; startB++) {
				for (int endB = n - 2; endB >= startB; endB--) {
					/* 
					 * startB == 1 이고 endB == n-2일 때
					 * cnts[0][0] + cnts[1][1] ~ cnts[n-2][1] + cnts[n-1][2]
					 * 
					 * startB == 2 이고 endB == n-2일 때
					 * cnts[0][0] + cnts[1][1] ~ cnts[n-2][1] + cnts[n-1][2]
					 * 
					 * ...
					 * 
					 * startB == n-2 이고 endB == n-2일 때
					 * 
					 * 까지 하고 나서
					 * startB = 2이고 endB == n-2일 때 부터 쭉....
					 */
					int cnt = 0;
					
					for(int i = 0; i < startB ; i++) {
						cnt += cnts[i][0];
					}
					
					for(int i = startB ; i <= endB ; i ++) {
						cnt += cnts[i][1];
					}
					
					

					for(int i = endB + 1 ; i <= n-1 ; i++) {
						cnt += cnts[i][2];
					}
					
					mincnt = Math.min(cnt, mincnt);
				}
			}
			
			System.out.println("#" + t + " " + mincnt);

		}

	}
}

// 아니 진심 멍청인가 마지막 red 조건 startB+1부터로 잡아줘서 오류남;;;;
// 코드 짤 때 덜렁거리는 거 어케 고치지 진짜.........
// 어쩐지 아무리 생각해도 논리는 다 맞는데 틀렸다더라.......짱나네 ㅋㅋ

```

<br>

**2025.02.15 토요일**  
> ### SWEA5432. 쇠막대기 자르기  
> ***stack***  
> - 자를 때마다 sum += 현재 층수  
> 근데 ( 만나면 sum에 1 더해줘야 함. 이거 안 더해주면 * 기준 오른쪽만 더하는 꼴이 됨  
> - 사실 자르는 부분을 *로 바꿔주는 단계 없이 하나씩 빼면서 바로바로 처리해주는 게 더 좋긴 하지만 처음에 좀 복잡하게 생각했어서...안 헷갈리려고 이렇게 했음

```
import java.util.Scanner;
import java.util.Stack;

public class SWEA5432_쇠막대기자르기 {
    /**
     * 쇠막대기 자르기
     * IM 대비 문제
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            String str = sc.next();
            String[] arr = str.split("");
            Stack<String> stack = new Stack<>();
            int floor = 0;
            int sum = 0;

            for (String s : arr) {
                if (stack.isEmpty()) {
                    stack.push(s);
                } else {
                    if (s.equals(")")) {
                        if (stack.peek().equals("(")) {
                            stack.pop();
                            stack.add("*");
                        } else {
                            stack.add(s);
                        }
                    } else {
                        stack.add(s);
                    }
                }
            }

//            System.out.println(stack);

            while (!stack.isEmpty()) {
                String s = stack.pop();
                if(s.equals(")")) {
                    floor ++;
//                    System.out.println(") 만났고 현재 층수 " + floor);
                } else if (s.equals("*")) {
                    sum += floor;
//                    System.out.println("* 만났고 현재 층수 " + floor + " 현재 sum " + sum);
                } else if (s.equals("(")) {
                    sum++;
                    floor --;
//                    System.out.println("( 만났고 현재 층수 " + floor + " 현재 sum " + sum);
                }

            }

            System.out.println("#" + t + " " + sum);
        }
    }
}

```

<br>

> ### SWEA1224. 계산기3  
> ***stack***  
> - 후위계산식으로 변환하는 게 너무 헷갈려... 이해가 영 안 되는 건 아닌데 만들자니 헷갈려서 공식처럼 외워서 이해하는 게 나을 것 같음

```
import java.util.*;


public class SWEA1224_계산기3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int t = 1; t <= 10; t++) {
            int len = sc.nextInt();
            String str = sc.next();
            Stack<Character> op = new Stack<>();

            StringBuilder sb = new StringBuilder();

            Map<Character, Integer> map = new HashMap<>();
            map.put('(', 0);
            map.put('*', 1);
            map.put('/', 1);
            map.put('+', 2);
            map.put('-', 2);


            for (int i = 0; i < str.length(); i++) {
//				System.out.println("이제 처리해줄 위치 : " + str.charAt(i));
                // 피연산자라면 출력
                if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                    sb.append(str.charAt(i));
                }
                // 연산자라면
                else {
                    if (str.charAt(i) == '(')
                        op.push(str.charAt(i));

                    else if (str.charAt(i) == ')') {
                        while (op.peek() != '(') {
                            sb.append(op.pop());
                        }
                        op.pop();
                    } else {
                        if (op.isEmpty())
                            op.push(str.charAt(i));

                        else {
                            while (op.peek() != '(' && map.get(str.charAt(i)) >= map.get(op.peek())) {
                                sb.append(op.pop());
                            }
                            op.push(str.charAt(i));
                        }

                    }

                }

//				System.out.println("방금 처리해준 위치 : " + str.charAt(i));
//				System.out.println("현재 출력 : " + sb);
//				System.out.println("현재 스택 : " + op);
            }

            while (!op.isEmpty()) {
                sb.append(op.pop());
            }

//            System.out.println(sb);

            str = sb.toString();

            Stack<Integer> cal = new Stack<>();

            for (int i = 0; i < str.length(); i++) {
				if(str.charAt(i) >= '0' && str.charAt(i) <= '9') {
					cal.push(str.charAt(i) - '0');
				} else {
					int b = cal.pop();
					int a = cal.pop();

					if( str.charAt(i) == '+') {
						cal.push(a+b);
					}

					else if( str.charAt(i) == '-') {
						cal.push(a-b);
					}

					else if( str.charAt(i) == '*') {
						cal.push(a*b);
					}

					else if( str.charAt(i) == '/') {
						cal.push(a/b);
					}
				}
            }


			while (!cal.isEmpty()) {
				System.out.println("#" + t + " " +  cal.pop());
			}

        }

    }
}

```

<br>

> ### 정렬 연습 (SelectionSort, QuickSort, MergeSort) 
> ***SelectionSort, QuickSort, MergeSort***  
> - 갑자기 정렬 알고리즘에 꽂혀서 정렬 공부 ㅎ 생각보다 정렬 알고리즘 종류가 엄청엄청 많아서 놀랐다. 너무 많아서 뭐가 뭔지 헷갈려..
> - 영상 따라가면 이해는 되는데 구현하라고 하면 못할 것 같음. 기회 될 때 구현 연습도 해보고 싶다.
```
// SelectionSort

package dataStructure.sorting;

import java.util.Arrays;

public class SelctionSort {
    /**
     * 선택정렬
     * 시간복잡도 O(N^2)
     * <a href="https://www.youtube.com/watch?v=uCUu3fF5Dws">...</a>
     */

    /*
    정렬 안 된 배열방 중 가장 작은 애를 찾아서 맨 앞으로 보내주는 것 반복
     */

    // 함수를 선언하고 정렬할 배열을 인자로 받습니다.
    private static void selectionSort(int[] arr) {
        // 재귀함수를 호출하는데요
        // 정렬이 안 된 부분의 시작 위치를 같이 넘깁니다
        selectionSort(arr, 0);
    }

    // 재귀함수가 호출되면 배열과 시작점을 인자로 받고
    private static void selectionSort(int[] arr, int start) {
        // 시작점이 배열의 마지막 방보다 작은 동안 재귀함수를 호출합니다.
        if(start < arr.length - 1) {
            // 가장 작은 방의 인덱스를 저장할 변수 선언.
            // 초기값은 시작 인덱스
            int min_index = start;
            // 시작점부터 배열의 마지막 방까지 돌면서
            for(int i = start; i < arr.length ; i++) {
                // 해당 배열방의 값이 작은 값이라고 생각했던 것보다 더 작으면
                // 작은 방의 인덱스를 해당 배열방의 인덱스로 업데이트 해줍니다.
                if(arr[i] < arr[min_index]) min_index = i;
            }
            // 이렇게 배열방을 끝까지 돌면서 찾은 min_index를 swap 함수를 호출해서 맨 앞에 애랑 맞바꿉니다.
            swap(arr, start, min_index);
            // 이제 맨 앞에 애는 정렬이 된 거니까 시작점 하나 증가시켜서 함수 다시 호출
            selectionSort(arr, start+1);
        }
    }

    // 두 개의 인덱스를 받아서 값을 swap 하는 함수 하나 정의
    private static void swap (int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {3, 6, 1, 8, 2, 4};
        System.out.println(Arrays.toString(arr));
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

```
```
// QuickSort
package dataStructure.sorting;

import java.util.Arrays;

public class QuickSorting {
    /**
     * 퀵 정렬
     * <a href="https://www.youtube.com/watch?v=7BDzle2n47c">...</a>
     */

     /*
     * 시간복잡도
     * 최악의 경우 O(N^2) 까지 갈 수도 있지만
     * 그럴 확률이 너무 낮아서 대체로 O(NlogN)라고 함
     */

     /*
        기준값을 선택한 후 기준값보다 작으면 왼쪽으로, 큰값을 오른쪽으로 이동시키는 방법
        현재 pivot = 5라고 가정
        배열의 양끝에 start와 end 포인터 한 개씩 가리킴
        start는 pivot 값보다 작은값들을 무시하면서 계속 뒤로 가고
        end는 pivot 값보다 큰 값들을 무시하면서 계속 앞으로 갈 거야
        그러다가 둘이 만나고, 지나치면 작은 값들과 큰 값으로 나뉘게 되는 것
        두 포인터가 엇갈리는 순간 반복문 끝남
        -------------------여기까지가 함수 한 번 끝
        방금 함수에서 start가 끝난 부분이 왼쪽 파티션의 끝이 되고,
        end가 끝난 부분이 오른쪽 파티션의 시작점이 돼서

        파티션 안에 있는 배열방이 2개 이상일 때
            -> 정렬 시작
    */


    // 정렬할 배열을 인자로 받는 퀵정렬 함수
    private static void quickSort(int[] arr) {
        // 정렬할 배열과, 시작지점, 끝나는지점을 받아서 본격적으로 재귀함수 호출
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int start, int end) {
        // 재귀함수가 호출되면 배열의 포인터와 스타트 엔드 파티션을 나눌 range를 인자로 받음
        // 해당 배열방의 시작과 끝 그 영역 안에서 파티션을 나누고,
        // 나눈 파티션의 오른쪽방 첫번째 값을 part2 로 받아옵니다
        int part2 = partition(arr, start, end);

        // 오른쪽 파티션이 시작점 바로 다음에서 시작한다면, 왼쪽 파티션의 데이터가 하나뿐이니까 정렬할 필요 없음
        if (start < part2 - 1) {   // 오른쪽 파티션이 시작점에서 한 개 이상 차이가 날 때만 재귀함수 호출
            // 지금 이건 왼쪽 파티션이니까 시작점은 똑같고 끝나는 점은 오른쪽 파티션의 시작점 바로 전으로
            quickSort(arr, start, part2 - 1);
        }

        // 그리고 오른쪽 파티션이 한 개 이상일 때만 호출해야 하니까
        if (part2 < end) {     // 오른쪽 파티션의 시작점이 마지막 배열방보다 작은 경우에만 오른쪽 파티션 정렬
            quickSort(arr, part2, end);
        }
    }

    // 배열방의 파티션을 나누는 함수
    // 인자로는 배열의 주소와, 파티션을 나눌 시작과 끝값 받음
    private static int partition(int[] arr, int start, int end) {
        // pivot 값은 배열방의 중간에 있는 값으로 한다
        int pivot = arr[(start + end) / 2];
        // 시작점이 끝지점보다 작거나 같은 동안만 양쪽 포인터를 옮겨줄 거야
        while (start <= end) {
            // start 포인터부터
            // 배열방의 값이 pivot 값보다 작으면 무시하고 넘어갈 거야
            while (arr[start] < pivot) start++;    // 배열방의 값이 pivot 값보다 크거나 같으면 그 자리에 멈춤
            while (arr[end] > pivot) end--;
            // 두 포인터가 멈춘 다음에
            if(start <= end) {    // 혹시 서로를 지나치진 않았는지 한 번 확인해주고
                // 아직 안 지나쳤으니까
                swap(arr, start, end) ; // 두 개의 값을 swap 해줍니다
                // 그리고 포인터들을 각각 한 칸씩 이동시킵니다
                start++;
                end--;
            }
        } // 이걸 두 개의 값이 만나서 지나칠 때까지 반복하면 start 포인터에 새로 나눌 배열방의 첫 번째 인덱스가 들어가게 돼요

        return start;
    }

    private static void swap(int[] arr, int start, int end) {
        int tmp = arr[start];
        arr[start] = arr[end];
        arr[end] = tmp;
    }


    public static void main(String[] args) {
        int[] arr = {3, 9, 4, 5, 6 , 1, 7, 2, 0, 4, 8, 2};
        System.out.println(Arrays.toString(arr));
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
```
```
package dataStructure.sorting;

import java.util.Arrays;

public class MergeSort {
    /** 병합 정렬
     * <a href="https://www.youtube.com/watch?v=QAyl79dCO_k">...</a>
     */

    /*
    1. 배열을 둘로 나눈다
    2. 나눈 배열을 또 반씩 나눈다
    -> 배열방에 두 개씩 남았을 때부터 merge sort를 할 수 있다
    3. 방의 개수가 하나인 두 개의 배열이라고 생각하고,
       새로운 빈 배열에 작은 수를 먼저 넣어주고 남은 수를 넣어준다
       -> 정렬이 된 배열이 되었으므로 배열에 복사한다
    4. 3의 과정을 반복하여 정렬이 된 2칸의 배열방을 여러 개 만든다
    5. 2칸의 배열방들을 또 2개씩 병합한다.
       이런 식으로 계속 병합해 나감

     시간 복잡도 O(n log n)
     - 실행 시 별도의 저장 공간을 필요하기 때문에 공간을 사용할 수 없는 경우에는 Quick Sort 사용
     */

    /// ///////////////////////////////////////////////////

    // 정렬할 배열을 인자로 받는 mergeSort 함수
    private static void mergeSort(int[] arr) {
        // 임시 저장 공간 필요. 배열의 크기만큼 만들어줌
        int[] tmp = new int[arr.length];

        // 원본 배열, 임시 저장소, 시작과 끝 인덱스를 넘겨줘서 재귀함수 호출
        mergeSort(arr, tmp, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int[] tmp, int start, int end) {
        if (start < end) {   // 시작 인덱스가 끝 인덱스보다 작은 동안만 재귀호출
            int mid = (start + end) / 2;    // 물리적으로 딱 가운데를 잘라야 하므로 가운데 인덱스 필요
            mergeSort(arr, tmp, start, mid);    // 배열의 앞부분. start ~ 가운데까지
            mergeSort(arr, tmp, mid + 1, end);  // 배열의 뒷부분. 가운데 바로 뒤 ~ end까지
            merge(arr, tmp, start, mid, end);   // 두 개로 나누어진 배열방을 합쳐줄 함수
        }
    }

    private static void merge(int[] arr, int[] tmp, int start, int mid, int end) {
        // 우선, 임시 저장소에 정렬이 된 배열을 필요한 만큼 복사해준다.
        for (int i = start; i <= end; i++) {
            tmp[i] = arr[i];
        }

        int part1 = start;
        int part2 = mid + 1;

        // 양쪽 배열방에서 작은 값을 하나씩 복사할 때마다
        // 결과 배열방의 어디에 저장해야하는지 알아야 하니까
        // 복사 후에 하나씩 늘려줘서 다음에 저장할 곳을 기억
        int index = start;

        while (part1 <= mid && part2 <= end) {   // 첫 번째 배열이 끝까지 가거나 두 번째 배열이 끝까지 갈 때까지 반복문
            // 두 배열방의 첫 번째 값부터 비교해서 
            // 앞에 게 작으면 앞에 걸 옮기고 앞쪽 포인터를 하나 뒤로 옮긴다
            // 뒤에 게 작으면 뒤에 걸 옮기고 뒤쪽 포인터를 하나 앞으로 옮긴다
            if (tmp[part1] <= tmp[part2]) {
                arr[index] = tmp[part1];
                part1++;
            } else {
                arr[index] = tmp[part2];
                part2++;
            }
            // 어느쪽 배열을 옮겼든지 간에 인덱스는 하나 늘려줘야 해
            index++;
        }   // 이렇게 계속 돌리면 양쪽 중 하나가 끝날 때까지 돌겠죠?

        // 그런데 만약 뒤쪽은 비었고 앞쪽에는 데이터가 남아있는 경우를 대비해서
        // 앞쪽 포인터가 배열의 끝에서 남은 만큼을 돌면서 최종적으로 저장할 배열에 남은 값들을 붙여줍니다.
        for (int i = 0; i <= mid - part1; i++) {
            arr[index + i] = tmp[part1 + i];
        }

        // 만약 앞쪽 배열은 비어있고, 뒤쪽 배열에 데이터가 남아있는 경우는?
        // 뒤쪽 배열은 최종 배열의 뒤쪽에 이미 자리하고 있기 때문에
        // 뒤쪽에 남은 데이터는 신경 안 쓰고 놔두면 됨 !
    }

    public static void main(String[] args) {
        int[] arr = {3, 9, 4, 7, 5, 0, 1, 6, 8, 2};
        System.out.println(Arrays.toString(arr));
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

```


<br>

**2025.02.16 일요일**  
> ### BOJ11726. 2xN 타일링  
> ***DP***  
> - 사실 이거 예전에 싸피 비전공자 CT 시험 대비할 때 본 적 있는 문제라서 점화식을 알고는 있었는데  
> 납득이 잘 안 돼서 나름대로 처음부터 풀어보려고 했음.  
> f(n-2)에 두 칸짜리 타일을 더하는 경우 & f(n-1)에 한 칸짜리 타일을 더하는 경우로 나누어진다는 건 알았는데  
> 타일을 더할 때 앞에 더할지, 중간에 더할지, 뒤에 더할지 또 나뉘는 게 아닌가? 라는 생각이 자꾸 들었다. 괜한 호승심 ㅜ  
> 근데 혼자 처음부터 설계하다가 꼬여서 그냥 기존에 알고 있던 공식을 증명하는 방식으로 틀었더니 납득이 됐다.  
> 그려보니까 어차피 f(n-2)랑 f(n-1) 단계에서 그 경우의 수들을 다 포함하면서 올라오는 거였음. 허무해...ㅋㅋㅋ   
> - 근데 이거 직접 해보면서 잘못된 공식을 세운 덕분에 Math.pow(num, power) 함수를 알게됐다. 그럼그렇지 제곱 함수가 없을 리가 없어.

```
package groupstudy.algorithm_lunchStudy;

import java.util.Scanner;

public class BOJ11726_2xN타일링 {
    /**
     * 2xN 타일링
     * <a href="https://www.acmicpc.net/problem/9375">...</a>
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[1001];
        // dp의 인덱스는 전체 길이 n
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3 ; i < dp.length ; i++) {
            dp[i] = (dp[i-2] + dp[i-1]) % 10007;
        }

        System.out.println(dp[n]);

    }
}

```

<br>


> ### SWEA21936. 길이가 M인 회문 찾기
> ***탐색***
> - 난이도가 D1이길래 만만하게 보고 풀었다가 생각보다 좀 꼬였다. 푸는 데 1시간 정도 걸린 듯?  
> 매번 난이도 쉬운 문제마다 이러는 것 같다.
> 접근법을 모르겠다거나 어려운 건 아닌데, 더 고급지게 풀고 싶다는 욕심에 단순한 답을 두고 어렵게 고민하는 경향이 있다.  
> 안 좋은 버릇...고쳐야지. 난이도만 보고 만만하게 보지 말 것 !

```
package SWEA;

import java.util.Scanner;

public class SWEA21936_길이가M인회문찾기 {
    /**
     * 길이가 M인 회문 찾기
     * <a href="https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AZFkKmLa1zEDFAQW">...</a>
     */

    public static void main(String[] args) {
        // start = 0 -> n-m 까지 옮기면서
            // i = 0 -> m/2
                // start + i 랑 start + m - 1 - i 랑 같은지 비교
                // 달라지면 break
        // 반복문 끝나면 start 부터 start + m-1-i 까지 출력

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int t = 1 ; t <= T ; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            String str = sc.next();
//            System.out.println(str);
            boolean flag = false;

            for(int i = 0 ; i <= N-M ; i++) {
//                System.out.println(i + "에서 시작하는 문자열");
                for ( int j = 0 ; j <= (M-1)/2 ; j++) {
                    if (str.charAt(i + j) == str.charAt(i + M - 1 - j)) {
                        flag = true;
//                        System.out.println(str.charAt(i + j) + " vs " + str.charAt(i + M - 1 - j));
                    } else {
                        flag = false;
//                        System.out.println(str.charAt(i + j) + " vs " + str.charAt(i + M - 1 - j));
                        break;
                    }
                }
                if(flag) {
//                    System.out.println("문자열 찾음 ! ");
                    System.out.print("#" + t  + " ");
                    for(int j = i ; j <= i + M - 1 ; j++) {
                        System.out.print(str.charAt(j));
                    }
                    System.out.println();
                    break;
                }
            }

            if(!flag) {
                System.out.println("#" + t  + " NONE");
            }




        }
    }
}

```

<br>

> ### SWEA12712. 파리잡기3
> ***2차원배열 탐색***
> - 사전학습 때 풀어본 문제기도 하고 워낙 많이 해본 종류의 문제다 보니 설계는 진짜 금방 했는데 자꾸 값이 틀리게 나와서 당황했다.  
> 알고보니 곱하기 모양 델타값을 잘못 설정해줌......  
> 이런 사소한 실수들 언제쯤 줄어들까ㅠ

```
package SWEA;

import java.util.Scanner;

public class SWEA12712_파리퇴치3 {
    /**
     * 파리퇴치3
     * <a href="https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AXuARWAqDkQDFARa">...</a>
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[][] map = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

//            for(int i= 0 ; i < N ; i++) {
//                for(int j = 0 ; j < N ; j++) {
//                    System.out.print(map[i][j] + " ");
//                }
//                System.out.println();
//            }

            int max = 0;

            int[] dx1 = {-1, 0, 1, 0};
            int[] dy1 = {0, 1, 0, -1};

            int[] dx2 = {-1, -1, 1, 1};
            int[] dy2 = {-1, 1, -1, 1};

            // 한 위치에서 +, x 둘 다 검사해야 함
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
//                    System.out.println("현재 위치 : (" + i + "," + j + ")");
                    // + 검사
                    int plussum = map[i][j];
                    for (int m = 1; m < M; m++) {
                        for (int d = 0; d < 4; d++) {
                            int nx = i + dx1[d] * m;
                            int ny = j + dy1[d] * m;

                            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
//                                System.out.print(map[nx][ny] + " ");
                                plussum += map[nx][ny];
//                                System.out.println("현재 plussum : " + plussum);
                            }
                        }
//                        System.out.println();

                    }

                    // x 검사
                    int xsum = map[i][j];
                    for (int m = 1; m < M; m++) {
                        for (int d = 0; d < 4; d++) {
                            int nx = i + dx2[d] * m;
                            int ny = j + dy2[d] * m;

                            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                                xsum += map[nx][ny];
                            }

                        }
                    }

                    // 두 개 중 더 큰 값 비교
//                    System.out.println("현재 위치 : (" + i + "," + j + ")");
//                    System.out.println("xsum : " + xsum + " plussum : " + plussum);
                    max = Math.max(max, Math.max(xsum, plussum));
                }

            }

            System.out.println("#" + t + " " + max);
        }
    }
}

```

<br>

> ### SWEA11315. 오목판정
> ***2차원배열 탐색***
> - 반복문이 많아지면 일단 머리가 아프다. 아이디어만 떠올리면 구현 자체는 간단한 게 좋아. 일단 앞에 indent 가 늘어나면 모든 게 귀찮아진다... 집중해서 꼼꼼하게 쓰는 연습을 해야 하는데... 특히나 이런 문제는 또 크게 어렵진 않은데 내가 유독 귀찮아하는 문제라 더더욱 집중력을 자꾸 잃는 것 같다.
```
package SWEA;

import java.util.Scanner;

public class SWEA11315_오목판정 {
    /**
     * 오목판정
     * <a href="https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXaSUPYqPYMDFASQ">...</a>
     */

    static char[][] board;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            // 판 만들기
            int N = sc.nextInt();
            board = new char[N][N];
            for (int i = 0; i < N; i++) {
                String str = sc.next();
                for (int j = 0; j < N; j++) {
                    board[i][j] = str.charAt(j);
                }
            }

            // o 찾기
            if (search()) {
                System.out.println("#" + t + " YES");
            } else {
                System.out.println("#" + t + " NO");
            }

        }
    }

    private static boolean search() {
        int[] dx = {0, 1, 1, -1};
        int[] dy = {1, 0, 1, 1};

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 'o') {
                    for (int d = 0; d < 4; d++) {
                        int cnt = 1;
                        for (int n = 1; n < 5; n++) {
                            int nx = i + dx[d] * n;
                            int ny = j + dy[d] * n;

                            if (nx >= 0 && ny >= 0 && nx < board.length && ny < board.length) {
                                if (board[nx][ny] == 'o') {
                                    cnt++;
                                } else {
                                    break;
                                }
                            }
                        }
                        if (cnt == 5) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }
}

```



<br>

**2025.02.16 월요일**  
> ### SWEA6485. 삼성시의 버스 노선
> - 입력 받을 게 많아서 문제 이해하는 게 오래 걸려서 그렇지 푸는 것 자체는 어렵지 않았음
> - 문제가 너무 읽기 귀찮아서 일단 냅다 입력 받을 것부터 입력 받고 시작했더니 훨씬 빠르게 이해가 됐다

```
package SWEA;

import java.util.Scanner;

public class SWEA6485_삼성시의버스노선 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int t = 1; t <= T ; t++) {
            int[] arr = new int[5001];
            System.out.print("#" + t + " ");
            int N = sc.nextInt();   // 버스 노선
            for (int n = 1; n <= N; n++) {  // 노선마다 수행해줌
                int A = sc.nextInt();   // 해당 노선의 출발
                int B = sc.nextInt();   // 해당 노선의 도착
                for(int i = A ; i <= B ; i++) {
                    arr[i] ++;  //  정류장 지나가면서 cnt 하나씩 올려줘
                }
            }

            int P = sc.nextInt();   // 노선 개수 구해줄 정류장 개수
            for (int p = 1; p <= P; p++) {
                int C = sc.nextInt();
                System.out.print(arr[C] + " ");
            }

            System.out.println();
        }
    }
}

```

<br>

> ### SWEA7102. 준홍이의 카드놀이
> - 오늘 시험도 그렇고 버스 노선도 그렇고...자꾸 카운트만 쓰는 기분인데....메모리가 낭비되고 있는 듯한 찜찜함.....
> - 솔빈이 코드 설명 들었는데 솔빈이는 가장 자주 등장하는 숫자를 수학적 규칙으로 찾아내서 풀었다. 훨씬 간단하고 좋아서 나도 저렇게 풀고 싶어  
> (=> N까지의 숫자와 M까지의 숫자를 더해서 나올 수 있는 조합 중 가장 많이 등장하는 값은 N+1부터 M+1까지)
```
// 솔빈이 풀이
int min = Math.min(n, m);
int max = Math.max(n, m);
for (int i = min + 1; i <= max + 1; i++) {
    sb.append(" ").append(i);    
}
```
```
// 내 풀이
import java.util.Scanner;

public class SWEA7102_준홍이의카드놀이 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int t = 1; t <= T ; t++) {
            System.out.print("#" + t + " ");
            int N = sc.nextInt();
            int M = sc.nextInt();

            int[] cnt = new int[N+M+1];

            for(int i = 1; i <= N ; i++){
                for(int j = 1; j <= M ; j++)
                    cnt[i+j] ++;
            }

            int max = 0;
            for(int i= 0 ; i < cnt.length; i++)
                max = Math.max(max, cnt[i]);


            for(int i = 0 ; i < cnt.length;i++) {
                if(cnt[i] == max)
                    System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}

```

<br>

> ### SWEA6190. 정곤이의 단조 증가하는 수
> - 문제 제대로 읽을 것 ㅠㅠ 단조 증가하는 수가 없다면 -1을 출력한다는 부분 못 봐서 한 번 틀렸다
> - String으로 변환해서 각 자리수 char 로 비교해서 푼 거 좀 잘한 듯!!
```
package SWEA;

import java.util.Scanner;

public class SWEA6190_정곤이의단조증가하는수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            // 숫자들 배열에 담아주기
            int N = sc.nextInt();
            int[] arr = new int[N];
            for (int n = 0; n < N; n++) {
                arr[n] = sc.nextInt();
            }

            int max = -1;

            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    int mul = arr[i] * arr[j];

                    // mul이 단조 증가하는 수인지 판단해 줄 거야
                    String mul2 = mul + "";
                    int loc = 0;
                    // 글자 하나씩 지나가면서 끝까지 증가하면 max 갱신
                    for (int l = 0; l < mul2.length() - 1; l++) {
                        if (mul2.charAt(l) > mul2.charAt(l + 1)) break; // 감소했다면 그만 봐
                        loc++;  // 증가 중이라면 loc 올려줘
                    }
                    // mul 길이 다 돌고 나서
                    if (loc == mul2.length() - 1) {    // loc가 끝까지 증가했으면
                        max = Math.max(max, mul);
                    }
                }
            }



            System.out.println("#" + t + " " + max);
        }
    }
}

```


<br>

> ### SWEA3499. 퍼펙트 셔플
> - 쉽게 풀기는 했는데 뭔가 너무 단순하게 푼 것 같아서 이래도 되나 싶음

```
import java.util.Scanner;

public class SWEA3499_퍼펙트셔플 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int t = 1 ; t <= T ; t++) {
            System.out.print("#" + t + " ") ;
            // 카드 리스트 만들어주기
            int N = sc.nextInt();
            String[] cards = new String[N];
            for(int i = 0 ; i < N ; i++) {
                cards[i] = sc.next();
            }

            // 반으로 쪼갠 카드리스트 두 개 만들어주기
            String[] cards1 = new String[(N+1)/2];  // 홀수일 경우 얘한테 하나 더 넣어줄 거야
            String[] cards2 = new String[N/2];

            for(int i = 0 ; i < (N+1)/2 ; i++) {
                cards1[i] = cards[i];
            }

            for(int i = (N+1)/2 ; i < N ; i++) {
                cards2[i-(N+1)/2] = cards[i];
            }

            for(int i= 0 ; i < (N+1)/2 ; i++) {
                System.out.print(cards1[i] + " ");
                if(i < N/2)
                    System.out.print(cards2[i] + " ");
            }
            System.out.println();
        }


    }
}

```

<br>

> ### SWEA1989. 초심자의 회문 검사
> - for문에 이름 붙여서 제어해줄 수 있다는 걸 알고는 있었는데 써 본 적은 없다가, 아까 솔빈이가 쓴 거 보고 써봤다. 확실히 훨씬 편한 듯 !  
> 오목판정 풀 때도 그냥 얌전히 썼으면 조금은 더 쉽게 풀었을 것 같은데 괜히 오기부려서 오래 풀었나봐

```
package SWEA;

import java.util.Scanner;

public class SWEA1989_초심자의회문검사 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        testcase:
        for(int t = 1; t <= T ; t++) {
            String word = sc.next();
            for(int i = 0 ; i < word.length()/2 ; i++) {
                if(word.charAt(i) != word.charAt(word.length()-1-i)) {
                    System.out.println("#" + t + " " + 0);
                    continue testcase;
                }
            }
            System.out.println("#" + t + " " + 1);
        }
    }
}

```

<br>


> ### 알고리즘 과목 평가 - 호텔 방 배정하기
> - 조건 나눠주는 거 평소에 어려워했는데 이번에 좀 잘한 것 같아서 뿌듯했다. 한 줄마다 주석 강제로 쓰면서 머리가 더 잘 정리된 듯
> - 근데 현욱이 코드 보니까 진짜 짧게 잘 짜서 신기했다. 많이 풀다 보면 저런 코드가 나오려나.
```

import java.util.Scanner;

public class Algo2_서울_9반_이언지 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // 입력 받아줄 스캐너

		int T = sc.nextInt(); // 테스트케이스 입력 받기
		for (int t = 1; t <= T; t++) { // 테스트케이스만큼 반복
			int N = sc.nextInt(); // 초기 호텔의 객실수
			int M = sc.nextInt(); // 방문할 가족의 수

			int[] arr = new int[N]; // 객실 수만큼 방 만들어주기
			int idx = 0; // 어디부터 사람 넣어줄지 표시하는 인덱스

			for (int m = 0; m < M; m++) {
				int num = sc.nextInt(); // 이번에는 몇 명이 방문하나요 ?


				if (arr[0] == 0) { // 만약 첫칸이 비었으면
					for (int i = 0; i < num; i++) { // 첫 칸부터 num 칸만큼
						arr[i] = 1; // 사람을 넣어줘
					}
					idx = num + 1; // 다음 팀 넣어줄 첫 번째 인덱스
				}

				else { // 만약 첫 칸이 차 있으면 봐 가면서 넣어야 해
					if (idx + num - 1 <= arr.length - 1) { // 넣어줄 수 있는 시작점 ~ 마지막 방까지 인원수만큼 충분한 방이 비었으면
						for (int i = idx; i < idx + num; i++) { // idx번째 칸부터 num 칸만큼
							arr[i] = 1; // 사람을 넣어줘
						}
						idx = idx+num + 1; // 다음 팀 넣어줄 인덱스 업데이트
					} else if (idx + num - 2 <= arr.length - 1) { // idx번째 방부터는 없긴 한데 idx는 한 칸 띄우고 센 거니까...혹시나 한 칸 안 띄우고 세면 수용 가능할수도?
						for (int i = idx - 1; i < idx + num - 1; i++) { // idx-1 번째 칸부터 num 칸만큼
							arr[i] = 1; // 사람 넣어줘
						}
						idx = idx+num; // 인덱스 업데이트
					} else if (num == 1) { // 끝까지 왔는데 내가 한 명이야. 그럼 아까 띄워둔 방에 넣어줄 수도 있어
						for (int i = 0; i < arr.length; i++) { // 돌면서 빈칸 찾아서 넣어줄게
							if (arr[i] == 0)  { // 빈칸 찾음
								arr[i] = 1; // 냉큼 입장
								break;
							}
						}
					}
				}
				

//				System.out.println(Arrays.toString(arr));
			}

			int cnt = 0; // 다 넣어주고 나면 이제 빈 칸 개수 세줄거야
			for(int i= 0 ;i < arr.length ; i++) {	// 배열 전체 돌면서
				if(arr[i] == 0)	// 빈 칸 발견하면
					cnt++;	// cnt 올려주기
			}
			
			System.out.println("#" + t + " " + cnt);	// 양식에 맞춰서 빈 칸 개수 출력
		}

	}
}

```

<br>


> ### SWEA1225. 암호생성기
> ***Queue***
> - 삽입, 삭제 많으니까 LinkedList 써야지~ 하고 풀었는데 Queue 쓰는 문제였음 ㅎ 그래서 Queue로 다시 풀었어.
> - 근데 난이도에 비해 시간을 너무 쓰는 것 같음...ㅜ 시간 재면서 푸는 습관을 들여야하는데....

```
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA1225_암호생성기_2 {
    /**
     * 암호생성기_2 (Queue 써서 풂)
     * <a href="https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14uWl6AF0CFAYD&">...</a>
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int t = 1; t <= 10; t++) {
            sc.nextInt();

            Queue<Integer> queue = new LinkedList<>();

            // 기존 숫자들 queue에 넣어주기
            for (int i = 0; i < 8; i++)
                queue.add(sc.nextInt());

            // cycle
            int i = 0;
            while (i++ <= 5) {
                int next = Math.max(queue.poll() - i, 0);
                queue.add(next);
                if(next == 0)
                    break;

                if(i == 5)
                    i = 0;

            }

            StringBuilder sb = new StringBuilder();
            sb.append("#" + t + " ");
            while(!queue.isEmpty()) {
                sb.append(queue.poll() + " ");
            }
            System.out.println(sb);

        }
    }
}

```

<br>

> ### SWEA2805. 농작물 수확하기
> ***2차원 배열***
> - 사방탐색을 할까, 그냥 행 내려오면서 더해줄까 고민했다. 사방탐색 도전했다가 너무 어려워서 그냥 별 찍기처럼 규칙 정해서 더해줬다.
> - 생각보다 오래 걸렸다. 사소하게 꼬인 경우도 많았음. 주석이나 메모를 하면서 했어야 하는데, 뭔가 설명 쓰는 게 더 어려워서 자꾸 냅다 코드 써서 꼬인 것 같다. 생각 정리하는 연습을 해야지.

```
package SWEA;

import java.io.*;

public class SWEA2805_농작물수확하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            // map 만들어줄게
            int N = Integer.parseInt(br.readLine());
            int[][] map = new int[N][N];
            int[][] visited = new int[N][N];
            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                String[] strs = str.split("");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(strs[j]);
                }
            }

            int sum = 0;
            int len = 1;
            int startIdx = N / 2;
            for (int i = 0; i < N; i++) {   // 행 내려갈 때마다
                for(int j = startIdx ; j < startIdx + len ;j++) { // startIdx부터 길이만큼 더해줄 거야
                    sum += map[i][j];
                }

                if(i < N/2) {
                    len += 2;
                    startIdx--;
                } else {
                    len -=2;
                    startIdx++;
                }
//                System.out.println("현재 행 : " + i + " sum : " + sum);
            }


            System.out.printf("#%d %d\n", t, sum);

        }
    }
}

```

<br>

**2025.02.17 화요일**  
> ### SW역량검정시험 A형 화분 키우기 (실패)
> - DP 쓰는 것까진 알았는데 세상에서 제일 더러운 코드를 쓰고 실패했다. 공개 테스트케이스 3개는 맞았는데 손으로 해본 거 틀려서...아마 밑에는 거의 다 틀리지 않았을까.
> - 규칙이 어렴풋이 감만 오고 구현이 안 된다. 언제쯤 생각한 게 챡챡 코드로 정돈이 될까.

```
import java.util.Scanner;

public class A_화분키우기_fail {


    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int P = sc.nextInt();

            // 첫 번째 [] = 몇 번째 화분인가?
            // 두 번째 [] = 몇 번째 비료인가?
            int[][] plants = new int[N][2];
            for (int n = 0; n < N; n++) {
                plants[n][0] = sc.nextInt();
            }
            for (int n = 0; n < N; n++) {
                plants[n][1] = sc.nextInt();
            }

            int[] dp1 = new int[N]; // 첫 번째 화분에 첫 번째 비료를 준 경우
            int prechoice = 0;
            int theother = 1;
            dp1[0] = plants[0][prechoice];
            for (int i = 1; i < N; i++) {
                if (i <= N - 2) {
                    if (dp1[i - 1] + plants[i][prechoice] - P
                            + Math.max(plants[i + 1][prechoice] - P, plants[i + 1][theother]) > dp1[i - 1]
                            + plants[i][theother]
                            + Math.max(plants[i + 1][prechoice], plants[i + 1][theother] - P)) {
                        dp1[i] = dp1[i - 1] + plants[i][prechoice] - P;
                    } else {
                        dp1[i] = dp1[i - 1] + plants[i][theother];
                        int temp = prechoice;
                        prechoice = theother;
                        theother = temp;
                    }

                } else {
                    if (dp1[i - 1] + plants[i][prechoice] - P > dp1[i - 1] + plants[i][theother]) {
                        dp1[i] = dp1[i - 1] + plants[i][prechoice] - P;
                    } else {
                        dp1[i] = dp1[i - 1] + plants[i][theother];
                        int temp = prechoice;
                        prechoice = theother;
                        theother = temp;
                    }
                }
            }

//			System.out.println(Arrays.toString(dp1));

            int[] dp2 = new int[N]; // 첫 번째 화분에 두 번째 비료를 준 경우
            prechoice = 1;
            theother = 0;
            dp2[0] = plants[0][1];
            for (int i = 1; i < N; i++) {
                if (i <= N - 2) {
                    if (dp2[i - 1] + plants[i][prechoice] - P
                            + Math.max(plants[i + 1][prechoice] - P, plants[i + 1][theother]) > dp2[i - 1]
                            + plants[i][theother]
                            + Math.max(plants[i + 1][prechoice], plants[i + 1][theother] - P)) {
                        dp2[i] = dp2[i - 1] + plants[i][prechoice] - P;
                    } else {
                        dp2[i] = dp2[i - 1] + plants[i][theother];
                        int temp = prechoice;
                        prechoice = theother;
                        theother = temp;
                    }

                } else {
                    if (dp2[i - 1] + plants[i][prechoice] - P > dp2[i - 1] + plants[i][theother]) {
                        dp2[i] = dp2[i - 1] + plants[i][prechoice] - P;
                    } else {
                        dp2[i] = dp2[i - 1] + plants[i][theother];
                        int temp = prechoice;
                        prechoice = theother;
                        theother = temp;
                    }
                }
            }

//			System.out.println(Arrays.toString(dp2));

            int sum = Math.max(dp1[N - 1], dp2[N - 1]);

            System.out.println("#" + t + " " + sum);
        }
    }
}

```


> ### SW역량검정시험 IM 공 굴리기
> - 설계 + 구현 포함해서 1시간 15분 정도 걸렸다
> - 조건이 엄청 많은 편이 아니라서, bfs dfs 문제 풀어본 거 중에 평이한 난이도 수준? 그냥 세세하게 조금씩 꼬이는 것만 있었지 크게 문제되는 건 없었다
> - 다만 아쉬운 점... 재귀로 풀었는데 이거 스택 메모리 너무 많이 쓸 것 같아서 좀 더 단순하게 풀어보고 싶다

```
// 재귀 쓴 코드
import java.util.Scanner;

public class IM_공굴리기 {
    static int[][] map;
    static int[][] visited;
    static int cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            // map 만들기
            int N = sc.nextInt();
            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            int maxcnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    cnt = 1;
                    visited = new int[N][N];
                    // 출발 위치 넘겨서 dfs 돌리고, 출발 위치별로 다 비교해서 최대값 구하기
                    maxcnt = Math.max(maxcnt, move(i, j));
                }
            }

            System.out.printf("#%d %d \n", t, maxcnt);
        }
    }

    private static int move(int i, int j) {
//        System.out.println("현재 위치 :  " + j + " " + j);

        visited[i][j] = 1;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        // 네 방향 중 가장 낮은 값
        int cur = map[i][j];
        // 과 그 인덱스
        int minx = -1;
        int miny = -1;

        for (int d = 0; d < 4; d++) {
            int nx = dx[d] + i;
            int ny = dy[d] + j;

            // map 범위 벗어나지 않는 선에서 사방 탐색할 거야
            if (nx >= 0 && nx < map.length && ny >= 0 && ny < map.length ) {
                // 자 이제 나보다 작은데 내가 아직 안 가본 애들 골라줘
                if(map[nx][ny] < cur && visited[nx][ny] == 0) {
                    cur = map[nx][ny];  // 나를 옮겨주고
                    visited[nx][ny] = 1;    // visited 체크해줘
                    minx = nx;
                    miny = ny;
                }
            }
        } // 이거 통과했으면 이제 한 칸 이동한 거임

        if(minx != -1) {
            cnt ++; // 방금 저거 통과한 애가 동서남북 중에 하나라도 있었으면(= 이동했으면) cnt 올려줘
//            System.out.print(cnt + " ");
            move(minx, miny);    // 그리고 방금 그 위치에서 또 이동해줘야지
        } else {
            return cnt; // 갈 데 없어지면 끝내고 cnt 리턴해줘
        }

        return cnt;


    }
}

```


<br>

**2025.02.18 수요일**  
> ### BOJ17626. Four Squares
> ***DP***
> - 최대 제곱수 빼고 나머지 숫자 인덱스로 dp에서 찾고 1 더해주면 되겠다! 까지는 진짜 문제 보자마자 생각했어
> - 근데 최대 제곱수가 아니라 한 중간쯤 되는 제곱수 두 개 쓸 수도 있는 거였음...아무리 생각해도 이걸 찾아줄 방법이 생각 안 나서 gpt한테 도움 요청
> - 제곱수 다 빼보고, 그 나머지 찾고 1 더한 최소값 저장하는 코드를 줌.
> - 나 약간 반복문 쓰는 데 두려움이 있나봐. 아마 문제에 시간제한 0.5초인 거 보고 더더욱 반복문 쓰는 걸 고려 못한 듯.
> 특히 DP는 뭔가 돌아가면 안 될 것 같아서 바로바로 저장하면서 가는 방법을 찾으려고 한 것 같은데 일단 방법을 다 써봤어야 함.  
> 뭔가 공부할수록 점점 사고가 좁아지는 것 같아서 걱정이 된다,,,,아무것도 모르던 초반에 어케든 풀겠다고 아는 거 총동원해서 이것저것 시도해보던 마인드를 유지하고 싶어
> - 그래도 이거 풀면서 Math.sqrt() 함수 처음 써봤다 ! 결과적으로 필요 없었지만 ㅋㅋ

```
package groupstudy.algorithm_lunchStudy;

import java.io.*;

public class BOJ17626_FourSquares {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] square = new int[224];
        for (int i = 1; i < 224; i++) {
            square[i] = i * i;
        }

        // 냅다 하나씩 정리해주면
        int[] dp = new int[N+1];

        for(int i = 1; i <= N ; i++) {
            dp[i] = i;
        }

        for(int i = 1; i * i <= N ; i++) { 
            int sqr = i*i;  /// 현재 제곱수 
            for (int j = sqr ; j <= N ; j++) {
                dp[j] = Math.min(dp[j-sqr]+1, dp[j]);
            }
        }

        System.out.println(dp[N]);

    }
}

```

<br>


> ### 자료구조 공부 (Deque)
> ***Deque***
> - 앞에서도 꺼낼 수 있고 뒤에서도 꺼낼 수 있는 자료구조
> - Deque은 인터페이스 ! 구현한 클래스로는 ArrayDeque, LinkedBlockingDeque, ConcurrentLinkedDeque, LinkedList 등이 있다
> - Deque을 활용해서 스택도 만들 수 있고 큐도 만들 수 있다

> ### 자료구조 공부 (Priority Queue)
> ***Priority Queue***
> - 들어오는 순서와 상관없이 우선순위가 높은 데이터가 먼저 나가는 구조
> - Priority Queue에서 우선순위 기준을 정의할 때는 Compare 메서드를 Override 해주면 된다
```  
<example> 
public int compare(Student o1, Student o2) {
    if (o1.mathScore == o2.mathScore) {
        return o2.engScore - o1.engScore;
    } else {
        return o1.mathScore - o2.mathScore;
    }
}
```

> ### 자료구조 공부 (Heap)
> ***Heap***
> - 완전 이진 트리의 일종으로, 우선순위 큐를 위하여 만들어진 자료구조
> - 여러 개의 값들 중에서 최댓값이나 최솟값을 빠르게 찾아냄
> - 반정렬 상태(느슨한 정렬 상태) 유지  
> : 부모 노드의 키 값이 자식 노드의 키 값보다 항상 크거나 작은 이진 트리
> - 힙 트리에서는 중복값 허용 O, 이진 탐색 트리에서는 중복값 허용 X
> - 힙을 저장하는 표준 자료구조는 배열이다. 보통 0번째 인덱스는 사용하지 않는다.
> - 특정 위치의 노드 번호는 새로운 노드가 추가되어도 변하지 않는다. ex) 루트 노드의 오른쪽 노드 번호는 항상 3이다.
> - 왼쪽 자식의 인덱스 = 부모인덱스 * 2  
> 오른쪽 자식의 인덱스 = 부모인덱스*2 + 1  
> 부모인덱스 = 자식인덱스/2
> - 삽입 방법  
>   1. 인덱스 순으로 가장 마지막 위치에 이어서 새로운 요소 삽입
>   2. 부모 노드 < 삽입 노드면 서로 교환 => 이 과정을 부모 노드가 더 클 때까지 반복
> - 삭제 방법 (최대 힙으로 예시)   
>   - 최대 힙에서 삭제 연산은 최댓값을 가진 요소를 삭제하는 것이다
>   1. 최댓값인 루트노드를 삭제 (빈자리에는 최대힙의 마지막 노드를 삽입)
>   2. 삽입 노드와 자식 노드를 비교, 자식 노드 중 더 큰 값과 교환 => 이 과정을 자식 노드가 둘 다 자기보다 더 작을 때까지 반복


**2025.02.18 수요일**  
> ### A_화분 키우기
> - 계속 뒤에 넘어갈 숫자들을 고려해서 현재를 정하려고 했는데, 어디서 넘어왔냐를 따져서 값을 정해야하는 거였음.
> - 진짜 제일 억울한 점은 전에 계단 문제 풀 땐가 비슷한 생각을 한 적이 있어ㅠㅠ 근데 이번엔 왜 생각을 못 해냈을까...ㅜㅜ  
> 계단 문제랑 비슷하게 풀면 되겠는데? 까지는 생각을 했는데 키포인트가 기억이 안 났어...바보야...  
```
import java.util.Scanner;

public class A_화분키우기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int P = sc.nextInt();
            int[] fer1 = new int[N];
            int[] fer2 = new int[N];

            for (int i = 0; i < N; i++)
                fer1[i] = sc.nextInt();
            for (int i = 0; i < N; i++)
                fer2[i] = sc.nextInt();

            for(int i = 1 ; i < N ; i++) {
                fer1[i] = Math.max(fer1[i-1] + fer1[i] - P, fer2[i-1] + fer1[i]);
                fer2[i] = Math.max(fer2[i-1] + fer2[i] - P, fer1[i-1] + fer2[i]);
            }

            int ans = Math.max(fer1[N-1], fer2[N-1]);

            System.out.println(ans);
        
        }
    }
}

```