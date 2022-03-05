import java.util.*;
class Solution {
  static Deque<String> dq = new ArrayDeque<>();
  static String[][] T;
  static String[] answer;
  static boolean[] visit;
  static boolean done = false;
  static void dfs(String start, int len){
    if(len == visit.length){
      done = true;
      answer = new String[len + 1];
      for(int i = 0; i <answer.length; i++)
        answer[i] = dq.pollFirst();
      return;
    }
    for(int i = 0; i < visit.length; i++){
      if(visit[i] == false && T[i][0].equals(start) && !done){
        dq.addLast(T[i][1]);
        visit[i] = true;
        dfs(T[i][1], len + 1);
        visit[i] = false;
        dq.pollLast();
      }
    }
  }
  public static String[] solution(String[][] tickets) {
    T = tickets;
    Arrays.sort(tickets, (o1, o2) -> {
      if(o1[0].equals(o2[0]))
        return o1[1].compareTo(o2[1]);
      return o1[0].compareTo(o2[0]);
    });
    visit = new boolean[tickets.length];
    for(int i = 0; i < tickets.length; i++){
      if(tickets[i][0].equals("ICN") && !done){
        dq.addLast(tickets[i][0]); dq.addLast(tickets[i][1]);
        visit[i] = true;
        dfs(tickets[i][1], 1);
        visit[i] = false;
        dq.pollLast(); dq.pollLast();
      }
    }
    return answer;
  }
}