import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] switches = new int[N + 1]; // 1-based index

        String[] switchesInput = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            switches[i] = Integer.parseInt(switchesInput[i - 1]);
        }

        int students = Integer.parseInt(br.readLine());

        for (int i = 0; i < students; i++) {
            String[] studentInfo = br.readLine().split(" ");
            int gender = Integer.parseInt(studentInfo[0]);
            int switchNumber = Integer.parseInt(studentInfo[1]);

            if (gender == 1) {
                for (int j = switchNumber; j <= N; j += switchNumber) {
                    switches[j] = switches[j] == 0 ? 1 : 0;
                }
            } else {
                int left = switchNumber, right = switchNumber;
                while (left - 1 > 0 && right + 1 <= N && switches[left - 1] == switches[right + 1]) {
                    left--;
                    right++;
                }
                for (int j = left; j <= right; j++) {
                    switches[j] = switches[j] == 0 ? 1 : 0;
                }
            }
        }

        for(int i = 1; i <= N; i++) {
            System.out.print(switches[i] + " ");
            if(i % 20 == 0) System.out.println();
        }
    }
}
