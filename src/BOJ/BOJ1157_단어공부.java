package BOJ;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ1157_단어공부 {
    /**
     * 단어 공부
     * https://www.acmicpc.net/problem/1157
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String w = sc.next().toUpperCase();

        ArrayList<String> letters = new ArrayList<>();
        for ( int i =0 ; i < w.length() ; i++ ){
            String cur = w.charAt(i) + "" ;
            if(!letters.contains(cur)) letters.add(cur);
        }

        int[] cnts = new int[letters.size()];
        for ( int i =0 ; i < w.length() ; i++) {
            String cur = w.charAt(i) +"";
            int idxCur = letters.indexOf(cur);
            if(letters.contains(cur)) cnts[idxCur]++;
        }

        int maxCnt = 0;
        String ans = "";

        for(int i = 0 ; i < cnts.length; i++) {
            if(cnts[i] > maxCnt) {
                maxCnt = cnts[i];
                ans = letters.get(i);
            } else if (cnts[i] == maxCnt){
                maxCnt = cnts[i];
                ans = "?";
            }
        }

        System.out.println(ans);
    }
}
