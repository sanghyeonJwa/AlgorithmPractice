import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        /**
         * 변은 10으로 고정이다.
         * 100 x 100 평면의 검은색의 개수를 구하면 된다.
         */

        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();;
        int[][] paper = new int[100][100];
        int area = 0;

        for(int i = 0; i < num; i++) {
            
            int x = sc.nextInt();
            int y = sc.nextInt();

            for(int j = x; j < x + 10; j++) {
                for(int k = y; k < y + 10; k++) {
                    if(paper[j][k] == 1)
                        continue;
                    else {
                        paper[j][k] = 1;
                        area++;
                    }
                }
            }
        }

        System.out.println(area);
    }
}
