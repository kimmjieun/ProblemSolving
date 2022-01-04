import java.io.*;
import java.util.*;
public class Main {
  public static int N, M, S, answer;
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken()); S = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
    int[] P = new int[N + 1];
    boolean[][] vol = new boolean[M + 1][N + 1];
    st = new StringTokenizer(br.readLine());
    for(int i = 1; i <= N; i++)
      P[i] = Integer.parseInt(st.nextToken());

    vol[S][0] = true;
    for(int i = 1; i <= N; i++){
      for(int v = 0; v <= M; v++){
        if(v + P[i] <= M && vol[v][i - 1] == true)
          vol[v + P[i]][i] = true;
        if(v - P[i] >= 0 && vol[v][i - 1] == true)
          vol[v - P[i]][i] = true;
      }
    }
    for(int v = M; v >= 0; v--){
      if(vol[v][N] == true){
        System.out.println(v);
        return;
      }
    }
    System.out.println("-1");
  }
}