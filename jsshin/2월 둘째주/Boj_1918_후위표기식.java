package feb.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj_1918_후위표기식 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		Stack<Character> oper = new Stack<>();
		
		for(char c : br.readLine().toCharArray()) {
			if(Character.isLetter(c)) {
				answer.append(c);
				
			}else if(c == ')') {
				while(true) {
					char o = oper.pop();
					if(o=='(') {
						break;
					}
					answer.append(o);
				}			
			}else {		
				while(!oper.isEmpty() &&_priority(oper.peek())>=_priority(c) ) {
					answer.append(oper.pop());
				}
				oper.push(c);
			}
		}
		
		while(!oper.isEmpty()) {
			answer.append(oper.pop());
		}
		
		System.out.println(answer);
		
	}
	
	private static int _priority(char c) {
		if(c=='+' || c=='-') return 1;
		else if(c=='*' || c=='/') return 2;
		return 3;
	}
}
