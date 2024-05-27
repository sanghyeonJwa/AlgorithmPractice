package bronze;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem1155 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = "Hello, World!";
        String maxCount = getMaxCharCountIgnoreCase(str);
        System.out.println(maxCount);
    }

    public static String getMaxCharCountIgnoreCase(String str) {
        // 문자 출현 빈도를 저장하기 위한 Map
        Map<Character, Integer> charCountMap = new HashMap<>();

        // 문자열을 소문자로 변환하여 대소문자 구별 없이 처리
        str = str.toLowerCase();

        // 문자열을 순회하면서 각 문자의 출현 빈도를 증가시킴
        for (char c : str.toCharArray()) {
            if (Character.isLetter(c)) { // 알파벳인 경우에만 처리
                charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
            }
        }

        // 가장 많이 나온 문자의 개수를 찾아 반환
        String maxCount = "0";
        for (int count : charCountMap.values()) {
            if (count > Integer.parseInt(maxCount)) {
                maxCount = "" + count;
            }
        }
        for (int count : charCountMap.values()) {
            if (count == Integer.parseInt(maxCount)) {
                maxCount = "?";
                break;
            }
        }
        return maxCount;
    }
}