package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_3020_개똥벌레 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		int[] floor = new int[H+1];	 // 석순
		int[] ceil = new int[H+1];	// 종유석
		
		
		for(int i=0;i<N;i++) {
			int idx = Integer.parseInt(br.readLine());
			if(i%2==0) {
				floor[idx]++;
			}else {
				ceil[idx]++;
			}
		}
		
		for(int i=H-1;i>0;i--) {
			floor[i]+=floor[i+1];
			ceil[i]+=ceil[i+1];
		}
		
		int min = N+1;
		int answer = 0;
		for(int i=1;i<=H;i++) {
			int sum = floor[i]+ceil[H-i+1];
			
			if(sum<min) {
				min=sum;
				answer=1;
			}else if(sum==min) {
				answer++;
			}
		}

		System.out.println(min+" "+answer);
	}

}
