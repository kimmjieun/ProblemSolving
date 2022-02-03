package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_5569_출근경로 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int mod = 100000;
		
		// xi, yi, (북=0,동=1), (방향전환불가=0 방향전환가능=1) 
		int[][][][] dp = new int[H + 1][W + 1][2][2];

		// 행 초기화
		for (int i = 2; i <= H; i++) {
			dp[i][1][0][1] = 1;
		}

		// 열 초기화
		for (int i = 2; i <= W; i++) {
			dp[1][i][1][1] = 1;
		}


		for (int i = 2; i <= H; i++) {
			for (int j = 2; j <= W; j++) {
				
				// 북, 방향전환불가 = 1블록 전 방향전환가능 했을 때 값 가져오기
				//               이전 행 ,같은 열, 동, 방향전환가능
				dp[i][j][0][0] = dp[i - 1][j][1][1]% mod;
				// 동, 방향전환불가 = 1블록 전 방향전환가능 했을 때 값 가져오기
				//               같은 행 ,이전 열, 북, 방향전환가능
				dp[i][j][1][0] = dp[i][j - 1][0][1]% mod;
				
				// 북, 방향전환가능 = ( 북,방향전환불가 + 북,방향전환가능)
				dp[i][j][0][1] = (dp[i - 1][j][0][0] + dp[i - 1][j][0][1]) % mod;
				// 동 방향전환가능= ( 동,방향전환불가 + 동,방향전환가능)
				dp[i][j][1][1] = (dp[i][j - 1][1][0] + dp[i][j - 1][1][1]) % mod ;
			}
		}
		
		int answer = 0;
		for(int i=0;i<2;i++) {
			for(int j=0;j<2;j++) {
				answer+=dp[H][W][i][j];
			}
		}
		System.out.println(answer%mod);

	}
}
