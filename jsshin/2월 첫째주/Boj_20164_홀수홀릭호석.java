package feb.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_20164_홀수홀릭호석 {

	static int totalOdd;
	static int min,max;
	static int[] combArr = new int[2];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String number = br.readLine();
		
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		_process(number);
		
		System.out.println(min+" "+max);
	
	}

	private static void _process(String number) {
		int cnt = 0;
		for(char c : number.toCharArray()) {
			if((c-'0')%2==1) {
				cnt++;
			}
		}
		totalOdd += cnt;
		if (number.length() == 1) {
			min = Math.min(min, totalOdd);
			max = Math.max(max, totalOdd);
			totalOdd -= cnt;
			return;
			
		} else if (number.length() == 2) {
			int sum = number.charAt(0)-'0' + number.charAt(1)-'0';
			
			// 9+9 = 18 2자리가 또 나올 수 있다
			_process(String.valueOf(sum));
			
		} else if (number.length() >= 3) {

			_combination(0,number);
		}
		totalOdd -= cnt;
	}

	private static void _combination(int cnt, String number) {
		if(cnt==2) {
			String num1 = number.substring(0, combArr[0]);
			String num2 = number.substring(combArr[0],combArr[1]);
			String num3 = number.substring(combArr[1]);
			
			int sum = Integer.parseInt(num1)+Integer.parseInt(num2)+Integer.parseInt(num3);
			_process(String.valueOf(sum));
			
			return;
		}
		
		if(cnt==0) {
			for(int i=1;i<number.length()-1;i++) {
				combArr[cnt] = i;
				_combination(cnt+1, number);
			}
		}else {
			for(int i=combArr[0]+1;i<number.length();i++) {
				combArr[cnt] = i;
				_combination(cnt+1, number);
			}
		}
	}

}
