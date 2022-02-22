import java.io.*;
import java.util.*;
//MST인줄 알았으나 다익스트라 문제였음.. 35분
public class Main {
  static int N, M;
  static int[] dist;
  static int[] path;
  static HashMap<Integer, HashMap<Integer, Integer>> graph = new HashMap<>();
  static void dijkstra(int start){
    Arrays.fill(dist, 100000);
    PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
      if(o1[0] == o2[0]){
        return o1[1] - o2[1];
      }
      return o1[0] - o2[0];
    });
    pq.add(new int[]{0, start});
    dist[start] = 0;
    int nextCost = 0;
    while(!pq.isEmpty()){
      int[] tmp = pq.poll();
      int cost = tmp[0];
      int cur = tmp[1];
      if(dist[cur] < cost) continue;
      for(int next : graph.get(cur).keySet()){
        nextCost = dist[cur] + graph.get(cur).get(next);
        if(dist[next] > nextCost){
          dist[next] = nextCost;
          pq.add(new int[]{nextCost, next});
          path[next] = cur;
        }
      }
    }
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
    dist = new int[N + 1]; path = new int[N + 1];
    for(int i = 1; i <= N; i++)
      graph.put(i, new HashMap<>());
    for(int i = 0; i < M; i++){
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      int d = Integer.parseInt(st.nextToken());
      if(graph.get(s).getOrDefault(e, Integer.MAX_VALUE) > d){
        graph.get(s).put(e, d);
      }
      if(graph.get(e).getOrDefault(s, Integer.MAX_VALUE) > d){
        graph.get(e).put(s, d);
      }
    }
    dijkstra(1);
    System.out.println(N - 1);
    StringBuilder sb = new StringBuilder();
    for(int i = 2; i <= N; i++)
      sb.append(i).append(" ").append(path[i]).append("\n");
    System.out.print(sb);
  }
}