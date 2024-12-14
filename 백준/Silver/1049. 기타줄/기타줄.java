import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 필요한 줄 수 N과 브랜드 수 M 입력
        int N = sc.nextInt();
        int M = sc.nextInt();

        // 초기값 설정
        int minSetPrice = Integer.MAX_VALUE;
        int minSinglePrice = Integer.MAX_VALUE;

        // 각 브랜드의 세트 가격과 낱개 가격 입력
        for (int i = 0; i < M; i++) {
            int setPrice = sc.nextInt();
            int singlePrice = sc.nextInt();

            // 가장 저렴한 세트 가격과 낱개 가격 갱신
            minSetPrice = Math.min(minSetPrice, setPrice);
            minSinglePrice = Math.min(minSinglePrice, singlePrice);
        }

        // 세 가지 구매 방식의 비용 계산
        int costUsingOnlySets = ((N / 6) + 1) * minSetPrice; // 세트만 구매
        int costUsingSetsAndSingles = (N / 6) * minSetPrice + (N % 6) * minSinglePrice; // 세트 + 낱개
        int costUsingOnlySingles = N * minSinglePrice; // 낱개만 구매

        // 최소 비용 계산
        int result = Math.min(costUsingOnlySets, Math.min(costUsingSetsAndSingles, costUsingOnlySingles));

        // 결과 출력
        System.out.println(result);
    }
}
