import java.util.*;

public class pgm_가장먼노드 {

    public int solution(int n, int[][] edge) {
        boolean[][] node = new boolean[n + 1][n + 1];
        int[] dist = new int[n + 1];
        int max = 0;

        for (int i = 0; i < edge.length; i++) {
            int x = edge[i][0];
            int y = edge[i][1];
            node[x][y] = true;
            node[y][x] = true;
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        dist[1] = 0;

        while (!q.isEmpty()) {
            int k = q.poll();

            for (int i = 2; i <= n; i++) {
                if (dist[i] == 0 && node[k][i]) { // dist=0 이 방문 배열을 대신함
                    dist[i] = dist[k] + 1;
                    q.add(i);
                }
            }
        }

        for (int i = 0; i < n + 1; i++) {
            max = Math.max(max, dist[i]);
        }

        int answer = 0;
        for (int i = 0; i < n + 1; i++) {
            if (max == dist[i])
                answer++;
        }

        return answer;
    }

}
