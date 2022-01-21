package week3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.StringTokenizer;

public class Pgm_신고결과받기 {

	public static void main(String[] args) {
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
//		String[] id_list = {"con", "ryan"};
//		String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
		int k=2;
		solution(id_list,report,k);
	}
	
	public static int[] solution(String[] id_list, String[] report, int k) {
		// 유저 수만큼 answer 배열 할당
        int[] answer = new int[id_list.length];
        
        // key = 신고당한유저 , value = 신고한 유저
        Map<String, HashSet<String>> idReportMap = new HashMap<String, HashSet<String>>();
 
        for(String r: report) {
        	StringTokenizer st = new StringTokenizer(r);
        	String user = st.nextToken();
        	String reportedUser = st.nextToken();
        	
        	// 신고한 유저들이 중복이 들어가면 안되므로 Set으로 자료구조를 정함
        	HashSet<String> userSet = new HashSet<>();
        	if(idReportMap.get(reportedUser) == null) {
        		// 신고한 유저가 없을 경우 새로운 set에 값을 넣는다
        		userSet.add(user);
        	}else {
        		// 이전에 신고한 유저가 있을 경우 기존 set에다가 값을 넣는다
        		userSet = idReportMap.get(reportedUser);
        		userSet.add(user);
        	}
        	idReportMap.put(reportedUser, userSet);
        }
        
        // 각 유저가 받은 메일 수를 넣기위해 유저별 인덱스를 세팅한다 
        // 찾기 쉽게 MAP으로 설정
        Map<String, Integer> idMap = new HashMap<String, Integer>();
        for(int i=0;i<id_list.length;i++) {
        	idMap.put(id_list[i], i);
        }
        
        // 발송한 메일수를 넣기 위해 
        for(String reportedUser :idReportMap.keySet()){
        	
        	HashSet<String> reportUsers = idReportMap.get(reportedUser);
        	// k개 미만으로 신고당한경우는 넘어간다
        	if(k>reportUsers.size()) continue;
        	
        	// 유저별 인덱스 세팅을 했으므로 해당 Map에서 user의 인덱스를 찾아 발송 메일 수를 늘린다
        	for(String reportUser : reportUsers) {
        		answer[idMap.get(reportUser)]++;
        	}
        	
        }
        
//        System.out.println(Arrays.toString(answer));
        return answer;
    }

}
