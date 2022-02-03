import java.io.*;
import java.util.*;

public class Main {
  public static int N, M, Start, End, MAX_V = 1000 * 100000 + 1;
  public static HashMap<Integer, HashMap<Integer, Integer>> graph = new HashMap<>();
  public static int dijkstra(){
    int[] dist = new int[N + 1];
    for(int i = 0; i < dist.length; i++)
      dist[i] = MAX_V;
    Queue<int[]> pq = new PriorityQueue<>((a1, a2) -> {
      if(a1[0] == a2[0])
        return a1[1] - a2[1];
      return a1[0] - a2[0];
    });
    pq.add(new int[]{0, Start});
    dist[Start] = 0;
    while(!pq.isEmpty()){
      int[] temp = pq.poll();
      int cost = temp[0];
      int cur = temp[1];
      if(dist[cur] < cost)
        continue;

      for(Integer next : graph.get(cur).keySet()){
        int nextCost = dist[cur] + graph.get(cur).get(next);
        if(dist[next] > nextCost){
          dist[next] = nextCost;
          pq.add(new int[]{nextCost, next});
        }
      }
    }
    return dist[End];
  }
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    M = Integer.parseInt(st.nextToken());
    int from, to, dist;
    for(int i = 1; i <= N; i++)
      graph.put(i, new HashMap<>());
    for(int i = 0; i < M; i++){
      st = new StringTokenizer(br.readLine());
      from = Integer.parseInt(st.nextToken());
      to = Integer.parseInt(st.nextToken());
      dist = Integer.parseInt(st.nextToken());
      if(graph.get(from).containsKey(to)){
        if(graph.get(from).get(to) > dist){
          graph.get(from).put(to, dist);
        }
      }
      else{
        graph.get(from).put(to, dist);
      }
    }
    st = new StringTokenizer(br.readLine());
    Start = Integer.parseInt(st.nextToken());
    End = Integer.parseInt(st.nextToken());
    int answer = dijkstra();
    System.out.println(answer);
  }
}
