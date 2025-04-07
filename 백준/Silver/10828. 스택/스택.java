import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < N; i++) {

            String input = br.readLine();

            if(input.equals("pop")) {
                if(st.isEmpty()) {
                    sb.append("-1\n");
                }
                else {
                    sb.append(st.pop()).append("\n");
                }
            }
            else if(input.equals("size")) {
                sb.append(st.size()).append("\n");
            }
            else if(input.equals("empty")) {
                if(st.isEmpty()) {
                    sb.append("1\n");
                }
                else {
                    sb.append("0\n");
                }
            }
            else if(input.equals("top")) {
                if(st.isEmpty()) {
                    sb.append("-1\n");
                }
                else {
                    sb.append(st.peek()).append("\n");
                }
            }
            else {
                String[] split = input.split(" ");
                st.push(Integer.parseInt(split[1]));
            }
        }

        System.out.println(sb.toString());

        br.close();
    }
}
