package feb.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1194_달이차오른다가자 {
	static int N, M;
	static char board[][];

	static class Pos {
		int r, c, key;

		public Pos(int r, int c, int key) {
			this.r = r;
			this.c = c;
			this.key = key;
		}

	}

	static int answer;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
	static Queue<Pos> que = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new char[N][M];

		String s = null;

		for (int i = 0; i < N; i++) {
			s = br.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = s.charAt(j);
				if (s.charAt(j) == '0') {
					que.add(new Pos(i, j, 0));
				}
			}
		}
		// board에 입력 끝

		answer = Integer.MAX_VALUE;
		bfs();
		System.out.println(answer);

	}
	
	private static void bfs() {
		// 63가지 상태 ( 모든 열쇠를 다 가졌을 경우 비트 연산으로 하면 63가지이다)
		boolean[][][] visited = new boolean[N][M][64];
		int move = 0; // 움직인 횟수 저장할 변수

		while (!que.isEmpty()) {
			int size = que.size();
			move++;

			while (size-- > 0) {
				Pos curr = que.poll();
				int k = curr.key;
				for (int i = 0; i < 4; i++) {
					int dr = curr.r + dirs[i][0];
					int dc = curr.c + dirs[i][1];
					int dk = k;// key값을 비트로 가지고 있기

					if (dr < 0 || dc < 0 || dr >= N || dc >= M)
						continue;
					// 벽이거나 어떤 상태로 방문했다면 true
					if (board[dr][dc] == '#' || visited[dr][dc][k])
						continue;

					// 출구
					if (board[dr][dc] == '1') {
						answer = move;
						return;
					}
					// 열쇠
					else if (board[dr][dc] >= 'a' && board[dr][dc] <= 'f') {
						int shift = board[dr][dc] - 'a';
						int key = 1 << shift;
						// 새로운 키를 줍는다
						if ((k & key) != key)
							dk = k | key;
					}
					// 문
					else if (board[dr][dc] >= 'A' && board[dr][dc] <= 'F') {
						int key = 1 << (board[dr][dc] - 'A');
						if ((k & key) != key) { // 키를 가지고 있지 않다면
							continue;
						}
					}
					// 출구를 못만났거나, 열쇠를 주운 후이거나, 열쇠가 있어서 통과했거나, 빈곳이었거나
					que.add(new Pos(dr, dc, dk)); // 민식이 새 위치 & 열쇠 보유 상태
					visited[dr][dc][k] = true;
				} // 4방향 끝
			}
		}
		answer = -1;
	}
}
