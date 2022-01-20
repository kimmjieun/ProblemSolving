# 1월 둘째주



###  Lv 1. 신고 결과 받기

https://programmers.co.kr/learn/courses/30/lessons/92334

> 점수 100점

자료구조로 풀 수 있던 문제 

Map<String, HashSet> 구조로 푸는게 포인트인듯 하다 



### Lv 2. k진수에서 소수 개수 구하기

https://www.acmicpc.net/problem/17406

> 실행시간 276ms





### Lv 2. 양궁대회

https://programmers.co.kr/learn/courses/30/lessons/92342

> 실행시간 1160ms





### Lv 3. 양과 늑대

https://programmers.co.kr/learn/courses/30/lessons/92343

> 실행시간 132ms





### Lv 3. 파괴되지 않은 건물

https://programmers.co.kr/learn/courses/30/lessons/92344

> 점수 100점

3중 반복문으로 작성하면 효율성테스트에서 0점을 받게 된다 => O(n^3) 

imos 알고리즘을 이해하고 풀면 2중 반복문으로 풀 수 있다 => O(n^2)

가장자리만 찍어주고 페인트 칠하듯이 가로한번 세로한번 쓱 지나가면 누적합이 생긴다 

**imos 배열의 사이즈는 행과열이 기존보다 +1씩 커야한다 가장자리를 찍어야하기 때문이다**

1. 가장자리를 찍는다 
   - 시작점(r1,c1), 끝점의대각선좌표(r2+1,c1+1) ==> 동일한 값
   - 행의 끝점(r2+1,c1) , 열의 끝점 (r1,c2+1) ==> 반대값 // 이후 인덱스부터 해당 값들이 없어져야 하므로

2. 시작 열 = 1 , 이전 열과 현재 열을 더한다 (누적합)
3. 시작 행 =1 ,이전 행과 현재 행을 더한다 (누적합)

