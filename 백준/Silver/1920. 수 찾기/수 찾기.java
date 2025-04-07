import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();

        int M = Integer.parseInt(br.readLine());
        String[] input2 = br.readLine().split(" ");
        int[] checkingArr = Arrays.stream(input2).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(arr);

//        for(int number : checkingArr) {
//            int left = 0, right = N - 1;
//            boolean find = false;
//
//            while (left <= right) {
//                int mid = (left + right) / 2;
//                if (arr[mid] == number) {
//                    find = true;
//                    break;
//                }
//                else if(arr[mid] > number) {
//                    right = mid - 1;
//                }
//                else {
//                    left = mid + 1;
//                }
//            }
//
//            if(find) {
//                System.out.println(1);
//            }
//            else {
//                System.out.println(0);
//            }
//        }

        for(int number : checkingArr) {
            if(Arrays.binarySearch(arr, number) >= 0) { // 찾은 것의 인덱스를 반환, 못찾았으면 음수 반환
                System.out.println(1);
            }   
            else {
                System.out.println(0);
            }
        }
    }
}
