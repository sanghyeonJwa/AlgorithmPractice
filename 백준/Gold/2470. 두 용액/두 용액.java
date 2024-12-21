import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] liquid = new int[n];
        String[] input = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            liquid[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(liquid);

        int left = 0;
        int right = liquid.length - 1;

        int result = Integer.MAX_VALUE;
        int answer1 = 0;    // 더 작은 값
        int answer2 = 0;    // 큰 값

        while(left < right) {

            int sum = liquid[left] + liquid[right];

            if (Math.abs(sum) < result) {   // Math.abs = 절대값
                result = Math.abs(sum);
                answer1 = liquid[left];
                answer2 = liquid[right];
            }

            if (sum < 0) {
                left++;
            }
            else {
                right--;
            }
        }

        System.out.println(answer1 + " " + answer2);
    }
}

