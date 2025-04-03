import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        List<Integer> answer = new ArrayList<>();

        for(int i = 0; i < testCase; i++) {
            int k = Integer.parseInt(br.readLine());

            answer.add(k * 23);
        }

        for(int n : answer) {
            System.out.println(n);
        }
    }
}
