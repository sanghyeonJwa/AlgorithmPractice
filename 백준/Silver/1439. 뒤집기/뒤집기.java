

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();

        /*
        S5 - 뒤집기
        0과 1로 이루어진 문자열에서 가장 적은 횟수로 모두 같은 문자로 변경하기

        가장 적은 회수 구하는 문제 : BFS , DP 등등..

        연결된 문자열로 자르기 -> 0이 많은지 1이 많은지 판별해서 더 작은 수
         */

        int count0 = 0;
        int count1 = 0;

        // 이렇게 만들었더니 1000 같은 경우는 탐지 불가능함. 바뀐 시점에서 끝까지 동일한 문자인 경우를 확인 못햇음
        for(int i = 0; i < S.length() - 1; i++) {
            if(S.charAt(i) != S.charAt(i + 1)) {
                if(S.charAt(i) == '0') count0++;
                else count1++;
            }

            if(i == S.length() - 2) {
                if(S.charAt(i + 1) == '0') count0++;
                else count1++;
            }
        }

        System.out.println(Math.min(count0, count1));
    }
}
