import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Set<String> dance = new HashSet<>();
        dance.add("ChongChong");

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String A = st.nextToken();
            String B = st.nextToken();

            if(dance.contains(A) || dance.contains(B)) {
                dance.add(A);
                dance.add(B);
            }
        }

        System.out.println(dance.size());

    }
}
