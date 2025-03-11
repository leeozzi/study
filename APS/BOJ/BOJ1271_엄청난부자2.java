package BOJ;

import java.math.BigInteger;
import java.util.Scanner;

public class BOJ1271_엄청난부자2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger n = new BigInteger(sc.next());
        BigInteger m = new BigInteger(sc.next());
        System.out.println(n.divide(m));
        System.out.println(n.remainder(m));
    }
}
