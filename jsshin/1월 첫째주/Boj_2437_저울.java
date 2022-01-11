package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_2437_저울 {

	static int N;
	static int[] weight;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		weight = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			weight[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(weight);
		int sum=0;
		for(int i=0;i<N;i++) {
			if(sum+1<weight[i]) {
				break;
			}
			sum+=weight[i];
		}
		System.out.println(sum+1);
	}

}
