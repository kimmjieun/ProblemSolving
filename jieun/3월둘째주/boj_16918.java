import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_16918 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        char[][] map = new char[r][c];
        int[][] bombtime = new int[r][c];
        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'O') {
                    bombtime[i][j] = 3; // 폭탄 터질 시간 (놓인시간 +3)
                }
            }
        }

        int time = 0;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (time++ < n) {
            if (time % 2 == 0) {
                // 비어있는 모든 칸에 폭탄을 설치
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        if (map[i][j] == '.') {
                            map[i][j] = 'O';
                            bombtime[i][j] = time + 3;
                        }
                    }
                }
            } else{
                // 시간이 다된 폭탄 터트림
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        if (bombtime[i][j] == time) {
                            map[i][j] = '.';
                            for (int d = 0; d < 4; d++) {
                                int nx = i + dx[d];
                                int ny = j + dy[d];

                                if (nx < 0 || ny < 0 || nx >= r || ny >= c) continue;

                                // 이번에 터뜨려야할 폭탄을 연쇄반응으로 미리 터뜨리게 되면
                                // 미리 터뜨린 폭탄의 주변 폭탄을 연쇄시킬 수 없다. 그래서 bomtime을 확인
                                if (map[nx][ny] == 'O' && bombtime[nx][ny] != time) {
                                    map[nx][ny] = '.';
                                    bombtime[nx][ny] = 0;
                                }
                            }
                        }
                    }
                }
            }

        }
        for (int i = 0; i < r; i++) {
            System.out.println(map[i]);
        }

    }
}
