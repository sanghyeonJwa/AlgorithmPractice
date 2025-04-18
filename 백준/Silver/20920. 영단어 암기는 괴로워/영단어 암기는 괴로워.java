import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        Map<String, Integer> wordCnt = new HashMap<>();

        for(int i = 0; i < N; i++) {
            String word = br.readLine();

            if(word.length() < M) continue;

            wordCnt.put(word, wordCnt.getOrDefault(word, 0) + 1);
        }

        List<String> words = new ArrayList<>(wordCnt.keySet());


        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int cnt1 = wordCnt.getOrDefault(o1, 0);
                int cnt2 = wordCnt.getOrDefault(o2, 0);

                if(cnt1 != cnt2) return cnt2 - cnt1;
                if(o1.length() != o2.length()) return o2.length() - o1.length();
                return o1.compareTo(o2);
            }
        });

        for(String word : words) {
            bw.write(word);
            bw.newLine();
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}
