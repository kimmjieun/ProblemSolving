package week3;

import java.util.Arrays;

public class Pgm_k진수에서소수개수구하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(110011, 10));
		//	110011, 10
	}

	public static int solution(int n, int k) {
		int answer = 0;
		StringBuilder sb = new StringBuilder();
		while (n != 0) {
			sb.append(n % k);
			n /= k;
		}
		String trans = sb.reverse().toString();
		System.out.println(trans);
		System.out.println(Arrays.toString(trans.split("0")));
		for (String num : trans.split("0")) {
			if (num.isEmpty()) continue;
			boolean flag = _isPrime(Integer.parseInt(num));
			System.out.println(flag+"  ,   "+num);
			if (flag) {
				answer++;
			}
		}

		answer = answer == 0 ? -1 : answer;
		return answer;
	}

	private static boolean _isPrime(int num) {
		if(num==1) return false;
		for(int i=2;i<Math.sqrt(num);i++) {
			if(num % i ==0 ) return false;
		}
		return true;
	}

}
