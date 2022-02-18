package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_15684_사다리조작 {

	static int N,M,H;
	static int[][] ladder;
	static int answer;
	public static void main(String[] args) throws IOException{
		
		answer = 4;
		
		_setData();
		_combination(0,1);
		
		answer = answer == 4 ? -1 : answer;
		System.out.println(answer);
	}
	
	private static void _setData() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		ladder = new int[H+1][N+1];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			ladder[r][c] = 1;
			
		}
		
	}
	
	private static void _combination(int cnt, int rowIdx) {
		if(cnt>3) {
			return;
		}
		
		if(_isResultSame()) {
			System.out.println(cnt);
			System.exit(0);
		}
		
		for(int r=rowIdx;r<H+1;r++) {
			// 마지막 열은 사다리 생성 불가
			for(int c=1;c<N;c++) {
				if(ladder[r][c]==0) {
					ladder[r][c] = 1;
					
					// 다음 열 검사를 위해 행위치는 그대로 
					_combination(cnt+1, r);
					
					ladder[r][c]=0;
				}
			}
		}
		
	}

	private static boolean _isResultSame() {
		for(int start=1;start<N+1;start++) {
			int ci = start;
			int ri = 1;
			
			while(ri<H+1) {
				// 선이 있다
				if(ladder[ri][ci]==1) {
					ci++;
				} else if(ci>1 && ladder[ri][ci-1]==1) {
					ci--;
				}
				ri++;
			}
			if(start!=ci) {
				return false;
			}
		}
		
		return true;
	}

}
