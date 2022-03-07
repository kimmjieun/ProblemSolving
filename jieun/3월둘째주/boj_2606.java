import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2606 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int t = Integer.parseInt(br.readLine());

        int[][] arr = new int[n + 1][n + 1];
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = arr[y][x] = 1;
        }

        boolean[] visit = new boolean[n + 1];
        visit[1] = true;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (arr[1][i] == 1 || arr[i][1] == 1) {
                q.add(i);
                visit[i] = true;
            }
        }

        int count = 0;
        while (!q.isEmpty()) {
            int tmp = q.poll();
            count += 1;
            for (int i = 1; i <= n; i++) {
                if ((arr[tmp][i] == 1 || arr[i][tmp] == 1) && !visit[i]) {
                    q.add(i);
                    visit[i] = true;
                }
            }
        }
        System.out.println(count);
    }
}
