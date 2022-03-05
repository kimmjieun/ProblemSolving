class Solution {
  static int Target, answer = 0;
  public static void bf(int idx, int[] numbers, int sum){
    if(idx == numbers.length){
      if(sum == Target){
        answer++;
      }
      return;
    }
    bf(idx + 1, numbers, sum + numbers[idx]);
    bf(idx + 1, numbers, sum - numbers[idx]);
  }
  public static int solution(int[] numbers, int target) {
    Target = target;
    bf(0, numbers, 0);
    return answer;
  }
}