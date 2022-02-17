import java.io.*;
import java.util.*;
public class Main {
  static int N, K;
  static int[] coin;
  static int[] dp;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    coin = new int[N];
    dp = new int[K + 1];
    for(int i = 0; i < N; i++){
      st = new StringTokenizer(br.readLine());
      coin[i] = Integer.parseInt(st.nextToken());
    }
    dp[0] = 1;
    for(int i = 0; i < N; i++){
      for(int j = 1; j <= K; j++){
        if(j - coin[i] >= 0){
          dp[j] += dp[j - coin[i]];
        }
      }
    }
    System.out.println(dp[K]);
  }
}
