package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_17144 {

	static int R,C,T;
	static int[][] board, copyboard;
	static int[][] air = new int[2][2];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		board = new int[R][C];
		
		int airIdx=0;
		
		for(int i=0;i<R;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<C;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j]==-1) {
					air[airIdx][0]=i;
					air[airIdx++][1]=j;
				}
			}
		}
		
		while(T-->0) {
			copyboard = new int[R][C];
			spread();
			rotate();
			board[air[0][0]][air[0][1]]=-1;
			board[air[1][0]][air[1][1]]=-1;
		}
		System.out.println(count());
		
	}
	
	private static int count() {
		int sum=0;
		for(int i=0;i<R;i++) {
//			System.out.println(Arrays.toString(board[i]));
			for(int j=0;j<C;j++) {
				if(board[i][j]>0) 
					sum+=board[i][j];
			}
		}
		return sum;
	}

	private static void rotate() {
		int minR=0,minC=0;
		int maxR=air[0][0],maxC=C-1;
		int dr=air[0][0];
		int dc=air[0][1];
		int tmp = board[dr][dc];
		
		for(int i=dr;i>minR;i--) {
			board[i][dc]=board[i-1][dc];
		}
		dr=0;
		for(int i=dc;i<maxC;i++) {
			board[dr][i]=board[dr][i+1];
		}
		dc=maxC;
		for(int i=dr;i<maxR;i++) {
			board[i][dc]=board[i+1][dc];
		}
		dr=maxR;
		for(int i=dc;i>minC+1;i--) {
			board[dr][i]=board[dr][i-1];
		}
		board[dr][1]=0;
		//위의 공기청정기
		
		//아래의 공기청정기
		minR=air[1][0]; minC=air[1][1];
		maxR=R-1; maxC=C-1;
		dr=air[1][0];
		dc=air[1][1];
		tmp = board[dr][dc];
		
		for(int i=dr;i<maxR;i++) {
			board[i][dc]=board[i+1][dc];
		}
		dr=maxR;
		for(int i=dc;i<maxC;i++) {
			board[dr][i]=board[dr][i+1];
		}
		dc=maxC;
		for(int i=dr;i>minR;i--) {
			board[i][dc]=board[i-1][dc];
		}
		dr=minR;
		for(int i=dc;i>minC+1;i--) {
			board[dr][i]=board[dr][i-1];
		}
		board[dr][1]=0;
		
		
	}

	static int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};
	private static void spread() {
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {		
				//미세먼지가 있을 경우
				if(board[i][j]>0 ) {
					int divide = board[i][j]/5;
					if(divide!=0) {						
						for(int k=0;k<4;k++) {
							int dr = i+dirs[k][0];
							int dc = j+dirs[k][1];
							if(dr<0 || dc<0 || dr>=R || dc>=C) continue;
							if(board[dr][dc]==-1) continue;
							copyboard[dr][dc]+=divide;
							board[i][j]-=divide;
						}
					}
					copyboard[i][j] += board[i][j];
				}
			}
		}
		
		for(int i=0;i<R;i++) {
			board[i]=copyboard[i].clone();
		}
		
	}

}