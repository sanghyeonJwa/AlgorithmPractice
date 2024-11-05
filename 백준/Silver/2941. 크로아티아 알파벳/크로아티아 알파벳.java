import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        /**
         * 2941 / S5
         * 크로아티아 알파벳
         * String의 replace를 이용해보자.
         * 특정 타겟팅 문자열을 바꿀 수 있다. (문자만 바꿀 수 있는것이 아니다!!)
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String alphabet = br.readLine();

        String[] croatiaAlphabet = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        for(String word : croatiaAlphabet) {
            alphabet = alphabet.replace(word, "$");
        }

        System.out.println(alphabet.length());

        br.close();
    }
}
