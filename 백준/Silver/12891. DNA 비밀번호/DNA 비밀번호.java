import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 입력 받기
        int S = Integer.parseInt(st.nextToken()); // DNA 문자열 길이
        int P = Integer.parseInt(st.nextToken()); // 부분 문자열 길이
        String dna = br.readLine(); // DNA 문자열
        st = new StringTokenizer(br.readLine());
        
        int[] required = new int[4]; // A, C, G, T 최소 요구 개수
        for (int i = 0; i < 4; i++) {
            required[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] current = new int[4]; // 현재 슬라이딩 윈도우에서 A, C, G, T 개수
        int count = 0; // 조건을 만족하는 부분 문자열 개수
        
        // 초기 윈도우 처리
        for (int i = 0; i < P; i++) {
            addChar(current, dna.charAt(i));
        }
        
        if (check(current, required)) {
            count++;
        }
        
        // 슬라이딩 윈도우 처리
        for (int i = P; i < S; i++) {
            // 윈도우에서 한 문자 추가, 한 문자 제거
            addChar(current, dna.charAt(i));
            removeChar(current, dna.charAt(i - P));
            
            // 조건 만족 여부 확인
            if (check(current, required)) {
                count++;
            }
        }
        
        System.out.println(count);
    }
    
    // 현재 문자 개수에 추가
    private static void addChar(int[] current, char c) {
        switch (c) {
            case 'A': current[0]++; break;
            case 'C': current[1]++; break;
            case 'G': current[2]++; break;
            case 'T': current[3]++; break;
        }
    }
    
    // 현재 문자 개수에서 제거
    private static void removeChar(int[] current, char c) {
        switch (c) {
            case 'A': current[0]--; break;
            case 'C': current[1]--; break;
            case 'G': current[2]--; break;
            case 'T': current[3]--; break;
        }
    }
    
    // 조건 만족 여부 확인
    private static boolean check(int[] current, int[] required) {
        for (int i = 0; i < 4; i++) {
            if (current[i] < required[i]) {
                return false;
            }
        }
        return true;
    }
}
