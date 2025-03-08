import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int dasom = Integer.parseInt(br.readLine());
        int cnt = 0;

        List<Integer> candidates = new ArrayList<>();

        for(int i = 1; i < N; i++) {
            candidates.add(Integer.parseInt(br.readLine()));
        }

        while(!candidates.isEmpty()) {
            candidates.sort(Collections.reverseOrder());
            if(candidates.get(0) < dasom) break;

            candidates.set(0, candidates.get(0) - 1);
            dasom++;
            cnt++;
        }


        System.out.println(cnt);
    }
}
