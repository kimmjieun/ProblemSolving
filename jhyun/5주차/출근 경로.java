import java.io.*;
import java.util.*;

public class Main {
  public static int W, H, mod = 100000;
  public static int[][][][] dp;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    W = Integer.parseInt(st.nextToken()); H = Integer.parseInt(st.nextToken());
    dp = new int[W + 1][H + 1][2][2];
    //초깃값 설정
    for(int i = 1; i <= W; i++) {
      dp[i][1][0][0] = 1;
    }
    for(int i = 1; i <= H; i++) {
      dp[1][i][1][0] = 1;
    }

    for(int i = 2; i <= W; i++){
      for(int j = 2; j <= H; j++){
        dp[i][j][1][0] = (dp[i][j - 1][1][1] + dp[i][j - 1][1][0]) % mod;
        dp[i][j][1][1] = dp[i][j - 1][0][0] % mod;
        dp[i][j][0][0] = (dp[i - 1][j][0][0] + dp[i - 1][j][0][1]) % mod;
        dp[i][j][0][1] = dp[i - 1][j][1][0];
      }
    }
    int answer = (dp[W][H][0][0] + dp[W][H][0][1] + dp[W][H][1][0] + dp[W][H][1][1]) % mod;
    System.out.println(answer);
  }
}
