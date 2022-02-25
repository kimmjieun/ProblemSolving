import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_2211 {
    static int n;
    static int m;
    static List<Node>[] input;
    static PriorityQueue<Node> pq;
    static int[] min; // 최소 경로 저장
    static int INF = Integer.MAX_VALUE;
    static int[] path;

    static class Node implements Comparable<Node> {
        int node;
        int time;

        public Node(int node, int time) {
            this.node = node;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return this.time - o.time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        min = new int[n + 1];
        Arrays.fill(min, INF);

        path = new int[n + 1];
        input = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            input[i] = new ArrayList<Node>();
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            input[a].add(new Node(b, c));
            input[b].add(new Node(a, c));
        }

        pq = new PriorityQueue<Node>();
        pq.add(new Node(1, 0));
        min[1] = 0;
        path[1] = -1;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.time > min[cur.node]) {
                continue;
            }

            for (Node next : input[cur.node]) {
                if (min[next.node] > cur.time + next.time) {
                    path[next.node] = cur.node;
                    min[next.node] = cur.time + next.time;
                    pq.add(new Node(next.node, min[next.node]));
                }
            }
        }

        System.out.println(n - 1);

        for (int i = 2; i <= n; i++) {
            System.out.println(i + " " + path[i]);
        }
    }
}
