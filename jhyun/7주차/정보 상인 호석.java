import java.io.*;
import java.util.*;

public class Main {
  static int N= 0;
  static long answer = 0;
  static HashMap<String, PriorityQueue<Integer>> m = new HashMap<>();
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    int q;
    String name;
    for(int i = 0; i < N; i++){
      st = new StringTokenizer(br.readLine());
      q = Integer.parseInt(st.nextToken());
      name = st.nextToken();
      m.putIfAbsent(name, new PriorityQueue<Integer>(Collections.reverseOrder()));
      if(q == 1){
        st.nextToken();
        while(st.hasMoreTokens()){
          int value = Integer.parseInt(st.nextToken());
          m.get(name).add(value);
        }
      }
      else if(q == 2){
        int cnt = Integer.parseInt(st.nextToken());
        if(cnt >= m.get(name).size()){
          while(!m.get(name).isEmpty()){
            answer += m.get(name).poll();
          }
        }
        else{
          for(int j = 0; j < cnt; j++){
            answer += m.get(name).poll();
          }
        }
      }
    }
    System.out.println(answer);
  }
}
