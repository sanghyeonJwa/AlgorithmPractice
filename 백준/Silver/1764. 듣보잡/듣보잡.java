import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        Map<String, Integer> people = new HashMap<>();
        List<String> names = new ArrayList<>();
        int cnt = 0;

        for(int i = 0; i < N; i++) {
            String name = br.readLine();
            people.put(name, people.getOrDefault(name, 0) + 1);
        }

        for(int i = 0; i < M; i++) {
            String name = br.readLine();
            people.put(name, people.getOrDefault(name, 0) + 1);
            if(people.get(name) == 2) {
                names.add(name);
                cnt++;
            }
        }

        Collections.sort(names);

        System.out.println(cnt);
        for(String name : names) {
            System.out.println(name);
        }

        br.close();
    }
}
