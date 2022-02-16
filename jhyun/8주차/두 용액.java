import java.io.*;
import java.util.*;
/*
정렬을 하는 이유: 모든 경우의 수를 탐색하면 100000!이기 때문
투포인터를 사용하는 이유: 정렬해놓았기 때문에,
합이 0보다 크면 오른쪽의 범위를, 작으면 왼쪽의 범위를 줄일 수 있기 때문
* */
public class Main {
  static int N;
  static int[] arr;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    arr = new int[N];
    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < N; i++){
      arr[i] = Integer.parseInt(st.nextToken());
    }
    //nlgn
    Arrays.sort(arr);
    List<Integer> answer = null;
    int s = 0, e = arr.length - 1, lecord = Math.abs(arr[e] + arr[s]) + 1;
    int sum;
    while(s < e){
      sum = arr[s] + arr[e];
      if(lecord > Math.abs(sum)){
        answer = List.of(arr[s], arr[e]);
        lecord = Math.abs(sum);
      }
      if(sum > 0){
        e--;
      }
      else if(sum < 0){
        s++;
      }
      else{
        answer = List.of(arr[s], arr[e]);
        break;
      }
    }
    System.out.println(String.format("%d %d", answer.get(0), answer.get(1)));
  }
}
