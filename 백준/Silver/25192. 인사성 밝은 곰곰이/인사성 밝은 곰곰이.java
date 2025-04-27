import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Set<String> talk = new HashSet<>();
        int imageCnt = 0;

        String start = br.readLine();

        for(int i = 1; i < N; i++) {

            String input = br.readLine();

            if(input.equals("ENTER")) {
                imageCnt += talk.size();
                talk.clear();
            }
            else {
                talk.add(input);
            }
        }

        imageCnt += talk.size();

        System.out.println(imageCnt);
    }
}
