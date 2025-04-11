import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> st = new Stack<>();

        int[] tower = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<Integer> answer = new ArrayList<>();


        for(int i = 0; i < N; i++) {

            while(!st.isEmpty() && tower[st.peek()] <= tower[i]) {
                st.pop();
            }

            if(st.isEmpty()) {
                answer.add(0);
            }
            else {
                answer.add(st.peek() + 1);
            }

            st.push(i);
        }

        for(int t : answer) {
            System.out.print(t + " ");
        }

        br.close();
    }
}
