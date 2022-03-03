import java.util.*;

public class pgm_여행경로 {
    boolean[] ticketUsed; // 방문 여부 체크하는  배열
    ArrayList<String> result; // 티켓을 사용하는 경로의 경우의 수

    public String[] solution(String[][] tickets) {
        ticketUsed = new boolean[tickets.length];
        result = new ArrayList<>();
        dfs("ICN", "ICN", 0, tickets);

        // 답들중 가장 알파벳순이 빠른 배열들로 정렬
        Collections.sort(result);

        // 첫번째 경로를 잘라서 리턴
        return result.get(0).split(" ");
    }

    public void dfs(String now, String nodes, int count, String[][] tickets) {
        // 사용한 티켓의 수가 전체 티켓의 수와 같아진 경우 = 모든 공항을 들렸다면
        if (count == tickets.length) {
            result.add(nodes);
            return;
        }

        // 티켓 배열 순회
        for (int i = 0; i < tickets.length; i++) {
            // 티켓 아직 사용하지 않았고 해당 티켓의 출발지가 현재 위치와 같은 경우
            if (!ticketUsed[i] && tickets[i][0].equals(now)) {
                // 티켓 사용하고 이동
                ticketUsed[i] = true;
                dfs(tickets[i][1], nodes + " " + tickets[i][1], count + 1, tickets);
                ticketUsed[i] = false;
            }
        }
    }
}
