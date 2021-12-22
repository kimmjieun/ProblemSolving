import java.io.*;
import java.util.*;

public class Main {
  public static final int INF = Integer.MAX_VALUE;
  public static int N, M, answer = INF;
  public static char[][] arr;
  public static int[] dirRow = {1, 0, -1, 0};
  public static int[] dirCol = {0, 1, 0, -1};
  public static boolean RangeOver(int r, int c){
    return r < 0 || c < 0 || r >= N || c >= M;
  }
  public static void CoinMove(int r1, int c1, int r2, int c2, int cnt, int dir){
    if(cnt > 10) return; //10번 초과 시 종료

    int nr1 = r1 + dirRow[dir], nc1 = c1 + dirCol[dir];
    int nr2 = r2 + dirRow[dir], nc2 = c2 + dirCol[dir];

    if(RangeOver(nr1, nc1) && RangeOver(nr2, nc2)) return; //두 동전이 모두 떨어지는 경우는 제외
    else if(RangeOver(nr1, nc1)){
      answer = Math.min(answer, cnt);
      return;
    }
    else if(RangeOver(nr2, nc2)){
      answer = Math.min(answer, cnt);
      return;
    }

    if(arr[nr1][nc1] == '#'){
      nr1 = r1;
      nc1 = c1;
    }
    if(arr[nr2][nc2] == '#'){
      nr2 = r2;
      nc2 = c2;
    }
    for(int i = 0; i < 4; i++){
      CoinMove(nr1, nc1, nr2, nc2, cnt + 1, i);
    }
  }
  public static void Solve(int r1, int c1, int r2, int c2){
    for(int i = 0; i < 4; i++){
      CoinMove(r1, c1, r2, c2, 1, i);
    }
  }
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
    arr = new char[N][M];
    int row[] = new int[2], col[] = new int[2], idx = 0;
    for(int i = 0; i < N; i++){
      String str = br.readLine();
      for(int j = 0; j < str.length(); j++) {
        arr[i][j] = str.charAt(j);
        if (arr[i][j] == 'o') {
          row[idx] = i;
          col[idx] = j;
          idx++;
        }
      }
    }
    Solve(row[0], col[0], row[1], col[1]);
    System.out.println(answer == INF ? -1 : answer);
  }
}