import java.io.*;
import java.util.*;
public class Main {
  public static int MAX_V = 0;
  public static int N, M, Start, End, answer = 0;

  public static HashMap<Integer, HashMap<Integer, Integer>> graph = new HashMap<>();
  public static void addBridge(int from, int to, int weight){
    if(!graph.get(from).containsKey(to)){
      graph.get(from).put(to, weight);
    }
    else if(graph.get(from).get(to) < weight){
      graph.get(from).put(to, weight);
    }
  }
  public static boolean bfs(int limit){
    boolean[] visit = new boolean[10001];
    Queue<Integer> q = new ArrayDeque<>();
    q.add(Start); visit[Start] = true;
    while(!q.isEmpty()){
      int cur = q.poll();
      for(Integer next : graph.get(cur).keySet()){
        int nextCost = graph.get(cur).get(next);
        if(visit[next] == false && nextCost >= limit){
          q.add(next);
          visit[next] = true;
        }
      }
    }
    return visit[End];
  }
  public static void binSearch(){
    int s = 1, e = MAX_V, mid;
    while(s <= e){
      mid = (s + e) / 2;
      if(bfs(mid) == true){
        s = mid + 1;
        answer = Math.max(mid, answer);
      }
      else{
        e = mid - 1;
      }
    }
  }
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
    for(int i = 0; i < M; i++){
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      MAX_V = Math.max(MAX_V, c);
      if(!graph.containsKey(a))
        graph.put(a, new HashMap<>());
      if(!graph.containsKey(b))
        graph.put(b, new HashMap<>());
      addBridge(a, b, c);
      addBridge(b, a, c);
    }
    st = new StringTokenizer(br.readLine());
    Start = Integer.parseInt(st.nextToken()); End = Integer.parseInt(st.nextToken());
    binSearch();
    System.out.println(answer);
  }
}