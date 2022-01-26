class Solution {
    public int[] solution(int n, int[] info) {
    static int[] result;
    static int[] lions = new int[11];
    static int Max = -1;
    static int[] point = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

    public int[] solution(int n, int[] info) {
        Max = -1;
        lions = new int[11];
        dfs(0, n, info);
        System.out.println(Arrays.toString(lions));

        int apeach = 0;
        for (int i = 0; i < 11; i++) {
            if (info[i] >= lions[i]) {
                apeach += point[i];
            }
        }
        if (Max <= apeach) return new int[]{-1};
        else return lions;
    }

    private static void dfs(int pos, int total, int[] info) {
        if (pos == 11) {
            lions[10] += total;
            System.out.println(Arrays.toString(lions));

            int diff = calc(info);
            if (Max <= diff) {
                Max = diff;
                result = lions.clone();
            }
            return;
        }

        for (int i = pos; i <= 10; i++) {
            lions[i]++;
            dfs(pos + 1, total - 1, info);
            lions[i]--;
            dfs(pos + 1, total, info);
        }
    }

    private static int calc(int[] apeach) {
        int apeachPoint = 0;
        int lionPoint = 0;
        for (int i = 0; i < 11; i++) {
            if (apeach[i] == 0 && lions[i] == 0) {
                continue;
            }
            if (apeach[i] >= lions[i]) {
                apeachPoint += point[i];
            } else
                lionPoint += point[i];
        }
        return lionPoint - apeachPoint;
    }
}
