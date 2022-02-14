# 2월 첫째주



###  <img src ="https://d2gd6pc034wcta.cloudfront.net/tier/11.svg" width="25"> 정보상인호석 (22-02-08 AC)

https://www.acmicpc.net/problem/22252

> 실행시간 1360ms



Map<String,PriorityQueye> 구현문제였다. 이때 우선순위큐는 내림차순이어야한다



### <img src ="https://d2gd6pc034wcta.cloudfront.net/tier/13.svg" width="25"> 계보 복원가 호석(22-02-10 AC)

https://www.acmicpc.net/problem/21276

> 실행시간 952ms

위상정렬에 대해 알 수 있었던 문제였다. 위상정렬에 대해 찾아보고 소스코드를 이해하여 활용하면 쉽게 문제를 풀 수 있다

정보상인호석의 유형 (TreeMap사용) + 위상정렬 구현문제였다

사전순으로 사람의 이름을 출력해야했기에 TreeMap을 사용했다 

**부모-자식 관계이 아닌 자손은 리스트에서 삭제를 해줘야했기때문에 <u>Iterator</u>을 사용했다**



### <img src ="https://d2gd6pc034wcta.cloudfront.net/tier/11.svg" width="25"> 홀수 홀릭 호석(22-02-11 AC)

https://www.acmicpc.net/problem/20164

> 실행시간 160ms

부분통과

조합(백트래킹) + 재귀 문제였다 

숫자가 3자리 이상일경우 끊을 수 있는 구간이 2개가 생기므로 조합 배열의 크기를 2로 잡았다

숫자를 계속 더하므로 3자리 이상이 여러번 나올 수있으므로 prcoess 와 combination 함수가 계속 왔다갔다한다 

스택에 메소드가 쌓이므로 백트래킹을 위해서 더한 홀수의 값을 return 전에 빼준다





