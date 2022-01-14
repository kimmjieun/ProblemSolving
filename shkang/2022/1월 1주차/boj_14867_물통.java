package boj14867;

import java.util.*;
import java.io.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int aSize, bSize, aGoal, bGoal, curA, curB, answer;

	static void input() throws IOException {
		st = new StringTokenizer(br.readLine());
		aSize = Integer.parseInt(st.nextToken());
		bSize = Integer.parseInt(st.nextToken());
		aGoal = Integer.parseInt(st.nextToken());
		bGoal = Integer.parseInt(st.nextToken());
		answer = -1;
	}

	static int isPossible(int a, int b) { // 동일한 패턴 반복으로 목표 달성이 되는가?
		if (a == aGoal && b == bGoal)
			return 1;
		if (a == 0 && b == 0) {
			return -1;
		} else if (a == 0 && b != 0) {
			return bGoal % b == 0 && a == aGoal ? bGoal / b : -1;
		} else if (a != 0 && b == 0) {
			return aGoal % a == 0 && b == bGoal ? aGoal / a : -1;
		} else { // 둘 다 양수
			if (aGoal % a == 0 && bGoal % b == 0 && aGoal / a == bGoal / b) {
				return aGoal / a;
			}
		}
		return -1;
	}

	static class Bucket {
		int a, b;
		int count = 0;

		public Bucket(int a, int b, int count) {
			this.a = a;
			this.b = b;
			this.count = count;
		}
	}

	static void action() {
		HashMap<String, Integer> visited = new HashMap<>();
		Queue<Bucket> queue = new LinkedList<>();
		queue.add(new Bucket(0, 0, 0));
		while (!queue.isEmpty()) {
			Bucket bucket = queue.poll();
			String footPrint = String.valueOf(bucket.a) + "_" + String.valueOf(bucket.b);
			if (visited.containsKey(footPrint)) { // 방문 기록 있는지 체크
				if (visited.get(footPrint) <= bucket.count) {
					continue;
				} else { // 더 적은 경우라면
					visited.put(footPrint, bucket.count);
				}
			} else {// 방문기록 없다면
				visited.put(footPrint, bucket.count);
			}
			int result = isPossible(bucket.a, bucket.b);
			if (result >= 0) {
				answer = answer > -1 ? Math.min(bucket.count * result, answer) : result * bucket.count;
				continue;
			}
			// Fill A
			if (bucket.a != aSize) {
				queue.add(new Bucket(aSize, bucket.b, bucket.count + 1));
			}
			// Fill B
			if (bucket.b != bSize) {
				queue.add(new Bucket(bucket.a, bSize, bucket.count + 1));
			}
			// Empty A
			if (bucket.a != 0) {
				queue.add(new Bucket(0, bucket.b, bucket.count + 1));
			}
			// Empty B
			if (bucket.b != 0) {
				queue.add(new Bucket(bucket.a, 0, bucket.count + 1));
			}
			// Move A to B
			if (bucket.a != 0 && bucket.b != bSize) {
				if (bSize - bucket.b >= bucket.a) {
					queue.add(new Bucket(0, bucket.b + bucket.a, bucket.count + 1));
				} else {// A 양이 더 많은 경우
					queue.add(new Bucket(bucket.a - (bSize - bucket.b), bSize, bucket.count + 1));
				}
			}
			// Move B to A
			if (bucket.b != 0 && bucket.a != aSize) {
				if (aSize - bucket.a >= bucket.b) {
					queue.add(new Bucket(bucket.b + bucket.a, 0, bucket.count + 1));
				} else {// B 양이 더 많은 경우
					queue.add(new Bucket(aSize, bucket.b - (aSize-bucket.a), bucket.count + 1));
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		input();
		action();
		System.out.println(answer);
	}
}