package feb.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_20164_홀수홀릭호석 {

	static int min, max;
	static int[] combArr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String number = br.readLine();

		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		combArr = new int[2];

		_process(number, 0);

		System.out.println(min + " " + max);

	}

	private static void _process(String number, int oddCnt) {
		int cnt = 0;
		for (char c : number.toCharArray()) {
			if ((c - '0') % 2 == 1) {
				cnt++;
			}
		}
		oddCnt += cnt;
		if (number.length() == 1) {
//			System.out.println(number);
			min = Math.min(min, oddCnt);
			max = Math.max(max, oddCnt);
//			System.out.println("==========================="+totalOdd);
			return;

		} 
		
		if (number.length() == 2) {
//			System.out.println(number.charAt(0)+"+"+ number.charAt(1));
			int sum = number.charAt(0) - '0' + number.charAt(1) - '0';

			// 9+9 = 18 2자리가 또 나올 수 있다
			_process(Integer.toString(sum), oddCnt);
			return;

		}

		for(int i=1;i<number.length();i++) {
			for(int j=i+1;j<number.length();j++) {
				
				String sumNum = _splitNumber(i, j, number);
				_process(sumNum,oddCnt);
			}
		}
	}

	private static String _splitNumber(int i, int j, String number) {
//			System.out.println(i+" "+j);
			String num1 = number.substring(0, i);
			String num2 = number.substring(i, j);
			String num3 = number.substring(j);
//			System.out.println(num1+" + "+num2+" + "+num3);
			int sum = Integer.parseInt(num1) + Integer.parseInt(num2) + Integer.parseInt(num3);

			return Integer.toString(sum);
	}

}