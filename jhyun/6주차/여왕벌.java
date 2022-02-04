import java.io.*;
import java.util.*;

public class Main {
  static int N, M;
  static int[] arr;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    arr = new int[2 * M - 1];
    //누적합 계산
    int zero, one, two;
    for(int i = 0; i < N; i++){
      st = new StringTokenizer(br.readLine());
      zero = Integer.parseInt(st.nextToken());
      one = Integer.parseInt(st.nextToken());
      for(int j = zero; j < zero + one; j++){
        arr[j]++;
      }
      two = Integer.parseInt(st.nextToken());
      for(int j = zero + one; j < 2 * M - 1; j++){
        arr[j] += 2;
      }
    }
    for(int i = 0; i < M; i++){
      StringBuilder sb = new StringBuilder();
      for(int j = 0; j < M; j++){
        if(j == 0){
          sb.append(arr[M - i - 1] + 1).append(" ");
        }
        else{
          sb.append(arr[M + j - 1] + 1).append(" ");
        }
      }
      System.out.println(sb);
    }
  }
}
