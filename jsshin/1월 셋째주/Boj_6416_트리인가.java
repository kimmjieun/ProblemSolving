package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj_6416_트리인가 {

	static HashMap<Integer,Integer> Vertex ;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean endFlag = false;
		StringBuilder sb = new StringBuilder();
		int idx = 1;
		
		while(true) {
			Vertex = new HashMap<Integer, Integer>();
			StringTokenizer st = new StringTokenizer(br.readLine(), "  ");
			
			while(true) {
				if(!st.hasMoreTokens()) {
					st = new StringTokenizer(br.readLine(), "  ");
				}

				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());

				if(u==0 && v==0) break;
				if(u==-1 && v==-1) {
					endFlag = true;
					break;
				}
				
				_addNode(u, v);
//				System.out.println(u+" "+v);
			}
			if(endFlag) break;
//			System.out.println("===============");
//			System.out.println("트리검사 시작");
			if(_isTree()) {
				sb.append("Case ").append(idx).append(" is a tree.\n");
			}else {
				sb.append("Case ").append(idx).append(" is not a tree.\n");
			}
			idx++;
		}
		System.out.println(sb);
	}

	private static void _addNode(int u, int v) {
		
		if(Vertex.get(u)==null) Vertex.put(u, 0);
		int cnt = Vertex.get(v)==null? 1: Vertex.get(v)+1;
		Vertex.put(v,cnt);
		
	}

	private static boolean _isTree() {

		int rootCnt = 0;
		int edgeSum = 0;
		for(int key : Vertex.keySet()) {
			if (Vertex.get(key)==0) {
				rootCnt++;
			}else if(Vertex.get(key)>1) {
				// 들어오는 간선이 2개 이상이므로 트리가 아니다
				return false;
			}
			edgeSum += Vertex.get(key);
		}
		// 루트 노드가 1개 이상이므로 트리가 아니다
		if(rootCnt>1) return false;
		
		// 간선+1 != 정점일경우 트리가 아니다 
		if(Vertex.keySet().size()>0 && edgeSum+1!=Vertex.keySet().size()) return false;
		return true;
	}

}
