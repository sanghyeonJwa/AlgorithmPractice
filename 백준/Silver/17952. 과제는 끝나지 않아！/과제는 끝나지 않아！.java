import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int result = 0;
        Stack<int[]> st = new Stack<>();

        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");

            if(input[0].equals("1")) {
                st.push(new int[]{Integer.parseInt(input[1]), Integer.parseInt(input[2])});
            }

            if(!st.isEmpty()) {
                int[] task = st.peek();
                task[1]--;

                if(task[1] == 0) {
                    result += task[0];
                    st.pop();
                }
            }
        }

        System.out.println(result);
    }
}
