import java.io.*;
import java.util.*;
public class Main {
  static int N, M;
  static List<Integer>[] graph;
  static int[] indegree;
  static void topologySort(){
    Queue<Integer> q = new ArrayDeque<>();
    for(int i = 1; i <= N; i++){
      if(indegree[i] == 0){
        q.add(i);
      }
    }
    while(!q.isEmpty()){
      int cur = q.poll();
      System.out.printf("%d ", cur);
      for(int next : graph[cur]){
        if(--indegree[next] == 0){
          q.add(next);
        }
      }
    }
  }
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    graph = new List[N + 1];
    indegree = new int[N + 1];
    for(int i = 0; i < N + 1; i++)
      graph[i] = new ArrayList<>();
    for(int i = 0; i < M; i++){
      st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      graph[from].add(to);
      indegree[to]++;
    }
    topologySort();
  }
}
