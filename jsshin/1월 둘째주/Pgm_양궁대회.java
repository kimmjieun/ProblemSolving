package week3;

import java.util.Arrays;

public class Pgm_양궁대회 {

	public static void main(String[] args) {
		int n = 10;
		int[]info = {0,0,0,0,0,0,0,0,3,4,3};
		solution(n, info);
		
	}

	static int[] lionInfo;
	static int[] apeachInfo;
	static int[] ANSWER;
	static int N, MAX_DIFF=0;
	public static int[] solution(int n, int[] info) {
		ANSWER = new int[]{-1};
        N = n;
        apeachInfo = info;
        lionInfo = new int[11];
        
        comb(0);
        System.out.println(Arrays.toString(ANSWER));
        return ANSWER;
    }
	
	public static void comb(int cnt) {
		if(cnt==N) {
			int apeachSum = 0;
			int lionSum = 0;
			
			for(int i=0;i<11;i++) {
				if(apeachInfo[i]==0 && lionInfo[i]==0 ) continue;
				if(apeachInfo[i]>=lionInfo[i]) {
					apeachSum += (10-i);
				}else {
					lionSum += (10-i);
				}
			}
			int diff = lionSum-apeachSum;
			if(diff<0) return;
//			System.out.println(Arrays.toString(lionInfo)+" "+diff);
			if(MAX_DIFF<diff) {
				MAX_DIFF = diff;
				ANSWER = lionInfo.clone();
			}
			return;
		}
		
		for(int i=0;i<11;i++) {
			lionInfo[i]++;
			comb(cnt+1);
			lionInfo[i]--;
		}
	}
	
}
