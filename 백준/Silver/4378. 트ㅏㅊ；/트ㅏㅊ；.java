import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String qwerty = "`1234567890-=QWERTYUIOP[]\\ASDFGHJKL;'ZXCVBNM,./";
        Map<Character, Character> keyMap = new HashMap<>();

        for(int i = 1; i < qwerty.length(); i++) {
            keyMap.put(qwerty.charAt(i), qwerty.charAt(i - 1));
        }

        String line;

        while((line = br.readLine()) != null) {

            StringBuilder sb = new StringBuilder();

            for(char c : line.toCharArray()) {
                if(c == ' ' || !keyMap.containsKey(c))
                    sb.append(c);
                else
                    sb.append(keyMap.get(c));
            }

            System.out.println(sb.toString());
        }
    }
}
