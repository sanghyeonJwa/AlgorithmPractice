import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 문자의 개수
        int N = Integer.parseInt(br.readLine());
        Set<Character> set = new HashSet<>();

        String[] input = br.readLine().split(" ");

        for(String word : input) {
            set.add(word.charAt(0));
        }

        if(set.size() == 1)
            System.out.println(1);
        else
            System.out.println(0);
    }
}
