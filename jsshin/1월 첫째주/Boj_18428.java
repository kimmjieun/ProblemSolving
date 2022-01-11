package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_18428 {

	static class Point{
		int x;
		int y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	static int N;
	static char[][] board;
	static List<Point> tList = new ArrayList<Point>();
	static int[]dx = {0,0,-1,1};
	static int[]dy = {1,-1,0,0};
	public static void main(String[] args) throws IOException{
		
		_setData();
		_combination(0,0);
		System.out.println("NO");
	}
	
	private static void _setData() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new char[N][N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++) {
				board[i][j]=st.nextToken().charAt(0);

				// 선생님 위치 list에 넣기
				if(board[i][j]=='T') {
					tList.add(new Point(i,j));
				}
			}
		}
	}
	
	private static void _combination(int cnt, int idx) {
		// 방해물 3개 격자에 채우기
		if(cnt==3) {
			
			// 선생님의 감시
			if(!_isTeacherWatching()) {
				System.out.println("YES");
				System.exit(0);
			}
			return;
		}
		
		int r = idx/N;
		int c = idx%N;
		
		if(idx>=N*N) return;
		
		if(board[r][c]=='X') {
			board[r][c]='O';
			_combination(cnt+1, idx+1);
			board[r][c]='X'; // 백트래킹, 원복
		}
		
		_combination(cnt, idx+1);
		
	}

	private static boolean _isTeacherWatching() {
		for(Point teacher : tList) {
			
			for(int dir=0;dir<4;dir++)
			{
				int xi = teacher.x;
				int yi = teacher.y;
				
				while(_isInRange(xi,yi)) {
					
					if(board[xi][yi]=='S') {
						return true;
					} else if(board[xi][yi]=='O') {
						break;
					}
					
					// 상하좌우
					xi +=dx[dir];
					yi +=dy[dir];
				}
				
			}
		}
		
		return false;
	}

	private static boolean _isInRange(int xi, int yi) {
		return xi>-1 && xi<N && yi>-1 && yi<N ;
	}


}
