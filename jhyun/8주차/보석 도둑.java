import java.io.*;
import java.util.*;

/*
그리디
m[i]보다 같거나 작은 보석 중 가장 가치가 큰 것을 선택
가장 큰 것을 선택하기 위해 우선순위 큐에 넣고 꺼냄
* */
public class Main {

  static int N, K, M, V, C;
  static long answer = 0;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    int idx = 0;
    List<int[]> jual = new ArrayList<>();
    List<Integer> bp = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      M = Integer.parseInt(st.nextToken());
      V = Integer.parseInt(st.nextToken());
      jual.add(new int[]{M, V});
    }
    for (int i = 0; i < K; i++) {
      st = new StringTokenizer(br.readLine());
      C = Integer.parseInt(st.nextToken());
      bp.add(C);
    }
    jual.sort((o1, o2) -> {
      if (o1[0] == o2[0]) {
        return -Integer.compare(o1[1], o2[1]);
      }
      return Integer.compare(o1[0], o2[0]);
    });
    bp.sort(Comparator.comparingInt(o -> o));
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    for (int i = 0; i < K; i++) {
      while (idx < N && jual.get(idx)[0] <= bp.get(i)) {
        pq.add(jual.get(idx)[1]);
        idx++;
      }
      if (!pq.isEmpty()) {
        answer += pq.poll();
      }
    }
    System.out.println(answer);
  }
}
