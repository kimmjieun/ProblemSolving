import java.util.*;

public class pgm_네트워크 {

    public boolean[] visited;

    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, n, computers);
                answer++;
            }
        }

        return answer;
    }

    public void dfs(int x, int n, int[][] computers) {
        visited[x] = true;
        for (int i = 0; i < n; i++) {
            if (computers[x][i] == 1 && !visited[i]) {
                dfs(i, n, computers);
            }
        }

    }

}
