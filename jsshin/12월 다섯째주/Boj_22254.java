package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_22254 {
	
	static int N,X;
	static int[] time ;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		time = new int[N];
		for(int i=0;i<N;i++) {
			time[i] = Integer.parseInt(st.nextToken());
		}
		
		binarySearch();

	}

	private static void binarySearch() {
		// N은 자연수이다
		int left = 1; 
		int right = N;
		int mid = 0;
		int answer = 0;
		while(left<=right) {
			mid = (left+right)/2;
			
			// 제한시간안에 공정이 가능하다면 라인을 줄인다
			if(process(mid)) {
				answer = mid;
				right = mid-1;
			}else {
				left = mid+1;
			}
		}
		
		System.out.println(answer);
	}

	private static boolean process(int prcsLineCnt) {
		// 적은 시간 순서부터 선물을 제작하기 위해 우선순위 큐를 사용
		PriorityQueue<Integer> prio = new PriorityQueue<Integer>(); 
		
		// 공정라인 개수만큼 우선순위큐에 넣는다
		// 공정라인 초기화
		for(int i=0;i<prcsLineCnt;i++) {
			prio.add(0);					
		}
		
		// top(가장 적은시간)을 뽑아 선물제작시간 추가 
		for(int i=0;i<N;i++) {
			int prcsTime = prio.poll()+time[i];
			
			//최대 X시간을 넘으면 불가하다
			if(prcsTime>X) return false;
			prio.add(prcsTime);
		}
		return true;
	}

}
