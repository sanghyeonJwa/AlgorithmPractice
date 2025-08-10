class Solution {
    static int[] sales = {10, 20, 30, 40};
    static int maxPlus, maxSales;

    public int[] solution(int[][] users, int[] emoticons) {
        maxPlus = 0;
        maxSales = 0;

        int[] discounts = new int[emoticons.length];
        dfs(0, discounts, users, emoticons);

        return new int[]{maxPlus, maxSales};
    }

    private void dfs(int idx, int[] discounts, int[][] users, int[] emoticons) {
        if (idx == emoticons.length) {
            int plus = 0, totalSales = 0;

            for (int[] user : users) {
                int minDiscount = user[0];
                int threshold = user[1];
                int sum = 0;

                for (int i = 0; i < emoticons.length; i++) {
                    if (discounts[i] >= minDiscount) {
                        sum += emoticons[i] * (100 - discounts[i]) / 100;
                    }
                }

                if (sum >= threshold) {
                    plus++;
                } else {
                    totalSales += sum;
                }
            }

            if (plus > maxPlus || (plus == maxPlus && totalSales > maxSales)) {
                maxPlus = plus;
                maxSales = totalSales;
            }
            return;
        }

        for (int s : sales) {
            discounts[idx] = s;
            dfs(idx + 1, discounts, users, emoticons);
        }
    }
}