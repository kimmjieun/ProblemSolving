//package Gold이상문제_정리;

import java.io.*;
import java.util.*;

public class Main {
	static int N, M, MAX, ret, S, E;
	static boolean[] visited;
	static ArrayList<pair>[] adjList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		visited = new boolean[N];
		adjList = new ArrayList[N];
		for (int i = 0; i < N; i++)
			adjList[i] = new ArrayList<>();

		for (int i = 0; i < M; i++)
		{
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int max = Integer.parseInt(st.nextToken());
			adjList[from].add(new pair(to, max));
			adjList[to].add(new pair(from, max));
			MAX = Math.max(MAX, max);
		}

		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken()) - 1;
		E = Integer.parseInt(st.nextToken()) - 1;

		ret = Integer.MAX_VALUE;
		find(1, MAX);
		System.out.println(ret);
	}
	private static void find(int start, int end)
	{
		while (start <= end)
		{
			int mid = (start + end) / 2;
			if (DFS(S, mid)) {
				ret = mid;
				start = mid + 1;
			}
			else
				end = mid - 1;
			Arrays.fill(visited, false);
		}
	}

	private static boolean DFS(int s, int mid) {
		visited[s] = true;
		if (s == E) return true;
		for (pair next : adjList[s]) {
			if (!visited[next.to] && next.weight >= mid) {
				if (DFS(next.to, mid))
					return true;
			}
		}
		return false;
	}

	private static class pair
	{
		int to;
		int weight;
		public pair(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}
}

