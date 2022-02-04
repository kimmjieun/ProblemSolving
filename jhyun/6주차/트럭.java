import java.io.*;
import java.util.*;
public class Main {
  static int N, W, L;
  static Queue<Integer> q = new ArrayDeque<>();
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken()); W = Integer.parseInt(st.nextToken()); L = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < N; i++){
      q.add(Integer.parseInt(st.nextToken()));
    }
    int time = 0;
    Queue<Integer> wait = new ArrayDeque<>();
    Deque<Integer> bridge = new ArrayDeque<>();
    wait.add(1);
    bridge.addLast(q.poll());
    while(!q.isEmpty() || !wait.isEmpty()){
      ++time;
      //트럭이 다 빠져나갔을 때
      if(time >= wait.peek() + W){
        wait.poll();
        bridge.pollFirst();
      }
      //무게 제한에 걸리지 않고 트럭이 더 들어갈 수 있다면
      if(!q.isEmpty()){
        if(bridge.stream().reduce(0, Integer::sum) + q.peek() <= L){
          wait.add(time);
          bridge.addLast(q.poll());
        }
      }
    }
    System.out.println(time);
  }
}
