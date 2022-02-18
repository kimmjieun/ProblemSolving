package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_11062 {

	static int T,N,kTurn;
	static int[] card;
	static int[][] DP;
	static StringBuilder output = new StringBuilder();
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int tc=0;tc<T;tc++) {
			N = Integer.parseInt(br.readLine());
			card = new int[N];
			
			// 근우의 차례 
			// 카드개수가 홀수라면 근우는 (1) , 짝수라면 근우는 (0) 이다
			kTurn = N%2;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				card[i] = Integer.parseInt(st.nextToken());
			}
			
			// 근우의 점수를 저장할 용도로 사용할 DP 이다
			// 카드가 한장 남았을 경우까지 생각해 [N,N]이다
			// ex) 카드가 4장일 경우 범위는 [0,0] ~ [3,3] 
			DP = new int[N][N];

			// start부터 end까지의 카드 집합중에 선택
			output.append(cardGame(0,N-1)+"\n");
		}
		System.out.println(output);
	}
	
	public static int cardGame(int start, int end) {
		
		// 이미 채워짐 ( 안넣을 경우 시간초과 걸림)
		// 카드 점수는 자연수로 주어지므로 이미 채워진 점수라면 0이 아니다
		if(DP[start][end]!=0) {
			return DP[start][end];
		}
		
		// 선택할 수 있는 카드 개수 한장 
		// 총 카드 개수가 홀수일 경우 근우가 점수를 먹는다
		if(start==end) {
			if(kTurn==1) {
				return card[start];
			}else {
				return 0;
			}
		}
		
		// 남은 카드의 개수 = end-start+1 
		// 근우는 항상 카드를 먼저 선택하므로 
		// 총 카드의 개수가 홀수(짝수)라면 남은 카드의 개수가 홀수(짝수)일때 근우의 차례이다
		if((end-start+1)%2==kTurn) {
			// 근우 차례
			DP[start][end] = Math.max(card[start]+cardGame(start+1,end), card[end]+cardGame(start,end-1));
		
		}else{
			// 명우 차례
			// 명우의 점수는 따로 저장하지 않는다 , 최소로만 선택한다
			return Math.min(cardGame(start+1,end), cardGame(start,end-1));
		}
		
		return DP[start][end];
	}

}
