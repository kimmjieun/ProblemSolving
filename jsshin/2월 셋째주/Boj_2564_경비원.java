package feb.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2564_경비원 {
	
	static int dongR,dongC,c,r;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		c = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());


		int S = Integer.parseInt(br.readLine());
		int[][] position = new int[S+1][2];

		for(int i=0;i<S+1;i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());
			int dr,dc;
			
			switch (dir) {
			case 1:
				dr = 0;
				dc = distance;
				position[i]=new int[]{dr,dc};  
				break;
			case 2:
				dr = r;
				dc = distance;
				position[i]=new int[]{dr,dc};  
				break;
			case 3:
				dr = distance;
				dc = 0;
				position[i]=new int[]{dr,dc};  
				break;
			case 4:
				dr = distance;
				dc = c;
				position[i]=new int[]{dr,dc};  
				break;
			}
			
		}
		
		dongR = position[S][0];
		dongC = position[S][1];
		
		int answer=0;
		for(int i=0;i<S;i++) {
			answer+=getDistance(position[i]);
		}
		System.out.println(answer);

	}
	private static int getDistance(int[] pos) {
		int diffR = Math.abs(pos[0]-dongR);
		int diffC = Math.abs(pos[1]-dongC);
		int sum = 0;
		int answer = 0;
		if(diffR==r) {
			sum=r+dongC+pos[1];
		}else if(diffC == c) {
			sum=c+dongR+pos[0];
		}else {
			sum=diffR+diffC;
		}
		answer+=Math.min(sum, (r+c)*2-sum);
		return answer;
		
	}
}
