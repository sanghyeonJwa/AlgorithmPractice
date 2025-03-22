import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int channel = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        String[] buttonInput = new String[0];

        if(n > 0)
            buttonInput = br.readLine().split(" ");

        int[] buttons = new int[10];

        // 1이면 고장
        for (String s : buttonInput) {
            buttons[Integer.parseInt(s)]++;
        }

        int result = Math.abs(channel - 100);

        for(int i = 0; i <= 1000000; i++) {

            if(checking1(i, buttons)) {
                int count = String.valueOf(i).length() + Math.abs(i - channel);

                if(count < result)
                    result = count;
            }
        }

        System.out.println(result);
    }

    public static boolean checking1(int n, int[] buttons) {

        // 채널이 0번인 경우
        if(n == 0)
            return buttons[0] == 0;

        while(n > 0) {
            int temp = n % 10;
            if(buttons[temp] == 1)
                return false;
            n /= 10;
        }

        return true;
    }
}
