import java.io.*;
import java.util.*;
public class Main {
  public static int T, N;
  public static int[] card;
  public static int[][] dp;
  public static int Game(int l, int r, int t){
    if(l > r) return 0;
    if(dp[l][r] != 0) return dp[l][r];

    if(t % 2 != 0)
      return dp[l][r] = Math.max(card[l] + Game(l + 1, r, t + 1), card[r] + Game(l, r - 1, t + 1));
    else
      return dp[l][r] = Math.min(Game(l + 1, r, t + 1), Game(l, r - 1, t + 1));
  }
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    T = Integer.parseInt(st.nextToken());
    while(T-- != 0){
      st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      card = new int[N]; dp = new int[N][N];
      st = new StringTokenizer(br.readLine());
      for(int i = 0; i < N; i++)
        card[i] = Integer.parseInt(st.nextToken());
      System.out.println(Game(0, N - 1, 1));
    }
  }
}