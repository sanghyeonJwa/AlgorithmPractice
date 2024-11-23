import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");

        int N = Integer.parseInt(firstLine[0]);
        int M = Integer.parseInt(firstLine[1]);

        String[] secondLine = br.readLine().split(" ");
        int[] trees = new int[N];
        int maxTreeHeight = 0;

        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(secondLine[i]);
            maxTreeHeight = Math.max(maxTreeHeight, trees[i]);
        }

        
        long left = 0;
        long right = maxTreeHeight;
        long result = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long totalWood = calculate(trees, mid);

            if (totalWood >= M) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);
    }

    private static long calculate(int[] trees, long height) {
        long total = 0;
        for (int tree : trees) {
            if (tree > height) {
                total += (tree - height);
            }
        }
        return total;
    }
}
