import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // S5 - 영화감독 숌
        /**
         * 무조건 숫자에 666이 들어가야 한다.
         * 1. 일차적인 생각으로는 666부터 1씩 늘려가면서 판단하는 방법이 있다.
         * 모든 수에 666이 들어가는지 판별하고 계산하는 방법
         */

        int movieNumber = Integer.parseInt(br.readLine());
        int numberFromHell = 666;
        int flag = 0;

        while(flag != movieNumber) {
            if(String.valueOf(numberFromHell).contains("666")) {
                flag++;
                numberFromHell++;
            }
            else
                numberFromHell++;
        }

        System.out.println(numberFromHell - 1);

        br.close();
    }
}
