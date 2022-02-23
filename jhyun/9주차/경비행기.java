import java.io.*;
import java.util.*;
public class Main {
  static class Node{
    int x, y;

    public Node(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Node node = (Node) o;
      return x == node.x && y == node.y;
    }

    @Override
    public int hashCode() {
      return Objects.hash(x, y);
    }
  }
  static int N, K, answer = 0;
  static int MAX_FUEL;
  static HashMap<Node, Integer> visit = new HashMap<>();
  static final Node Goal = new Node(10000, 10000);
  static final Node Start = new Node(0, 0);

  static double getDist(int x1, int y1, int x2, int y2){
    return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
  }
  static int getFuel(double dist){
    int temp = (int) dist + 10;
    return temp / 10;
  }
  static boolean isPossible(int fuel) {
    Queue<Node> q = new ArrayDeque<>();
    Node Start = new Node(0, 0);
    q.add(Start);
    while (!q.isEmpty()) {
      Node cur = q.poll();
      if(cur == Goal){
        return visit.get(Goal) != 0 && visit.get(Goal) - 1 <= K;
      }
      for (Node next : visit.keySet()) {
        if (visit.get(next) == 0 &&
            getFuel(getDist(cur.x, cur.y, next.x, next.y)) <= fuel) {
          if(!Start.equals(next)){
            visit.put(next, visit.get(cur) + 1);
            q.add(next);
          }
        }
      }
    }
    return visit.get(Goal) != 0 && visit.get(Goal) - 1 <= K;
  }
  static void setting(){
    for(Node key : visit.keySet())
      visit.put(key, 0);
  }
  static void binSearch(){
    int st = 1, en = MAX_FUEL, mid;
    while(st <= en){
      mid = (st + en) / 2;
      if(isPossible(mid)){
        en = mid - 1;
        answer = mid;
      }
      else{
        st = mid + 1;
      }
      setting();
    }
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken()); K = Integer.parseInt(st.nextToken());
    MAX_FUEL = getFuel(getDist(0, 0, 10000, 10000));
    for(int i = 0; i < N; i++){
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      visit.put(new Node(x, y), 0);
    }
    visit.put(Start, 0);
    visit.put(Goal, 0);
    binSearch();
    System.out.println(answer);
  }
}