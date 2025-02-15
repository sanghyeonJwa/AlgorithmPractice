

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> in = new HashMap<>();

        for(int i = 0; i < N; i++) {
            in.put(br.readLine(), i);
        }

        List<Integer> outOrder = new ArrayList<>();
        int cnt = 0;

        for(int i = 0; i < N; i++) {
            String carPlate = br.readLine();
            outOrder.add(in.get(carPlate));
        }

        // 나간 순서를 저장한 리스트를 확인하면서 내 뒤에 나보다 작은 수가 있는지 확인해준다.
        for(int i = 0; i < N; i++) {
            for(int j = i + 1; j < N; j++) {
                if(outOrder.get(i) > outOrder.get(j)) {
                    cnt++;
                    break;
                }
            }
        }

        System.out.println(cnt);
    }
}
