import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());    // 동규가 필요한 약의 개수

        StringBuilder sb = new StringBuilder();

        sb.append("2000\n");

        for(int i = 0; i < 1000; i++) {
            sb.append("1 ");
        }

        for(int i = 0; i < 1000; i++) {
            sb.append("1000 ");
        }

        System.out.println(sb.toString());

        br.close();
    }
}
