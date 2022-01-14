package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_17406_배열돌리기4 {

	static int N,M,K,answer;
	static int[][] board, copyBoard, rotateArr ;
	static int[] perm;
	public static void main(String[] args) throws IOException{
		
		answer = Integer.MAX_VALUE;
		_setData();
		_permutation(0,0);
		System.out.println(answer);
		
	}
	
	private static void _setData() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		copyBoard = new int[N][M];
		rotateArr = new int[K][3];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<M;j++) {
				int val = Integer.parseInt(st.nextToken());
				board[i][j] = val;
				
			}
		}
		
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			rotateArr[i][0] = r-1;
			rotateArr[i][1] = c-1;
			rotateArr[i][2] = s;
				
		}
		
		perm = new int[K];
	}
	
	private static void _permutation(int cnt, int flag) {
		if(cnt==K) {
//			System.out.println(Arrays.toString(perm));
			_copyBoard();
			
			// 순열대로 배열 회전
			for(int p:perm) {
				_rotate(p);
			}
			
			// 최솟값을 찾는다
			_findMinSum();
			return;
		}
		
		for(int i=0;i<K;i++) {
			// 이미 방문했다 
			if((flag&1<<i)!=0) continue;
			perm[cnt]=i;
			
			// 방문처리를 한다
			_permutation(cnt+1,(flag|1<<i));
		}
		
	}
	
	private static void _copyBoard() {
		for(int i=0;i<N;i++) {
			copyBoard[i]=board[i].clone();
		}
	}

	private static void _rotate(int p) {
		int r = rotateArr[p][0];
		int c = rotateArr[p][1];
		int s = rotateArr[p][2];
		
		//바깥쪽부터 회전 
		for(int si=s;si>0;si--) {
			int rMin = r-si;
			int cMin = c-si;
			int rMax = r+si;
			int cMax = c+si;
			
			int temp = copyBoard[rMin][cMin];
			
			int ri = rMin;
			int ci = cMin;
			// 하
			while(++ri<=rMax) {
				copyBoard[ri-1][ci] = copyBoard[ri][cMin];
			}
			
			// 우
			ri--;
			while(++ci<=cMax) {
				copyBoard[ri][ci-1] = copyBoard[ri][ci];
			}
			
			// 상
			ci--;
			while(--ri>=rMin) {
				copyBoard[ri+1][ci] = copyBoard[ri][ci];
			}
			
			// 좌
			ri++;
			while(--ci>cMin) {
				copyBoard[ri][ci+1] = copyBoard[ri][ci];
			}
			
			copyBoard[ri][ci+1] = temp;
			
			for(int i=0;i<copyBoard.length;i++) {
				System.out.println(Arrays.toString(copyBoard[i]));
			}
		}
		
	}
	
	private static void _findMinSum() {
		for(int i=0;i<N;i++) {
			int sum=0;
			for(int j=0;j<M;j++) {
				sum+=copyBoard[i][j];
			}
//			System.out.println("sum======="+sum);
			answer = Math.min(answer, sum);
		}
	}


}
