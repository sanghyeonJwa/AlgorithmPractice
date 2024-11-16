import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        for(int i = 0; i < input.length(); i++) {

            if(isPalindrome(input.substring(i))) {
                System.out.println(input.length() + i);
                break;
            }
        }

        br.close();
    }

    private static boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;

        while(start < end) {
            if(str.charAt(start++) != str.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
