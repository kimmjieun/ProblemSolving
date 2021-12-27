import java.io.*;
import java.util.*;
class Node{
  int x, y;
  public Node(int x, int y){
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

  @Override
  public String toString() {
    return "Node{" +
        "x=" + x +
        ", y=" + y +
        '}';
  }
}
public class Main {
  public static int MAX_DIST = 1000;
  public static int STORE;
  public static Node Start, End;
  public static HashMap<Node, Boolean> visit;
  public static void bfs(){
    Queue<Node> q = new ArrayDeque<>();
    q.add(Start);
    visit.put(Start, true);
    while(!q.isEmpty()){
      Node cur = q.poll();
      for(Node next : visit.keySet()){
        if(next == cur)
          continue;
        int x_dist = Math.abs(cur.x - next.x);
        int y_dist = Math.abs(cur.y - next.y);
        if(visit.get(next) == false &&
            x_dist + y_dist <= MAX_DIST){
          visit.put(next, true);
          q.add(next);
        }
      }
    }
  }
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int T = Integer.parseInt(st.nextToken());
    while(T != 0){
      visit = new HashMap<>();
      st = new StringTokenizer(br.readLine());
      STORE = Integer.parseInt(st.nextToken());

      st = new StringTokenizer(br.readLine());
      Start = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
      visit.put(Start, false);

      for(int i = 0; i < STORE; i++){
        st = new StringTokenizer(br.readLine());
        Node n = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        visit.put(n, false);
      }

      st = new StringTokenizer(br.readLine());
      End = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
      visit.put(End, false);
      //bfs
      bfs();
      if (visit.get(End) == false)
        System.out.println("sad");
      else
        System.out.println("happy");
      T--;
    }
  }
}