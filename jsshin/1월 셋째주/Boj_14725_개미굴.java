package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj_14725_개미굴 {
	
	static class Node implements Comparable<Node> {
		String data;
		LinkedList<Node> childNode;
		Node(String data, LinkedList<Node> childNode){
			this.data = data;
			this.childNode=  childNode;
		}
		
		@Override
		public int compareTo(Node n) {
			return this.data.compareTo(n.data);
		}
		
		
	}

	static String floor[];
	static StringBuilder answer = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Node head = new Node(null,new LinkedList<Node>());
		while(N-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			floor = new String[K];
			
			for(int i=0;i<K;i++) {
				floor[i] = st.nextToken();
			}
			
			_addNode(head.childNode,0);
			
		}
		_dfs(head.childNode,0);
		System.out.println(answer.toString());
	}
	
	private static void _dfs(LinkedList<Node> childNode, int level) {
		
		Collections.sort(childNode);
		
		StringBuilder line = new StringBuilder();
		for(int i=0;i<level;i++) {
			line.append("--");
		}
		
		for(Node c : childNode) {
			answer.append(line).append(c.data).append("\n");
			_dfs(c.childNode, level+1);
		}
	}

	private static Node _addNode(LinkedList<Node> childNode, int idx) {
		
		for(Node c : childNode) {
			String data = c.data;
			if(data.equals(floor[idx])) {

				// 아래 로직을 타면 안되므로 return을 해줘야한다 
				// 안그러면 중복으로 값이 계속 들어간다 
				return _addNode(c.childNode,idx+1);
			}
		}
		
		childNode.add(new Node(floor[idx],new LinkedList<Node>()));
		if((++idx)<floor.length) {
			//최근에 더한 자식노드로 들어가야함
			_addNode(childNode.get(childNode.size()-1).childNode,idx);
		}
		
		return null;
	}

}
