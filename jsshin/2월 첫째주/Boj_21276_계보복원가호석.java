package feb.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Boj_21276_계보복원가호석 {

	static TreeMap<String, Integer> people;
	static LinkedList<String>[] graph;
	static int[] nodeCount;
	static StringBuilder answer = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		people = new TreeMap<String, Integer>();
		graph = new LinkedList[N];
		nodeCount = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++) {
			String name = st.nextToken();
			people.put(name,i);
			graph[i] = new LinkedList<String>();
		}
		
		int M = Integer.parseInt(br.readLine());
		while(M-->0) {
			st = new StringTokenizer(br.readLine()," ");
			String child = st.nextToken();
			String ancestor = st.nextToken();
			graph[people.get(ancestor)].add(child);
			nodeCount[people.get(child)]++;	// 들어오는 간선 개수 
		}
		
		_topologicalSort();
		
		for(String person : people.keySet()) {
			LinkedList<String> children = graph[people.get(person)];
			Collections.sort(children);
			answer.append(person).append(" ");
			answer.append(children.size()).append(" ");
			for(String child : children) {
				answer.append(child).append(" ");
			}
			answer.append("\n");
		}
		
		System.out.println(answer);
		
	}

	private static void _topologicalSort() {
		Queue<String> que = new LinkedList<String>();
		
		StringBuilder levelZero = new StringBuilder();
		for(String person : people.keySet()) {
			if(nodeCount[people.get(person)]==0) {
				que.add(person);
				levelZero.append(person+" ");
			}
		}
		
		answer.append(que.size()).append("\n").append(levelZero).append("\n");
		
		while(!que.isEmpty()) {
			String parents = que.poll();
			Iterator<String> it = graph[people.get(parents)].iterator();
			while(it.hasNext()) {
				String child = it.next();
				int idx = people.get(child);
				nodeCount[idx]--;
				if(nodeCount[idx]==0) { //연결되었다 (부모)
					que.add(child);
				}else { // 연결되지 않았다 (다른부모가 있다)
					it.remove();
				}
			}
			
		}
		
	}

}
