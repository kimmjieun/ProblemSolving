import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * sum[i] = i번째까지의 무게합
 * sum[i] + 1 < arr[i]이라면 해당 무게로 만들 수 없는 경우이다.
 * 이를 위해 정렬을 통해 인접한 다음 원소가 만들 수 없는 경우라면 그 다음 경우를 볼 필요 없게 함.
 * */
public class Main {
  public static int N;
  public static int[] arr;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    arr = new int[N];
    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < N; i++){
      arr[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(arr);
    if(arr[0] > 1){
      System.out.println("1");
    }
    else{
      int sum = arr[0];
      for(int i = 1; i < N; i++){
        if(arr[i] > sum + 1){
          break;
        }
        sum += arr[i];
      }
      System.out.println(sum + 1);
    }
  }
}
