package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1939 {

	static class Node{
		int vertex;
		int edge;
		Node(int vertex,int edge) {
			this.vertex = vertex;
			this.edge = edge;
		}
	}
	
	static int N,M,start,end,left,right;
	static LinkedList<Node>[] graph;
	static boolean[] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 문제에 메모리 제한이 있으므로 인접리스트로 한다
		graph = new LinkedList[N+1];
		
		for(int i=1;i<N+1;i++) {
			graph[i] = new LinkedList<Node>();
		}
		
		// C의 범위는 1부터 시작한다
		left = 1;
		right = 0;
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph[a].add(new Node(b,c));
			graph[b].add(new Node(a,c));

			// 최대값
			right = Math.max(right, c);
		}
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		// 중량 이분탐색
		binarySearch();
		
	}
	private static void binarySearch() {
		int answer = 0;
		
		while(left<=right) {
			int mid = (left+right)/2;
			
			if(bfs(start,mid)) {
				// 성공했으므로 크기를 작게 해본다
				answer = mid;
				right = mid-1;
				
			}else {
				// 실패했으므로 크기를 키운다 
				left = mid+1;
			}
		}
		System.out.println(answer);
	}
	
	private static boolean bfs(int start,int weight) {
		visited = new boolean[N+1];
		visited[start] = true;
		
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			
			// 도착지
			if(curr==end) {
				return true;
			}
			
			for(Node n:graph[curr]) {
				
				// 방문하지 않았고, 중량이 작을 경우만 
				if(!visited[n.vertex] && n.edge<=weight) {
					visited[n.vertex] = true;
					queue.add(n.vertex);
				}
				
			}
		}
		return false;
		
	}
	

}
