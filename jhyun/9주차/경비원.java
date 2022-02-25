import java.io.*;
import java.util.*;

public class Main {
  static int W, H, SHOP;
  static int dir, dist;
  //블록의 왼쪽 최상단의 좌표를 (0, 0)으로 하여 시계방향으로 회전한 거리(절대 거리)
  static int getAbsDist(int dir, int dist){
    if(dir == 1)
      return dist;
    if(dir == 2)
      return W + H + W - dist;
    if(dir == 3)
      return W + H + W + H - dist;
    else
      return W + dist;
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    W = Integer.parseInt(st.nextToken()); H = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    SHOP = Integer.parseInt(st.nextToken());
    List<Integer> course = new ArrayList<>();
    for(int i = 0; i <= SHOP; i++){
      st = new StringTokenizer(br.readLine());
      dir = Integer.parseInt(st.nextToken());
      dist = Integer.parseInt(st.nextToken());
      course.add(getAbsDist(dir, dist));
    }
    int answer = 0;
    for(int i = 0; i < course.size(); i++){
      int clock = Math.abs(course.get(SHOP) - course.get(i));
      int counterClock = 2 * (W + H) - clock;
      answer += Math.min(clock, counterClock);
    }
    System.out.println(answer);
  }
}