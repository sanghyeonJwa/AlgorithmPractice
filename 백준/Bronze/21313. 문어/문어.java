import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        if(N % 2 == 0) {
            for(int i = 1; i <= N; i++) {
                sb.append(i % 2 == 0 ? 2 : 1).append(" ");
            }
        }
        else {
            for(int i = 1; i <= N; i++) {
                if(i == N) {
                    sb.append(3).append(" ");
                }
                else {
                    sb.append(i % 2 == 0 ? 2 : 1).append(" ");
                }
            }
        }

        System.out.println(sb.toString());

        br.close();
    }
}
