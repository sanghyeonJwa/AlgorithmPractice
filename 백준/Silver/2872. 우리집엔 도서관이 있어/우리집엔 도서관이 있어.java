import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] books = new int[N];

        for(int i = 0; i < N; i++) {
            books[i] = Integer.parseInt(br.readLine());
        }

        int result = N;
        // 맨 아래부터 연속으로 맞는 책 찾기
        for (int i = N - 1; i >= 0; i--) {
            if (books[i] == result) {
                result--;
            }
        }

        System.out.println(result);
    }
}
