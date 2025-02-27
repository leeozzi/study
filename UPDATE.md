**2025.02.28 금요일**

> ### BOJ1672. DNA 해독
> ***Stack***
> - Stack 쓰는 거 바로 생각해냈었는데, 자꾸 메모리 초과 떠서 StringBuilder도 건드려보고 했는데  
> 원인은 dna 배열에 있었다. char[][]로 받았을 때랑 String[][]로 받았을 때랑 메모리 사용량이 거의 11배 가까이 차이 남
```
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[][] dna = {
                {'A', 'C', 'A', 'G'},
                {'C', 'G', 'T', 'A'},
                {'A', 'T', 'C', 'G'},
                {'G', 'A', 'G', 'T'}
        };

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('A', 0);
        map.put('G', 1);
        map.put('C', 2);
        map.put('T', 3);

        int n = Integer.parseInt(br.readLine());
        String line = br.readLine();

        Stack<Character> stack = new Stack<>();

        for(int i = 0 ; i < line.length() ; i++) {
            stack.push(line.charAt(i));
        }

        while(stack.size() > 1) {
            char b = stack.pop();
            char a = stack.pop();

            stack.push(dna[findidx(a)-1][findidx(b)-1]);
        }

        System.out.println(stack.pop());

    }

    private static int findidx(char c) {
        switch(c) {
            case 'A':
                return 1;
            case 'G':
                return 2;
            case 'C':
                return 3;
            case 'T':
                return 4;
        }

        return -1;
    }
}

```