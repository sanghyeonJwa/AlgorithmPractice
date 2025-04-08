import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        Stack<Integer> st = new Stack<>();
        int sum = 0;

        for(int i = 0; i < K; i++) {
            int money = Integer.parseInt(br.readLine());

            if(money != 0) {
                st.push(money);
            }
            else {
                st.pop();
            }
        }

        while(!st.isEmpty()) {
            sum += st.pop();
        }

        System.out.println(sum);

        br.close();
    }
}
