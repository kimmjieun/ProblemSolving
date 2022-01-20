package week3;

import java.util.Arrays;

public class Pgm_파괴되지않은건물 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] board = new int[][]{{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}};
		int[][] skill = new int[][]{{1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1}};
		solution(board,skill);
	}
	
	static int N,M;
	public static int solution(int[][] board, int[][] skill) {
        int answer = 0;
        N = board.length;
        M = board[0].length;
        
        int[][] tmpBoard = new int[N+1][M+1];
        for(int[]s : skill) {
        	int type = s[0];
        	int r1 = s[1];
        	int c1 = s[2];
        	int r2 = s[3];
        	int c2 = s[4];
        	int degree = s[0]==1 ? s[5]*-1 : s[5];
        	
        	tmpBoard[r1][c1] += degree;					// 2차원배열시작
        	tmpBoard[r2+1][c2+1] += degree;				// 2차원배열끝대각선
        	tmpBoard[r2+1][c1] += degree * -1;			// 2차원배열 행끝 (값이달라야한다)
        	tmpBoard[r1][c2+1] += degree * -1;			// 2차원배열 열끝 (값이달라야한다)
        	
        }
        
        for(int ri=0;ri<N+1;ri++) {						//imos 법으로 오른쪽으로 누적합
        	for(int ci=1;ci<M+1;ci++) {
        		tmpBoard[ri][ci]+=tmpBoard[ri][ci-1];
    		}
    	}
        
        for(int ri=1;ri<N+1;ri++) {						//imos 법으로 아래로 누적합
        	for(int ci=0;ci<M+1;ci++) {
        		tmpBoard[ri][ci]+=tmpBoard[ri-1][ci];
    		}
    	}
        
        for(int ri=0;ri<N;ri++) {						//imos법 배열과 합산
        	for(int ci=0;ci<M;ci++) {
        		board[ri][ci]+=tmpBoard[ri][ci];
    		}
    	}
        
        for(int i=0;i<board.length;i++) {
        	System.out.println(Arrays.toString(board[i]));
        }
        answer = _count(board);
        return answer;
    }
	
	private static int _count(int[][] board) {
		int answer = 0;
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[0].length;j++) {
				if(board[i][j]>0) answer++;
			}
		}
		return answer;
	}

}
