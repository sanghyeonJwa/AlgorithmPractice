import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        /**
         * 다리 놓기
         * N (왼쪽) , M (오른쪽)
         * M에서 N만큼 선택하면 된다. mCn (조합)
         */

        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int[] result = new int[num];

        for(int i = 0; i < num; i++) {

            int n = sc.nextInt();
            int m = sc.nextInt();
            int answer = 1;

            for(int j = 1; j <= n; j++) {
                answer = answer * (m - j + 1) / j;
            }

            result[i] = answer;
        }
        
        for(int ans : result) {
            System.out.println(ans);
        }

    }
}
