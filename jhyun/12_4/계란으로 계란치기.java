import java.io.*;
import java.util.*;

public class Main {
  public static int N, answer = 0;
  public static int[] W, S;
  public static void recur(int idx){
    if(idx == N){
      int cnt = 0;
      for(int i = 0; i < N; i++){
        if(S[i] <= 0) cnt++;
      }
      answer = Math.max(answer, cnt);
      return;
    }
    if(S[idx] <= 0){
      recur(idx + 1);
    }
    //현재 계란의 내구도가 0보다 크다면
    else{
      boolean isBroken = false;
      //왼쪽부터 순서대로 탐색
      for(int i = 0; i < N; i++){
        if(idx == i || S[i] <= 0)
          continue;
        //부딪힌 계란이라면, 상태를 기억하기 위해 재귀 호출
        isBroken = true;
        S[i] -= W[idx];
        S[idx] -= W[i];
        recur(idx + 1);
        S[i] += W[idx];
        S[idx] += W[i];
      }
      //부딪힐 계란이 없다면 오른쪽으로 넘어감
      if(isBroken == false)
        recur(idx + 1);
    }
  }
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    W = new int[N]; S = new int[N];
    for(int i = 0; i < N; i++){
      st = new StringTokenizer(br.readLine());
      S[i] = Integer.parseInt(st.nextToken());
      W[i] = Integer.parseInt(st.nextToken());
    }
    recur(0);
    System.out.println(answer);
  }
}