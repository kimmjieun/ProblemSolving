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

	static class Bucket implements Comparable<Bucket> {
		int a, b;
		int count = 0;

		public Bucket(int a, int b, int count) {
			this.a = a;
			this.b = b;
			this.count = count;
		}

		@Override
		public int compareTo(Bucket o) {
			return count - o.count;
		}

		@Override
		public boolean equals(Object o) {
			Bucket bucket = (Bucket) o;
			return a == bucket.a && b == bucket.b;
		}

		@Override
		public int hashCode() {
			return Objects.hash(a, b);
		}		
	}

	static void action() {
		HashMap<Bucket, Integer> visited = new HashMap<>();
		PriorityQueue<Bucket> queue = new PriorityQueue<>();
		queue.add(new Bucket(0, 0, 0));
		while (!queue.isEmpty()) {
			Bucket bucket = queue.poll();
			if (visited.containsKey(bucket)) { // 방문 기록 있는지 체크
				if (visited.get(bucket) <= bucket.count) {
					continue;
				} else { // 더 적은 경우라면
					visited.put(bucket, bucket.count);
				}
			} else {// 방문기록 없다면
				visited.put(bucket, bucket.count);
			}
			if(bucket.a==aGoal && bucket.b==bGoal) {
				answer = bucket.count;
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
					queue.add(new Bucket(aSize, bucket.b - (aSize - bucket.a), bucket.count + 1));
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