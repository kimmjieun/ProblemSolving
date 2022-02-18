# 2월 둘째주



###  <img src ="https://d2gd6pc034wcta.cloudfront.net/tier/13.svg" width="25"> 줄 세우기 (22-02-14 AC)

https://www.acmicpc.net/problem/2252

> 실행시간 460ms

위상정렬 문제



### <img src ="https://d2gd6pc034wcta.cloudfront.net/tier/13.svg" width="25"> 후위표기식 (22-02-15 AC)

https://www.acmicpc.net/problem/1918

> 실행시간 128ms

스택을 사용해서 푸는 문제 , 연산자의 우선순의를 세팅해야한다 





### <img src ="https://d2gd6pc034wcta.cloudfront.net/tier/11.svg" width="25"> 보석도둑 (22-02-18 MLE)

https://www.acmicpc.net/problem/1202

> 실행시간 

PriorityQueue를 사용해서 푸는 구현문제이다 이때 Comparable선언을 1.보석의 가치 (내림차순)  2.무게(내림차순)으로 하여 poll()을 하면 되는 줄 알았는데 

4 4
1 100
2 200
13 300
10 500
10
10
10
14

상단의 반례에서 막혔다 위 경우 아래와 같이 실행되어야한다 

가방10 // 무게 1 가치100
가방10 // 무게 2 가치 200
가방10 // 무게 10 가치 500
가방14  //무게 13 가치 300



### <img src ="https://d2gd6pc034wcta.cloudfront.net/tier/14.svg" width="25"> 두용액

https://www.acmicpc.net/problem/

> 실행시간 

정렬 후 투포인터로 가장 적은 Math.abs를 찾는다



### <img src ="https://d2gd6pc034wcta.cloudfront.net/tier/15.svg" width="25"> 동전1

https://www.acmicpc.net/problem/

> 실행시간 

일차원 dp를 누적하여 합산한다 

자기 자신인 경우 이전 계산 +1 을한다



