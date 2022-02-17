import java.io.*;
import java.util.*;
/*
스택을 사용해야 하는건 알았지만 후위 표기식 구현이 미숙해서
정답을 참고했음..
* */
public class Main {

  static char[] buf;
  static StringBuilder answer = new StringBuilder();
  public static int precedence(char op) {
    if(op == '*' || op == '/') return 2;
    else if(op == '+' || op == '-') return 1;
    else return 0; //스택 안에는 '('도 들어올 수 있다. 하지만 '('는 꺼내져서는 안되기 때문에 제일 낮은 값을 반환하도록 한다.
  }
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    buf = br.readLine().toCharArray();
    Stack<Character> op = new Stack<>();

    for (int i = 0; i < buf.length; i++) {
      char ch = buf[i];
      if('A' <= ch && ch <= 'Z') {
        answer.append(ch);
      }
      else{
        if(ch == '(') {
          op.push(ch);
        }
        else if(ch == ')'){
          while(!op.isEmpty() && op.peek() != '('){
            answer.append(op.pop());
          }
          op.pop();
        }
        else{
          while(!op.isEmpty() && precedence(op.peek()) >= precedence(ch)){
            answer.append(op.pop());
          }
          op.push(ch);
        }
      }
    }
    while(!op.isEmpty()){
      answer.append(op.pop());
    }
    System.out.println(answer);
  }
}
