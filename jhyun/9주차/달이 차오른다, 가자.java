import java.io.*;
import java.util.*;
//1시간 10분
public class Main {
  static int N, M;
  static char[][] arr;
  static int[][][] visit;
  static int[] dr = {1, 0, -1, 0};
  static int[] dc = {0, 1, 0, -1};
  static int answer = Integer.MAX_VALUE;
  static int bitmask(int curStat, char key){
    if(key == 'a'){
      curStat |= 1;
    }
    else if(key == 'b'){
      curStat |= 1 << 1;
    }
    else if(key == 'c'){
      curStat |= 1 << 2;
    }else if(key == 'd'){
      curStat |= 1 << 3;
    }else if(key == 'e'){
      curStat |= 1 << 4;
    }else if(key == 'f'){
      curStat |= 1 << 5;
    }
    return curStat;
  }
  static boolean isRange(int r, int c){
    return 0 <= r && 0 <= c && r < N && c < M;
  }
  static boolean canVisit(int r, int c, int curStat){
    if(arr[r][c] == '#'){
      return false;
    }
    else if('A' <= arr[r][c] && arr[r][c] <= 'F'){
      int needKey = 1 << arr[r][c] - 'A';
      if((needKey & curStat) == 0){
        return false;
      }
    }
    return true;
  }
  static void bfs(int row, int col){
    Queue<int[]> q = new ArrayDeque<>();
    int curStat = 0;
    int r, c, nr, nc, nextStat;
    q.add(new int[]{row, col, curStat});
    while(!q.isEmpty()) {
      int[] tmp = q.poll();
      r = tmp[0];
      c = tmp[1];
      curStat = tmp[2];
      if(arr[r][c] == '1'){
        answer = Math.min(answer, visit[r][c][curStat]);
        continue;
      }
      for(int i = 0; i < 4; i++){
        nr = r + dr[i];
        nc = c + dc[i];
        if(!isRange(nr, nc))
          continue;
        if(canVisit(nr, nc, curStat) &&
            visit[nr][nc][curStat] == 0){
          nextStat = bitmask(curStat, arr[nr][nc]);
          visit[nr][nc][nextStat] = visit[r][c][curStat] + 1;
          visit[nr][nc][curStat] = visit[nr][nc][nextStat];
          q.add(new int[]{nr, nc, nextStat});
        }
      }
    }
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
    visit = new int[N + 1][M + 1][1 << 6];
    arr = new char[N + 1][M + 1];
    int stRow = 0, stCol = 0;
    for(int i = 0; i < N; i++){
      arr[i] = br.readLine().toCharArray();
      for(int j = 0; j < arr[i].length; j++){
        if(arr[i][j] == '0'){
          stRow = i;
          stCol = j;
        }
      }
    }
    bfs(stRow, stCol);
    System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
  }
}