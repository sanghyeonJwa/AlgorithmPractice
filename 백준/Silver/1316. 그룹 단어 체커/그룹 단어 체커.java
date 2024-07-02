import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        sc.nextLine();
        int cnt = 0;

        for(int i = 1; i <= num; i++) {
            String word = sc.nextLine();
            if(groupWordChecker(word))
                cnt++;
        }

        System.out.println(cnt);
    }

    public static boolean groupWordChecker(String word) {

        boolean[] check = new boolean[26];
        char prev = ' ';

        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if(ch != prev) {
                if(check[ch - 'a']) {
                    return false;
                }
                check[ch - 'a'] = true;
            }
            prev = ch;
        }
        return true;
    }
}
