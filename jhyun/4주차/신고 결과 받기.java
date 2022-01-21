import java.util.stream.Collectors;
import java.util.*;
class Solution {
  public static Set<String> reports = new HashSet<>();
  public static HashMap<String, Integer> m = new HashMap<>();
  public static HashMap<String, Integer> result = new HashMap<>();
  public int[] solution(String[] id_list, String[] report, int k) {
    int[] answer = new int[id_list.length];
    reports = Arrays.stream(report).collect(Collectors.toSet());
    reports.stream().forEach(t -> {
      String[] names = t.split(" ");
      m.put(names[1], m.getOrDefault(names[1], 0) + 1);
    });
    reports.stream().map(s -> s.split(" "))
        .filter(names -> m.getOrDefault(names[1], 0) >= k)
        .forEach(r -> result.put(r[0], result.getOrDefault(r[0], 0) + 1));
        /*
        둘 다 똑같지만 스트림이 더 속도가 느림 (약 1ms정도)
        for(String temp : reports){
            String[] names = temp.split(" ");
            if(m.getOrDefault(names[1], 0) >= k){
                result.put(names[0], result.getOrDefault(names[0], 0) + 1);
            }
        }*/
    for(int i = 0; i < id_list.length; i++){
      answer[i] = result.getOrDefault(id_list[i], 0);
    }
    return answer;
  }
}