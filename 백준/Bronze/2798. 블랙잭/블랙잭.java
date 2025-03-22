import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]); // 카드 수
        int M = Integer.parseInt(input[1]); // 딜러가 외치는 수

        String[] cardInput = br.readLine().split(" ");
        int[] cards = new int[N];

        for(int i = 0; i < N; i++){
            cards[i] = Integer.parseInt(cardInput[i]);
        }

        int result = 0;

        for(int i = 0; i < N - 2; i++) {
            for(int j = i + 1; j < N - 1; j++) {
                for(int k = j + 1; k < N; k++) {
                    int sum = cards[i] + cards[j] + cards[k];
                    if(sum <= M && sum > result)
                        result = sum;
                }
            }
        }

        System.out.println(result);
    }
}
