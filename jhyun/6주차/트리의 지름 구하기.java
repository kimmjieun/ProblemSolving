import java.io.*;
import java.util.*;
/*
try 1: HashMap, ArrayList로 인접 리스트를 나타내어 각 정점마다 bfs를 수행 -> 메모리 초과
try 2: 트리의 지름 구하는 방법, 루트에서 가장 먼 정점을 고르고, 해당 정점에서 다시 가장 먼 정점을 고르면 지름이 된다.
*/
public class Main {
  public static int N, farIdx = 0;
  static ArrayList<int[]> graph[] = new ArrayList[10001];
  public static int bfs(int start){
    int[] dist = new int[N + 1];
    int maxDist = 0;
    Queue<Integer> q = new ArrayDeque<>();
    q.add(start);
    dist[start] = 0;
    while(!q.isEmpty()){
      int cur = q.poll();
      for(int[] edge : graph[cur]){
        int next = edge[0], cost = edge[1];
        if(dist[next] == 0 && next != start){
          dist[next] = dist[cur] + cost;
          maxDist = Math.max(maxDist, dist[next]);
          q.add(next);
        }
      }
    }
    int farDist = 0;
    for(int i = 1; i <= N; i++){
      if(farDist < dist[i]){
        farDist = dist[i];
        farIdx = i;
      }
    }
    return maxDist;
  }
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    short from, to, dist;
    for(int i = 0; i < N + 1; i++)
      graph[i] = new ArrayList<>();
    for(int i = 0; i < N - 1; i++){
      st = new StringTokenizer(br.readLine());
      from = Short.parseShort(st.nextToken());
      to = Short.parseShort(st.nextToken());
      dist = Short.parseShort(st.nextToken());
      graph[from].add(new int[]{to, dist});
      graph[to].add(new int[]{from, dist});
    }
    if(N == 1){
      System.out.println(0);
      return;
    }
    bfs(1);
    int answer = bfs(farIdx);
    System.out.println(answer);
  }
}
