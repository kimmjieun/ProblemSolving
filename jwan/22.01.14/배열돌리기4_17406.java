package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 배열돌리기4_17406 {
	static int N, M, K;
	static int ans = Integer.MAX_VALUE;
	static int r[], s[], c[];
	static int[][] A;
	static int[][] visit;
	static boolean[] check;
	static int[][] posit = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, -1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		A = new int[N][M];
		visit = new int[N][M];
		r = new int[K];
		c = new int[K];
		s = new int[K];
		check = new boolean[K];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			r[i] = Integer.parseInt(st.nextToken());
			c[i] = Integer.parseInt(st.nextToken());
			s[i] = Integer.parseInt(st.nextToken());
		}
		answer(0);
		System.out.println(ans);
	}

	private static void answer(int depth) {
		if (depth == K) {
			int tempAns = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				int temp = 0;
				for (int j = 0; j < M; j++) {
					temp += A[i][j];
				}
				tempAns = Math.min(temp, tempAns);
			}
			ans = Math.min(tempAns, ans);
			return;
		}
		for (int i = 0; i < K; i++) {
			if (!check[i]) {
				rotate(i);
				check[i] = true;
				answer(depth + 1);
				reRotate(i);
				check[i] = false;
			}
		}
	}

	private static void rotate(int idx) {
		// r1 -> r2, c1 -> c2
		int r1 = r[idx] - s[idx] - 1;
		int r2 = r[idx] + s[idx] - 1;
		int c1 = c[idx] - s[idx] - 1;
		int c2 = c[idx] + s[idx] - 1;
		while (r1 != r2) {
			int LU = A[r1][c1];
			for (int i = r1; i < r2; i++) {
				A[i][c1] = A[i + 1][c1];
			}
			for (int i = c1; i < c2; i++) {
				A[r2][i] = A[r2][i + 1];
			}
			for (int i = r2; i > r1; i--) {
				A[i][c2] = A[i - 1][c2];
			}
			for (int i = c2; i > c1 + 1; i--) {
				A[r1][i] = A[r1][i - 1];
			}
			A[r1][c1 + 1] = LU;
			r1++;
			r2--;
			c1++;
			c2--;
		}
	}

	private static void reRotate(int idx) {
		int r1 = r[idx] - s[idx] - 1;
		int r2 = r[idx] + s[idx] - 1;
		int c1 = c[idx] - s[idx] - 1;
		int c2 = c[idx] + s[idx] - 1;
		while (r1 != r2) {
			int LU = A[r1][c1];
			for (int i = c1; i < c2; i++) {
				A[r1][i] = A[r1][i + 1];
			}
			for (int i = r1; i < r2; i++) {
				A[i][c2] = A[i + 1][c2];
			}
			for (int i = c2; i > c1; i--) {
				A[r2][i] = A[r2][i - 1];
			}
			for (int i = r2; i > r1 + 1; i--) {
				A[i][c1] = A[i - 1][c1];
			}
			A[r1 + 1][c1] = LU;
			r1++;
			r2--;
			c1++;
			c2--;
		}
	}
}
