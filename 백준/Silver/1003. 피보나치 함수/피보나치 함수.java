import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    
    // 0의 호출 횟수를 저장할 배열
    static int[] zeroCount = new int[41];
    // 1의 호출 횟수를 저장할 배열
    static int[] oneCount = new int[41];

    public static void main(String[] args) throws IOException {
        initCounts();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(zeroCount[n]).append(" ").append(oneCount[n]).append("\n");
        }
        System.out.print(sb);
    }

    private static void initCounts() {
        
        zeroCount[0] = 1;
        oneCount[0] = 0;

        zeroCount[1] = 0;
        oneCount[1] = 1;

        for (int i = 2; i <= 40; i++) {
            zeroCount[i] = zeroCount[i - 1] + zeroCount[i - 2];
            oneCount[i] = oneCount[i - 1] + oneCount[i - 2];
        }
    }
}
