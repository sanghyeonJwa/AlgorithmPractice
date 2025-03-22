import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] numbersInput = br.readLine().split(" ");
        int[] numbers = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(numbersInput[i]);
        }

        Arrays.sort(numbers);
        int maxSum = 0;

        while(true) {
            int sum = 0;
            for(int i = 0; i < N - 1; i++) {
                sum += Math.abs(numbers[i] - numbers[i + 1]);
            }

            if(sum > maxSum) {
                maxSum = sum;
            }

            int i = N - 1;
            while(i > 0 && numbers[i - 1] >= numbers[i]) {
                i--;
            }

            if(i <= 0)
                break;

            int j = N - 1;
            while(numbers[j] <= numbers[i - 1]) {
                j--;
            }

            int temp = numbers[i - 1];
            numbers[i - 1] = numbers[j];
            numbers[j] = temp;

            int left = i, right = N - 1;
            while(left < right) {
                temp = numbers[left];
                numbers[left] = numbers[right];
                numbers[right] = temp;
                left++;
                right--;
            }
        }

        System.out.println(maxSum);
    }
}
