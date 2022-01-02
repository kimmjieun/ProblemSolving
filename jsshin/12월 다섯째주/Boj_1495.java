package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1495 {

	static int N,S,M;
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 볼륨 N개 받기
		int[] vol = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			vol[i] = Integer.parseInt(st.nextToken());
		}
		
		// dp[N][M] ; N번째 노래가 볼륨이 M일 때 가능한가 여부
		// 노래 시작은 0번째부터 하므로 N+1을 한다
		// 볼륨 최대값은 포함하므로 M+1을 한다
		boolean[][] dp = new boolean[N+1][M+1];
		dp[0][S] = true;
		
		int validVol = 0; // 볼륨 연산 변수
		for(int sequence=1;sequence<N+1;sequence++) {  		// 순서
			for(int volumn=0;volumn<M+1;volumn++) {			// 볼륨
				
				// 이전 순서 연주가 가능할 경우
				if(dp[sequence-1][volumn]) {
					validVol = volumn + vol[sequence-1];	// 이전순서 변환가능볼륨과 연산
					if(validVol<=M) {						// 볼륨 유효 구간 검사
						dp[sequence][validVol] = true;
					}
					
					validVol = volumn - vol[sequence-1];	// 이전순서 변환가능볼륨과 연산
					if(validVol>=0) {						// 볼륨 유효 구간 검사
						dp[sequence][validVol] = true;
					}
				}
			}
		}
		
		// 연주가 불가능할 경우 -1 출력
		int output = -1;
		for(int i=0;i<M+1;i++) {
			output = dp[N][i]? Math.max(output, i):output;
		}
		
		System.out.println(output);
	}

}
