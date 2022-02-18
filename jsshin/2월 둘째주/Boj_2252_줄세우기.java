package feb.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_2252_줄세우기 {

	static int[] nodeArr;
	static LinkedList<Integer>[] graph;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		nodeArr = new int[N+1];
		graph = new LinkedList[N+1];
		
		for(int i=1;i<=N;i++) {
			graph[i] = new LinkedList<Integer>();
		}
		
		while(M-->0) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			nodeArr[B]++;
			graph[A].add(B);
		}
		
		
		System.out.println(_topologicalSort());
		
	}
	private static String _topologicalSort() {
		StringBuilder answer = new StringBuilder();
		
		Queue<Integer> que = new LinkedList<Integer>();
		for(int root=1;root<=N;root++) {
			if(nodeArr[root]==0) {
				que.add(root);
				answer.append(root).append(" ");
			}
		}
		
		while(!que.isEmpty()) {
			int parents = que.poll();
			for(int child : graph[parents]) {
				if(--nodeArr[child]==0) {
					que.add(child);
					answer.append(child).append(" ");
				}
			}
		}
		
		return answer.toString();
	}

}
