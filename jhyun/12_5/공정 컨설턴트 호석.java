import java.io.*;
import java.util.*;
public class Main {
  public static int N, X, answer = Integer.MAX_VALUE;
  public static int[] dur;
  //limit 개의 공정 라인으로 X시간 내에 제작할 수 있는가?
  public static boolean IsPossible(int limit){
    int max = 0;
    //제작 시간이 가장 작은 라인을 가져오기 위함
    Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
      if(o1[0] == o2[0])
        return o1[1] - o2[1];
      return o1[0] - o2[0];
    });

    for(int i = 0; i < limit; i++) {
      int[] arr = {0, 0};
      pq.add(arr);
    }

    for(int i = 0; i < N; i++){
      int[] g = pq.poll();
      g[0] += dur[i];
      max = Math.max(max, g[0]);
      pq.add(g);
    }
    return max <= X;
  }
  public static int BinSearch(){
    int s = 1, e = N, mid;
    while(s <= e){
      mid = (s + e) / 2;
      if(IsPossible(mid)){
        e = mid - 1;
        answer = Math.min(answer, mid);
      }
      else{
        s = mid + 1;
      }
    }
    return answer;
  }
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken()); X = Integer.parseInt(st.nextToken());
    dur = new int[N]; st = new StringTokenizer(br.readLine());
    for(int i = 0; i < N; i++)
      dur[i] = Integer.parseInt(st.nextToken());
    BinSearch();
    System.out.println(answer);
  }
}