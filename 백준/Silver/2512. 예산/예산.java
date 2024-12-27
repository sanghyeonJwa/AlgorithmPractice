

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] money = new int[N];

        for(int i = 0; i < N; i++) {
            money[i] = sc.nextInt();
        }

        int budget = sc.nextInt();

        int left = 1;
        int right = Arrays.stream(money).max().getAsInt();
        int result = 0;

        while(left <= right) {
            int mid = (left + right) / 2;
            int sum = 0;

            for(int i = 0; i < money.length; i++) {
                sum += Math.min(money[i], mid);
            }

            if(sum > budget) {
                right = mid - 1;
            }
            else {
                result = mid;
                left = mid + 1;
            }
        }

        System.out.println(result);
    }
}
