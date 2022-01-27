package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_14725_개미굴 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] num = new int[K];
		PriorityQueue<Long> prio = new PriorityQueue<Long>();
		for(int i=0;i<K;i++) {
			num[i] = Integer.parseInt(st.nextToken());
			prio.add((long)num[i]);
		}
		
		
		int cnt=0;
		long tmpNum = 0;
		while(cnt++!=N) {
			tmpNum = prio.poll();
//			System.out.print(tmpNum+" ");
			for(int ni : num) {
				prio.add(tmpNum*ni);
				if(tmpNum%ni==0) break;
			}
		}
		System.out.println(tmpNum);
	}

}
