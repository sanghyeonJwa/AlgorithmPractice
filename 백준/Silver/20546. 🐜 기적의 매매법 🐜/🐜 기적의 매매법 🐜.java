import java.util.*;
import java.io.*;

public class Main {

    static int budget;
    static int[] stockPrice = new int[14];
    static int jBudget, sBudget;
    static int jStockAmount = 0, sStockAmount = 0;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /*
        준현 - 사고 절대 안팔기
        성민 - 3일 하락 -> 다음날 무조건 상승 -> 주식 무조건 전량 매수
            - 3일 상승 -> 다음날 무조건 하락 -> 주식 무조건 전량 매도
        */

        budget = Integer.parseInt(br.readLine());
        jBudget = budget;
        sBudget = budget;

        stockPrice = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for(int i = 0; i < stockPrice.length; i++) { BNP(stockPrice[i]); }

        for(int i = 3; i < stockPrice.length; i++) { TIMING(i); }

        int jTotal = jBudget + jStockAmount * stockPrice[13];
        int sTotal = sBudget + sStockAmount * stockPrice[13];

        if(jTotal < sTotal)
            System.out.println("TIMING");
        else if(jTotal == sTotal)
            System.out.println("SAMESAME");
        else
            System.out.println("BNP");
    }

    // BNF 방법 적용해서 jStockAmount 와 jBudget 계산하기
    public static void BNP(int currentStockPrice) {

        int amount = jBudget / currentStockPrice;

        // 살수 있다면
        if(amount != 0) {
            jStockAmount += amount;
            jBudget -= amount * currentStockPrice;
        }
    }

    // TIMING 방법 적용해서 sStockAmount 와 sBudget 계산하기
    public static void TIMING(int day) {

        // 3일 연속 하락
        if(stockPrice[day - 3] > stockPrice[day - 2] && stockPrice[day - 2] > stockPrice[day - 1]) {
            int amount = sBudget / stockPrice[day];
            sStockAmount += amount;
            sBudget -= amount * stockPrice[day];
        }
        // 3일 연속 상승
        else if (stockPrice[day - 3] < stockPrice[day - 2] && stockPrice[day - 2] < stockPrice[day - 1]) {
            sBudget += sStockAmount * stockPrice[day];
            sStockAmount = 0;
        }
    }
}

