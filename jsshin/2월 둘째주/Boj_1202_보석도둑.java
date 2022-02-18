package feb.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_1202_보석도둑 {
	
	static class Jewel{
		int weight ;
		int value ;
		Jewel(int weight, int value){
			this.weight = weight;
			this.value = value;
		}
		@Override
		public String toString() {
			return "Jewel [weight=" + weight + ", value=" + value + "]";
		}
		
	}

	static Jewel[] jewelArr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		jewelArr = new Jewel[N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			jewelArr[i] = new Jewel(M, V);
		}
		
		PriorityQueue<Integer> jewelPrio = new PriorityQueue<Integer>(Collections.reverseOrder());
		PriorityQueue<Integer> bags = new PriorityQueue<Integer>(Collections.reverseOrder());
		while(K-->0) {
			int b = Integer.parseInt(br.readLine());
			bags.add(b);
		}
		
		long answer = 0;
		while(!bags.isEmpty()) {
			int bag = bags.poll();
			int idx = -1;
			System.out.println(bag);
			for(int i=0;i<N;i++) {
				if(bag>=jewelArr[i].weight) {
					jewelPrio.add(jewelArr[i].value);
					idx = i;
				}
			}
			System.out.println(idx+" idx");
			if(idx!=-1) {
				System.out.println(jewelPrio.peek());
				answer+=jewelPrio.poll();
				System.out.println(jewelArr[idx]);
				jewelArr[idx].value = -1;
			}
		}
		
		System.out.println(answer);
		
	}
}

