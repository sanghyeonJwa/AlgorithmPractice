import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스의 개수
        int[] dp = new int[11]; // dp 배열은 0부터 10까지 사용됨 (1 ≤ n ≤ 10)

        // 초기값 설정
        dp[1] = 1; // 1을 만드는 방법은 1가지 (1)
        dp[2] = 2; // 2를 만드는 방법은 2가지 (1+1, 2)
        dp[3] = 4; // 3을 만드는 방법은 4가지 (1+1+1, 1+2, 2+1, 3)

        // dp 배열 채우기 (4부터 10까지)
        for (int i = 4; i <= 10; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        // 각 테스트 케이스 처리
        for (int t = 0; t < T; t++) {
            int n = sc.nextInt();
            System.out.println(dp[n]);
        }
    }
}
