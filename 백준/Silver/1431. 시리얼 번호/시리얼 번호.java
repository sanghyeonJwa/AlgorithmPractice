

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<String> words = new ArrayList<>();
        List<Integer> palindromes = new ArrayList<>();

        for(int i = 1; i <= N; i++) {
            words.add(br.readLine());
        }

        words.sort((str1, str2) -> {

            if(str1.length() != str2.length())
                return str1.length() - str2.length();

            int numSum1 = 0;
            int numSum2 = 0;

            for(int i = 0; i < str1.length(); i++) {
                if(Character.isDigit(str1.charAt(i))) {
                    numSum1 += str1.charAt(i) - '0';
                }

                if(Character.isDigit(str2.charAt(i))) {
                    numSum2 += str2.charAt(i) - '0';
                }
            }

            if(numSum1 != numSum2)
                return numSum1 - numSum2;

            return str1.compareTo(str2);
        });

        for(String word : words) {
            System.out.println(word);
        }

    }
}
