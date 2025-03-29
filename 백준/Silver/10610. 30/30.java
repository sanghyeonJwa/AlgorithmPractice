import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();

        char[] NtoCharArray = N.toCharArray();
        boolean isNContainsZero = false;
        int sum = 0;

        for(char c : NtoCharArray) {
            if(c == '0')
                isNContainsZero = true;

            sum += c - '0';
        }

        if(isNContainsZero && (sum % 3 == 0)) {
            Arrays.sort(NtoCharArray);
            StringBuilder sb = new StringBuilder(new String(NtoCharArray));
            System.out.println(sb.reverse().toString());
        }
        else {
            System.out.println(-1);
        }
    }
}
