import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        int[] data = new int[N];

        for(int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(input[i]);
        }

        List<Integer> li = new ArrayList<>();

        for(int i = N; i >= 1; i--) {
            li.add(data[i - 1], i);
        }

        for(int number : li) {
            System.out.print(number + " ");
        }
    }
}
