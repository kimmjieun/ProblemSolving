import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_11725 {
    public static void main(String[] args) throws IOException {
        // 인접 리스트
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) // 0부터 초기화 해야함
            list.add(new ArrayList<>());

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list.get(x).add(y);
            list.get(y).add(x);

        }

        boolean[] visit = new boolean[n + 1];
        int[] result = new int[n + 1];

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visit[1] = true;

        while (!q.isEmpty()) {
            int v = q.poll();
            for (int i = 0; i < list.get(v).size(); i++) {
                int tmp = list.get(v).get(i);
                if (!visit[tmp]) {
                    visit[tmp] = true;
                    result[tmp] = v;
                    q.add(tmp);
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            sb.append(result[i] + "\n");
        }
        System.out.println(sb);

        // 인접 행렬
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//        int n = Integer.parseInt(br.readLine());
//
//        int[][] arr = new int[n + 1][n + 1];
//        for (int i = 0; i < n-1; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            int x = Integer.parseInt(st.nextToken());
//            int y = Integer.parseInt(st.nextToken());
//            arr[x][y] = arr[y][x] = 1;
//        }
//
//        boolean[] visit = new boolean[n+1];
//        int[] result = new int[n+1];
//
//        Queue<Integer> q = new LinkedList<>();
//        q.add(1);
//        visit[1]=true;
//
//        while(!q.isEmpty()){
//            int tmp = q.poll();
//            for(int i=1;i<=n;i++){
//                if((arr[tmp][i]==1||arr[i][tmp]==1) && !visit[i]){
//                    q.add(i);
//                    result[i]=tmp;
//                    visit[i]=true;
//                }
//            }
//        }
//        for(int i=2;i<=n;i++){
//            sb.append(result[i]+"\n");
//        }
//        System.out.println(sb);

    }
}
