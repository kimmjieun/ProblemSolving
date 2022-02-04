import java.io.*;
import java.util.*;

public class Main {
  static int N;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    PriorityQueue<Integer> minq = new PriorityQueue<>();
    PriorityQueue<Integer> maxq = new PriorityQueue<>(Comparator.reverseOrder());
    for(int i = 0; i < N; i++){
      int num = Integer.parseInt(br.readLine());

      if(maxq.size() == minq.size()){
        maxq.add(num);
        if(!minq.isEmpty() && maxq.peek() > minq.peek()){
          minq.add(maxq.poll());
          maxq.add(minq.poll());
        }
      }
      else{
        minq.add(num);
        if(maxq.peek() > minq.peek()){
          minq.add(maxq.poll());
          maxq.add(minq.poll());
        }
      }
      sb.append(maxq.peek()).append("\n");
    }
    System.out.println(sb);
  }
}
