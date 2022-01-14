import java.io.*;
import java.util.*;
public class Main {
  public static int N;
  public static char[][] arr;
  public static int[] dr = {1, 0, -1, 0};
  public static int[] dc = {0, 1, 0, -1};
  public static boolean success = false;
  public static boolean isRange(int r, int c){
    return 0 <= r && 0 <= c && r < N && c < N;
  }
  //학생이 한 명이라도 걸리면 true, 아니면 false
  public static boolean watching(int r, int c){
    int range, nr, nc;
    for(int k = 0; k < 4; k++){
      range = 1;
      nr = r + dr[k] * range; nc = c + dc[k] * range;
      while(isRange(nr, nc)){
        if(arr[nr][nc] == 'V'){
          break;
        }
        else if(arr[nr][nc] == 'S'){
          return true;
        }
        range++;
        nr = r + dr[k] * range; nc = c + dc[k] * range;
      }
    }
    return false;
  }
  public static boolean isValid(){
    //감시를 진행하는 함수, 학생이 한 명이라도 겹치면 실패
    for(int r = 0; r < N; r++){
      for(int c = 0; c < N; c++){
        if(arr[r][c] == 'T'){
          //4방향으로 감시 진행
          if(watching(r, c)){
            return false;
          }
        }
      }
    }
    return true;
  }
  public static void recur(int row, int col, int cnt){
    //(row, col)좌표에 cnt가 3개가 될 때가지 놓음
    //3개가 되면 유효한지 검사하는 함수 실행
    if(cnt == 3){
      if(isValid()){
        success = true;
      }
      return;
    }
    int c = col;
    for(int r = row; r < N; r++){
      for(; c < N; c++){
        if(arr[r][c] == 'X'){
          arr[r][c] = 'V';
          recur(r, c, cnt + 1);
          arr[r][c] = 'X';
        }
      }
      c = 0;
    }
  }
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    arr = new char[N][N];
    for(int i = 0; i < N; i++){
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < N; j++){
        arr[i][j] = st.nextToken().charAt(0);
      }
    }
    recur(0, 0, 0);
    if(success){
      System.out.println("YES");
    }
    else{
      System.out.println("NO");
    }
  }
}
