import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        List<Integer> results = new ArrayList<>();

        for(int i = 0; i < T; i++) {

            int food = Integer.parseInt(br.readLine());
            int sum = 0;
            int days = 1;

            String[] pigInput = br.readLine().split(" ");

            for(int j = 0; j < pigInput.length; j++) {
                sum += Integer.parseInt(pigInput[j]);
            }

            while(true) {
                if(sum > food)
                    break;

                sum *= 4;
                days++;
            }

            results.add(days);
        }

        for(int result : results) {
            System.out.println(result);
        }
    }
}
