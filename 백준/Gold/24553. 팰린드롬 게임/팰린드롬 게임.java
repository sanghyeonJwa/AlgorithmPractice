import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++) {
            long number = Long.parseLong(br.readLine());

            if(number % 10 == 0) {
                sb.append(1).append("\n");
            }
            else {
                sb.append(0).append("\n");
            }
        }

        System.out.println(sb.toString());

        br.close();
    }
}
