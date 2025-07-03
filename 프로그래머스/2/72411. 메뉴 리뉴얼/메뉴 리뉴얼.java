import java.util.*;

class Solution {
    Map<String, Integer> menuMap = new HashMap<>();
    int maxCount = 0;

    public String[] solution(String[] orders, int[] course) {
        
        /*
        모든 부분 문자열을 map에 넣어보기. -> 카운트 하기
        */
        List<String> result = new ArrayList<>();

        for (int len : course) {
            menuMap.clear();
            maxCount = 0;

            for (String order : orders) {
                char[] chars = order.toCharArray();
                Arrays.sort(chars);
                combination(chars, new StringBuilder(), 0, len);
            }

            for (Map.Entry<String, Integer> entry : menuMap.entrySet()) {
                if (entry.getValue() == maxCount && maxCount >= 2) {
                    result.add(entry.getKey());
                }
            }
        }

        Collections.sort(result);
        return result.toArray(new String[0]);
    }

    // 조합 생성 함수
    private void combination(char[] chars, StringBuilder sb, int idx, int targetLen) {
        if (sb.length() == targetLen) {
            String key = sb.toString();
            menuMap.put(key, menuMap.getOrDefault(key, 0) + 1);
            maxCount = Math.max(maxCount, menuMap.get(key));
            return;
        }

        for (int i = idx; i < chars.length; i++) {
            sb.append(chars[i]);
            combination(chars, sb, i + 1, targetLen);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}