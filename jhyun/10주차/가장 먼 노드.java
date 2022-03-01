import java.util.*;
class Solution {
  static HashMap<Integer, List<Integer>> graph = new HashMap<>();
  static int visit[];
  static int bfs(int start){
    Queue<Integer> q = new ArrayDeque<>();
    q.add(start);
    visit[start] = 1;
    int maxValue = 0, cnt = 0;
    while(!q.isEmpty()){
      int cur = q.poll();
      for(int next : graph.get(cur)){
        if(visit[next] == 0){
          visit[next] = visit[cur] + 1;
          q.add(next);
          maxValue = Math.max(visit[next], maxValue);
        }
      }
    }
    for(int i = 1; i < visit.length; i++){
      if(visit[i] == maxValue){
        cnt++;
      }
    }
    return cnt;
  }
  public static int solution(int n, int[][] edge) {
    int answer = 0;
    visit = new int[n + 1];
    for(int i = 0; i < edge.length; i++) {
      graph.putIfAbsent(edge[i][0], new ArrayList<>());
      graph.putIfAbsent(edge[i][1], new ArrayList<>());
      graph.get(edge[i][0]).add(edge[i][1]);
      graph.get(edge[i][1]).add(edge[i][0]);
    }
    answer = bfs(1);
    return answer;
  }
}