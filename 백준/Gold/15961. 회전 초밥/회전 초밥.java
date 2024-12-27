import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]); // 접시의 수
        int d = Integer.parseInt(input[1]); // 초밥의 가짓 수
        int k = Integer.parseInt(input[2]); // 연속해서 먹는 접시의 수
        int c = Integer.parseInt(input[3]); // 쿠폰번호

        int answer = 0;

        int[] sushi = new int[N];

        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        Queue<Integer> q = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int uniqueSushi = 0;

        // 초기값
        for(int i = 0; i < k; i++) {
            q.add(sushi[i]);
            map.put(sushi[i], map.getOrDefault(sushi[i], 0) + 1);
            if(map.get(sushi[i]) == 1) {
                uniqueSushi++;
            }
        }

        answer = uniqueSushi + (map.getOrDefault(c, 0) == 0 ? 1 : 0);

        for(int i = 0; i < N; i++) {

            int remove = q.poll();
            map.put(remove, map.get(remove) - 1);
            if (map.get(remove) == 0) {
                uniqueSushi--;
            }

            int add = sushi[(i + k) % N];
            q.add(add);
            map.put(add, map.getOrDefault(add, 0) + 1);
            if (map.get(add) == 1) {
                uniqueSushi++;
            }

            answer = Math.max(answer, uniqueSushi + (map.getOrDefault(c, 0) == 0 ? 1 : 0));
        }

        System.out.println(answer);
    }
}

