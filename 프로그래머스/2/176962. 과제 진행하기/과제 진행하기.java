import java.util.*;

class Solution {

    static class Homework {
        String name;
        int start;
        int remain;

        Homework(String name, int start, int remain) {
            this.name = name;
            this.start = start;
            this.remain = remain;
        }
    }

    public String[] solution(String[][] plans) {

        List<String> answer = new ArrayList<>();
        Stack<Homework> st = new Stack<>();

        // 1. 시작 시간 기준 정렬
        Arrays.sort(plans, (a, b) ->
            toMin(a[1]) - toMin(b[1])
        );

        for (int i = 0; i < plans.length; i++) {

            String name = plans[i][0];
            int start = toMin(plans[i][1]);
            int playtime = Integer.parseInt(plans[i][2]);

            // 마지막 과제면 그냥 st에 넣고 종료
            if (i == plans.length - 1) {
                st.push(new Homework(name, start, playtime));
                break;
            }

            int nextStart = toMin(plans[i + 1][1]);
            int gap = nextStart - start;

            if (gap >= playtime) {
                // 다 끝낼 수 있음
                answer.add(name);

                int remainTime = gap - playtime;

                // 남는 시간 동안 스택 처리
                while (!st.isEmpty() && remainTime > 0) {
                    Homework prev = st.pop();

                    if (remainTime >= prev.remain) {
                        remainTime -= prev.remain;
                        answer.add(prev.name);
                    } else {
                        prev.remain -= remainTime;
                        st.push(prev);
                        break;
                    }
                }

            } else {
                // 못 끝내면 st에 남은 시간 저장
                st.push(new Homework(name, start, playtime - gap));
            }
        }

        // st에 남은 것 전부 처리
        while (!st.isEmpty()) {
            answer.add(st.pop().name);
        }

        return answer.toArray(new String[0]);
    }

    private int toMin(String time) {
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }
}