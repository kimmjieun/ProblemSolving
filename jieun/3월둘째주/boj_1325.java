import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1325 {
    static int max = Integer.MIN_VALUE;
    static int[] result;
    static int n, m;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
        }

        result = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            bfs(i);
        }

        for (int i = 1; i < n + 1; i++) {
            max = Math.max(result[i], max);
        }

        for (int i = 1; i <= n; i++) {
            if (max == result[i])
                sb.append(i + " ");
        }
        System.out.println(sb);

    }

    static void bfs(int x) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visit = new boolean[n + 1];
        q.add(x);
        visit[x] = true;
        while (!q.isEmpty()) {
            int v = q.poll();
            for (int next : graph.get(v)) {
                if (!visit[next]) {
                    visit[next] = true;
                    q.add(next);
                    result[next]++;//*
                }
            }
        }
    }


}
