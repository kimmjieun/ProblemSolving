import java.io.*;
import java.util.*;
class Node{
  int r, c, d;
  public Node(int r, int c, int d){
    this.r = r;
    this.c = c;
    this.d = d;
  }
}
public class Main {
  public static int N;
  public static char[][] arr;
  public static int[][][] visit;
  public static Node Start, End;
  public static int Dir[][] = {{1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, 1}};
  public static void init(){
    for(int i = 1; i <= N; i++){
      for(int j = 1; j <= N; j++){
        if(arr[i][j] == 'B'){
          if(arr[i - 1][j] == 'B' && arr[i + 1][j] == 'B')
            Start = new Node(i, j, 1);
          else if(arr[i][j - 1] == 'B' && arr[i][j + 1] == 'B')
            Start = new Node(i, j, 0);
        }
        else if(arr[i][j] == 'E'){
          if(arr[i - 1][j] == 'E' && arr[i + 1][j] == 'E')
            End = new Node(i, j, 1);
          else if(arr[i][j - 1] == 'E' && arr[i][j + 1] == 'E')
            End = new Node(i, j, 0);
        }
      }
    }
  }
  public static boolean canRotate(int r, int c){
    boolean tree = false;
    for(int i = -1; i <= 1; i++){
      for(int j = -1; j <= 1; j++){
        if(arr[r + i][c + j] == '1'){
          tree = true;
        }
      }
    }
    return tree == false;
  }
  public static boolean canShift(int r, int c, int d){
    boolean tree = false;
    //밀었을 때 나무가 하나라도 있으면 실패
    if(d == 0){ //가로
      for(int i = -1; i <= 1; i++){
        if(arr[r][c + i] == '1') {
          tree = true;
        }
      }
    }
    else{ //세로
      for(int i = -1; i <= 1; i++){
        if(arr[r + i][c] == '1'){
          tree = true;
        }
      }
    }
    return tree == false;
  }
  public static void bfs(){
    Queue<Node> q = new ArrayDeque<>();
    q.add(Start);
    int nr, nc, nd;
    while(!q.isEmpty()){
      Node cur = q.poll();
      //5방향 탐색 (상, 하, 좌, 우, 회전)
      for(int i = 0; i < Dir.length; i++){
        nr = cur.r + Dir[i][0];
        nc = cur.c + Dir[i][1];
        nd = (cur.d + Dir[i][2]) % 2; //방향 전환
        //범위 초과
        if(nr <= 0 || nc <= 0 || nr > N || nc > N)
          continue;
          //회전이 가능한지 체크
        else if(cur.d != nd && !canRotate(nr, nc))
          continue;
          //이동이 가능한지 체크
        else if(!canShift(nr, nc, nd))
          continue;

        if(visit[nr][nc][nd] == 0){
          visit[nr][nc][nd] += visit[cur.r][cur.c][cur.d] + 1;
          q.add(new Node(nr, nc, nd));
        }
      }
    }
  }
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    arr = new char[N + 2][N + 2];
    visit = new int[N + 2][N + 2][2];
    for(int i = 0; i <= N + 1; i++)
      for(int j = 0; j <= N + 1; j++)
        arr[i][j] = '1';
    for(int i = 1; i <= N; i++){
      String str = br.readLine();
      for(int j = 0; j < N; j++){
        arr[i][j + 1] = str.charAt(j);
      }
    }
    init();
    bfs();
    System.out.println(visit[End.r][End.c][End.d]);
  }
}