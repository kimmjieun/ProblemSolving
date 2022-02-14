package feb.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Boj_22252_정보상인호석 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int Q = Integer.parseInt(br.readLine());
		int answer = 0;
		
		Map<String, PriorityQueue<Integer>> map = new HashMap<String, PriorityQueue<Integer>>();
		
		while(Q-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int Qi = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			
			// 정보를 얻은 고릴라
			if(Qi==1) {
				PriorityQueue<Integer> que = null;
				if(map.get(name) == null) {
					que = new PriorityQueue<Integer>(Collections.reverseOrder());
					
				}else {
					que = map.get(name);
					
				}
				
				int C = Integer.parseInt(st.nextToken());
				for(int i=0;i<C;i++) {
					que.add(Integer.parseInt(st.nextToken()));
				}
				
				map.put(name, que);
				
			// 정보를 거래	
			}else if(Qi==2) {
				int b = Integer.parseInt(st.nextToken());
				PriorityQueue<Integer> que = map.get(name);
				if(que == null) continue;
				for(int i=0;i<b;i++) {
					if(que.isEmpty()) break;
					answer += que.poll();
				}
				
			}
		}
		
		System.out.println(answer);
		

	}

}
