import java.util.*;
import java.io.*;
class Solution {
  static HashMap<String, Integer> visit = new HashMap<>();
  static Queue<String> q = new ArrayDeque<>();
  static final int NO_VISIT = 100;
  static boolean canVisit(String cur, String next){
    if(cur.equals(next)) return false;
    int cnt = 0;
    for(int i = 0; i < cur.length(); i++){
      if(cur.charAt(i) == next.charAt(i)){
        cnt++;
      }
    }
    return cnt >= cur.length() - 1;
  }
  public int solution(String begin, String target, String[] words) {
    int answer = 0;
    boolean canConvert = false;
    for(int i = 0; i < words.length; i++){
      visit.put(words[i], NO_VISIT);
      if(words[i].equals(target)) canConvert = true;
    }
    if(!canConvert) return 0;
    visit.put(target, NO_VISIT);
    visit.put(begin, 0);
    q.add(begin);
    while(!q.isEmpty()){
      String cur = q.poll();
      for(String next : visit.keySet()){
        if(canVisit(cur, next)){
          if(visit.get(next) == NO_VISIT || visit.get(next) > visit.get(cur) + 1){
            visit.put(next, visit.get(cur) + 1);
            q.add(next);
          }
        }
      }
    }
    return visit.get(target) >= NO_VISIT ? 0 : visit.get(target);
  }
}