
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int K = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);

        int[] lines = new int[K];

        for (int i = 0; i < K; i++) {
            lines[i] = Integer.parseInt(br.readLine());
        }

        long left = 1;
        long right = Arrays.stream(lines).max().getAsInt();
        long result = 0;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long amount = 0;

            for (int line : lines) {
                amount += line / mid;
            }

            if (amount >= N) {
                result = mid;
                left = mid + 1; 
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);
    }
}
