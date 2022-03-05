import java.util.*;
import java.io.*;
class Solution {
  static void bfs(int start, boolean[] visit, int[][] computers){
    Queue<Integer> q = new ArrayDeque<>();
    visit[start] = true;
    q.add(start);
    while(!q.isEmpty()){
      int cur = q.poll();
      for(int i = 0; i < computers[cur].length; i++){
        if(cur == i) continue;
        boolean isConnect = computers[cur][i] > 0;
        if(visit[i] == false && isConnect){
          visit[i] = true;
          q.add(i);
        }
      }
    }
  }
  public int solution(int n, int[][] computers) {
    int answer = 0;
    boolean[] visit = new boolean[computers.length];
    for(int i = 0; i < n; i++){
      if(visit[i] == false){
        bfs(i, visit, computers);
        answer++;
      }
    }
    return answer;
  }
}