

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Set<String> words = new HashSet<>();

        for(int i = 0; i < N; i++) {
            words.add(br.readLine());
        }

        List<String> wordsList = new ArrayList<>(words);
        wordsList.sort(Comparator.comparingInt(String::length)
                .thenComparing(Comparator.naturalOrder()));
        
        for(String word : wordsList) {
            System.out.println(word);
        }
    }
}
