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



### <img src ="https://d2gd6pc034wcta.cloudfront.net/tier/11.svg" width="25"> 개똥벌레 (22-01-25 AC)

https://www.acmicpc.net/problem/3020

> 실행시간 952ms

위상정렬에 대해 알 수 있었던 문제였다

위상정렬을 활용해서 문제를 풀면 쉽게 풀 수 있다 





### <img src ="https://d2gd6pc034wcta.cloudfront.net/tier/14.svg" width="25"> 개미굴 (22-01-27 AC)

https://www.acmicpc.net/problem/14725

> 실행시간 200ms

트리구현 + DFS 문제였다

트리를 구현할 때 이미 부모가 있는 값일 경우 `return 재귀함수` 로 작성해줘야한다

위 부분에서 시간을 많이 잡아먹었다 중복으로 계속 값이 들어갔기 때문이다 

그리고 사전 순으로 조회해야하므로 Comparable를 상속받아서 compareTo를 오버라이딩 해야한다





### <img src ="https://d2gd6pc034wcta.cloudfront.net/tier/15.svg" width="25"> 소수의 곱 (22-01-25 AC)

https://www.acmicpc.net/problem/2014

> 실행시간 272ms

오름차순으로 나타내기 위해 PirorityQueue를 사용했으며 

중복되는 값이 생기면 안되므로 ` if(tmpNum%ni==0) break; `조건문을 넣어줘야했다

소수들을 priorityQueue에 다 넣어주고 하나씩 빼면서 

곱한 값을 넣어주고 빼낸 값이 기존 소수로 나눠떨어지면 더 이상 곱하지 않는다 (다른 수로 만들 수 있다=중복값이 생긴다)

**곱셈이므로 숫자가 커질수있다 Long 타입으로 해야한다**



