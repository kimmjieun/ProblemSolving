public class pgm_단어변환 {
    int answer = 0;
    boolean[] visited;

    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        dfs(begin, target, words, 0);

        return answer;
    }

    public void dfs(String begin, String target, String[] words, int cnt) {
        if (begin.equals(target)) {
            answer = cnt;
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (visited[i]) {
                continue;
            }

            int check = 0;
            for (int j = 0; j < begin.length(); j++) {
                if (begin.charAt(j) == words[i].charAt(j)) {
                    check++;
                }
            }

            if (check == begin.length() - 1) {
                visited[i] = true;
                dfs(words[i], target, words, cnt + 1);
                visited[i] = false;
            }
        }
    }
}
