import java.io.*;
import java.util.*;

public class Main {

  static final int MAX_SIZE = 50;
  static int cntA = 0, cntB = 0, cntC = 0;
  static char[] arr = new char[MAX_SIZE];
  static boolean dp[][][][][][] = new boolean[MAX_SIZE][MAX_SIZE][MAX_SIZE][MAX_SIZE][4][4];

  static boolean recur(int idx, int a, int b, int c, int before, int before2) {
    //모든 순열을 다 조합함.
    if (a == 0 && b == 0 && c == 0) {
      return true;
    }
    //이미 조합한건 또 할 필요 없음.
    if (dp[idx][a][b][c][before][before2]) {
      return false;
    }
    dp[idx][a][b][c][before][before2] = true;
    if (a > 0) { //이전 기록이 A라면
      arr[idx] = 'A';
      if (recur(idx + 1, a - 1, b, c, 0, before)) {
        return true;
      }
    }
    if (b > 0 && before != 1) { //이전 기록이 B가 아니라면
      arr[idx] = 'B';
      if (recur(idx + 1, a, b - 1, c, 1, before)) {
        return true;
      }
    }
    if (c > 0 && before != 2 && before2 != 2) { //전기록, 전전기록이 C가 아니라면
      arr[idx] = 'C';
      if (recur(idx + 1, a, b, c - 1, 2, before)) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == 'A') {
        cntA++;
      } else if (str.charAt(i) == 'B') {
        cntB++;
      } else if (str.charAt(i) == 'C') {
        cntC++;
      }
    }
    StringBuilder sb = new StringBuilder();
    if (recur(0, cntA, cntB, cntC, 0, 0)) {
      for (int i = 0; i < str.length(); i++) {
        sb.append(arr[i]);
      }
      System.out.println(sb);
    } else {
      System.out.println("-1");
    }
  }
}