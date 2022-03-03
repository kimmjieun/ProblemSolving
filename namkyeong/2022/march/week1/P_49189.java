package march.week1;

import java.util.*;
public class P_49189 {
    public static int solution(int n, int[][] edge) {
        int answer = 0;
        ArrayList<ArrayList<Integer>> list= new ArrayList<>();
        boolean visited[]= new boolean[n+1];

        for(int i=0; i<=n; i++){
            list.add(new ArrayList<>());
        }
        // 입력받은 edge 저장
        for(int i=0; i<edge.length; i++){
            list.get(edge[i][0]).add(edge[i][1]);
            list.get(edge[i][1]).add(edge[i][0]);
        }
        //정렬
        for(int i=1; i<=n; i++) {
            Collections.sort(list.get(i));
        }

        //bfs
        Queue<Integer> queue= new LinkedList<>();
        //시작시점
        queue.offer(1);
        visited[1]=true;
        int que_size, node;
        //제일 마지막 큐 사이즈로 return 하기.
        while(!queue.isEmpty()){
            que_size= queue.size();
            for(int i=0; i<que_size; i++){
                node= queue.poll();
                for(int j=0; j<list.get(node).size(); j++){
                    if(visited[list.get(node).get(j)]==false){
                        visited[list.get(node).get(j)]=true;
                        queue.add(list.get(node).get(j));
                    }
                }
            }
            answer=que_size;
        }
        return answer;
    }

    public static void main(String[] args) {
        int arr[][] = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        int solution = solution(6, arr);
        System.out.println(solution);
    }
}