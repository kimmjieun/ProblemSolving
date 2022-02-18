package week3;

import java.util.LinkedList;
import java.util.Queue;

public class Pgm_양과늑대 {

	static class currNode {
		int idx;
		int sheep;
		int wolf;
		int bitVisited;

		currNode(int idx, int sheep, int wolf, int bitVisited) {
			this.idx = idx;
			this.sheep = sheep;
			this.wolf = wolf;
			this.bitVisited = bitVisited;
		}

		@Override
		public String toString() {
			return "currNode [idx=" + idx + ", sheep=" + sheep + ", wolf=" + wolf + ", bitVisited=" + bitVisited + "]";
		}

	}

	public static void main(String[] args) {
		int[] info = { 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1 };
		int[][] edges = { { 0, 1 }, { 1, 2 }, { 1, 4 }, { 0, 8 }, { 8, 7 }, { 9, 10 }, { 9, 11 }, { 4, 3 }, { 6, 5 },
				{ 4, 6 }, { 8, 9 } };
		solution(info, edges);
	}

	static int N;
	static LinkedList<Integer>[] graph;

	public static int solution(int[] info, int[][] edges) {
		int answer = 0;
		N = info.length;

		graph = new LinkedList[N];
		for (int i = 0; i < N; i++) {
			graph[i] = new LinkedList<Integer>();
		}

		for (int[] connect : edges) {
			graph[connect[0]].add(connect[1]);
			graph[connect[1]].add(connect[0]);
		}

		answer = bfs();
		System.out.println(answer);
		return answer;
	}

	private static int bfs() {

		// 3차원을 방문배열을 만든 이유 부모 자식 노드를 번갈아가며 가지 않기 위해
		// visited[노드][양][늑대]
		boolean[][][] visited = new boolean[N][18][18];
		visited[0][1][0] = true;

		Queue<currNode> queue = new LinkedList<currNode>();
		queue.add(new currNode(0, 1, 0, (0 | 1 << 0)));

		int answer = 0;
		
		while (!queue.isEmpty()) {
			currNode node = queue.poll();
//			System.out.println(node.toString());
			answer = Math.max(answer, node.sheep );
			for (int childNode : graph[node.idx]) {

				int sheep = node.sheep;
				int wolf = node.wolf;
				int bitVisited = node.bitVisited;

				if ((bitVisited & 1 << childNode) == 0 && nodeInfo[childNode] == 0) {
					sheep += 1;

				} else if ((bitVisited & 1 << childNode) == 0 && nodeInfo[childNode] == 1) {
					// 늑대
					wolf += 1;
				}
//				System.out.println(childNode+" "+sheep+" "+wolf+"----------------");
//				System.out.println("결과"+visited[childNode][sheep][wolf]);

				if (visited[childNode][sheep][wolf])
					continue;
				visited[childNode][sheep][wolf] = true;

				if (sheep > wolf) {
					queue.add(new currNode(childNode, sheep, wolf, (bitVisited | 1 << childNode)));
				}

			}
		}
		return answer;
	}

}
