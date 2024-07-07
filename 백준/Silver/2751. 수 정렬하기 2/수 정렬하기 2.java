import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        List<Integer> numbers = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            numbers.add(Integer.parseInt(input));
        }

        Collections.sort(numbers);

        for (Integer num : numbers) {
            bw.write(num.toString());
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
