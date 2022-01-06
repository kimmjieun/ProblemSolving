package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미세먼지_안녕_17144 {

	static int R, C, T, map[][];
	static int check = -1;
	static Queue<Dust> dusts;
	static int[] dx = { 0, -1, 0, 1 }, dy = { 1, 0, -1, 0 };

	static class Dust {
		int x, y, w;

		public Dust(int x, int y, int w) {
			super();
			this.x = x;
			this.y = y;
			this.w = w;
		}
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken()); // 행
		C = Integer.parseInt(st.nextToken()); // 열
		T = Integer.parseInt(st.nextToken()); // 초
		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (check == -1 && map[i][j] == -1) {
					check = i;
				}
			}
		}

		for (int time = 0; time < T; time++) {
			checkDust();
			spread();
			operate();
		}
		int res = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == -1)
					continue;
				res += map[i][j];
			}
		}
		System.out.println(res);
	}

	private static void checkDust() {
		dusts = new LinkedList<>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (!(map[i][j] == -1 || map[i][j] == 0))
					dusts.add(new Dust(i, j, map[i][j]));
			}
		}
	}

	private static void spread() {

		while (!dusts.isEmpty()) {
			Dust now = dusts.poll();
			if (now.w < 5)
				continue;
			int result = now.w / 5;
			int cnt = 0;
			for (int d = 0; d < 4; d++) {
				int newX = now.x + dx[d];
				int newY = now.y + dy[d];
				if (newX < 0 || newX >= R || newY < 0 || newY >= C)
					continue;
				if (map[newX][newY] == -1)
					continue;
				map[newX][newY] += result;
				++cnt;
			}
			map[now.x][now.y] -= result * cnt;
		}
	}

	private static void operate() {

		int top = check;
		int down = check + 1;

		for (int i = top - 1; i > 0; i--)
			map[i][0] = map[i - 1][0];
		for (int i = 0; i < C - 1; i++)
			map[0][i] = map[0][i + 1];
		for (int i = 0; i < top; i++)
			map[i][C - 1] = map[i + 1][C - 1];
		for (int i = C - 1; i > 1; i--)
			map[top][i] = map[top][i - 1];
		map[top][1] = 0;
		for (int i = down + 1; i < R - 1; i++)
			map[i][0] = map[i + 1][0];
		for (int i = 0; i < C - 1; i++)
			map[R - 1][i] = map[R - 1][i + 1];
		for (int i = R - 1; i > down; i--)
			map[i][C - 1] = map[i - 1][C - 1];
		for (int i = C - 1; i > 1; i--)
			map[down][i] = map[down][i - 1];
		map[down][1] = 0;
	}

}
