import java.util.*;
import java.io.*;

public class Main {

    static int n, m, k;
    static int[] positions;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());   // 트랙 길이
        m = Integer.parseInt(st.nextToken());   // 심판 인원 수
        k = Integer.parseInt(st.nextToken());   // 심판 위치

        positions = new int[k];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < k; i++) {
            positions[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(positions);

        int left = 1;
        int right = positions[k - 1] - positions[0];
        int[] answer = new int[k];
        int[] temp;

        while(left <= right) {
            temp = new int[k];
            int mid = (left + right) / 2;
            int cnt = 1;
            temp[0] = 1;
            int last = positions[0];

            for(int i = 1; i < k; i++) {
                
                if(cnt == m) break;
                
                if(positions[i] - last >= mid) {
                    temp[i] = 1;
                    cnt++;
                    last = positions[i];
                }
            }

            if(cnt >= m) {
                answer = temp.clone();
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < k; i++) {
            sb.append(answer[i]);
        }

        System.out.println(sb.toString());
    }
}
