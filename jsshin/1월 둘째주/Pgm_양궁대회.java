package week3;

public class Pgm_양궁대회 {

	public static void main(String[] args) {
		int n = 9;
		int[] info = { 0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1 };
//		int n = 10;
//		int[]info = {0,0,0,0,0,0,0,0,3,4,3};
//		int n = 5;
//		int[] info = { 2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0 };
		solution(n, info);

	}

	static int[] lionInfo;
	static int[] apeachInfo;
	static int[] ANSWER;
	static int N, MAX_DIFF = 0;

	public static int[] solution(int n, int[] info) {
		ANSWER = new int[] { -1 };
		N = n;
		apeachInfo = info;
		lionInfo = new int[11];

		comb(0, N);
//		System.out.println(Arrays.toString(ANSWER));
		return ANSWER;
	}

	public static void comb(int idx, int arrow) {
		if (idx == 10) {
			if (arrow > 0) {
				lionInfo[10] += arrow;
			}
			int apeachSum = 0;
			int lionSum = 0;

			for (int i = 0; i < 11; i++) {
				if (apeachInfo[i] == 0 && lionInfo[i] == 0)
					continue;
				if (apeachInfo[i] >= lionInfo[i]) {
					apeachSum += (10 - i);
				} else {
					lionSum += (10 - i);
				}
			}

			int diff = lionSum - apeachSum;
			if (MAX_DIFF < diff) {
				MAX_DIFF = diff;
				ANSWER = lionInfo.clone();

			} else if (diff > 0 && MAX_DIFF == diff && lowerScore()) {
				ANSWER = lionInfo.clone();
			}

			lionInfo[10] = 0;
			return;
		}

		// 최적의 상황으로 진행해보기
		if (arrow >= apeachInfo[idx] + 1 && apeachInfo[idx] >= lionInfo[idx]) {
			// 이긴다; 따는 점수
			lionInfo[idx] = apeachInfo[idx] + 1;
			comb(idx + 1, arrow - (apeachInfo[idx] + 1));
			lionInfo[idx] -= apeachInfo[idx] + 1;
		}

		// 진다; 버리는 점수 ; 화살을 놓지 않는다
		comb(idx + 1, arrow);

	}

	private static boolean lowerScore() {
		// 초기값 {-1}
		if (ANSWER.length == 1)
			return true;

		for (int i = 10; i > -1; i--) {
			if (ANSWER[i] > lionInfo[i]) { // 기존정답이 하단 과녁갯수가 더 높다
				return false;
			} else if (ANSWER[i] < lionInfo[i]) { // 새로운정답이 하단 과녁갯수가 더 높다 (값변경)
				return true;
			}
		}
		return false;
	}

}
