import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // baekjoon 1931 : 회의실 배정

        // N : 회의의 수

        // output : 곂치치 않으면서 사용할 수 있는 회의 최대값

        int N = Integer.parseInt(br.readLine());

        int[][] conference = new int[N][2];

        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            conference[i][0] = Integer.parseInt(input[0]);
            conference[i][1] = Integer.parseInt(input[1]);
        }

        /*
        1. 회의가 끝나야만 다음 회의를 결정할 수 있기 때문에 끝나는 시간을 기준으로 일단 비교를 해야 한다.
        -> 끝나는 시간으로 정렬
        -> 끝나는 시간이 같다면? : 상관없음. 어차피 종료 시간으로 정렬하면 같은 종료 시간의 회의중 1개밖에 못고른다.
         */

        Arrays.sort(conference, (a, b) -> {
            if(a[1] == b[1]) {
                return a[0] - b[0]; // 도대체 왜?
            }
            return a[1] - b[1];
        });

        // 회의 수
        int cnt = 0;
        // 종료 시간
        int closeTime = 0;

        for(int i = 0; i < N; i++) {
            if(conference[i][0] >= closeTime) {
                closeTime = conference[i][1];
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
