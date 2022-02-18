package backTracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 감시피하기_18428 {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sbb = new StringBuilder();

    static void solve() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stt = null;
        
        N = stoi(br.readLine());
        graph = new char[N][N];
        for(int i = 0; i < N; i++) {
            stt = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                char ch = stt.nextToken().charAt(0);
                graph[i][j] = ch;
                
                if(graph[i][j] == 'X') {
                    alX.add(new Pair(i, j));
                } else if(graph[i][j] == 'T') {
                    alT.add(new Pair(i, j));
                }
            }
        }
        
        len = alX.size();
        vis = new boolean[len];
        comb(0);
        
        if(ans) print("YES"); else print("NO");
    }
    
    static int N, len;
    static boolean ans = false;
    static char[][] graph;
    static boolean[] vis;
    
    static List<Pair> alX = new ArrayList<>();
    static List<Pair> alT = new ArrayList<>();
    
    static void comb(int cnt) {
        if(cnt == 3) {
            boolean flag = foo();
            if(flag) ans = true;
            return;
        }
        
        for(int i = 0; i < len; i++) {
            if(vis[i]) continue;
            vis[i] = true;
            Pair p = alX.get(i);
            graph[p.x][p.y] = 'O';
            comb(cnt+1);
            graph[p.x][p.y] = 'X';
            vis[i] = false;
        }
        
    }
    
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    
    static boolean foo() {
        for(int i = 0; i < alT.size(); i++) {
            Pair p = alT.get(i);
            for(int d = 0; d < 4; d++) {
                int nx = p.x;
                int ny = p.y;
                while(true) {
                    nx += dx[d];
                    ny += dy[d];
                    if(isRange(nx, ny) == false) break;
                    if(graph[nx][ny] == 'O' || graph[nx][ny] == 'T') break;
                    if(graph[nx][ny] == 'S') return false;
                    
                }
            }
        }
        return true;
    }
    
    static boolean isRange(int x, int y) { return 0 <= x && x < N && 0 <= y && y < N; }

    
    public static void main(String[] args) throws Exception { solve(); }
    
    static int stoi(String s) { return Integer.parseInt(s); }
    static long stol(String s) { return Long.parseLong(s); }
    static void print(String s) { System.out.println(s); }
    static void print(int opih) { System.out.println(opih); }
    static void print(long opih) { System.out.println(opih); }    
    static void print(StringBuilder sbb) { System.out.println(sbb.toString()); }
    static void print() { System.out.println(); }
}

class Pair {
    int x, y, z, a, b, c;
    
    String s;
    Pair(int x, int y) { this.x = x; this.y = y; }
    Pair(int x, int y, int z) { this.x = x; this.y = y; this.z = z; }
    Pair(int x, int y, int z, int a) { this.x = x; this.y = y; this.z = z; this.a = a; }
    Pair(int x, int y, int z, int a, int b) { this.x = x; this.y = y; this.z = z; this.a = a; this.b = b; }
    Pair(int x, int y, int z, int a, int b, int c) { this.x = x; this.y = y; this.z = z; this.a = a; this.b = b; this.c = c; }
    int getX() { return this.x; } int getY() { return this.y; } int getZ() { return this.z; }
    int getA() { return this.a; } int getB() { return this.b; } int getC() { return this.c; }
    
    String getS() { return this.s; }
}