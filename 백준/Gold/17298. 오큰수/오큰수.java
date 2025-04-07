import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] result = new int[N];
        Stack<Integer> st = new Stack<>();

        for(int i = N - 1; i >= 0; i--) {

            while(!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }

            if(st.isEmpty()) {
                result[i] = -1;
            }
            else {
                result[i] = arr[st.peek()];
            }

            st.push(i);
        }

        StringBuilder sb = new StringBuilder();
        for(int number : result) {
            sb.append(number).append(" ");
        }

        System.out.println(sb.toString());

        br.close();
    }
}
