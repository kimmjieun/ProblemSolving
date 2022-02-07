# 2월 첫째주



###  <img src ="https://d2gd6pc034wcta.cloudfront.net/tier/11.svg" width="25"> 정보상인호석 (22-02-08 AC)

https://www.acmicpc.net/problem/22252

> 실행시간 1360ms



Map<String,PriorityQueye> 구현문제였다. 이때 우선순위큐는 내림차순이어야한다



### <img src ="https://d2gd6pc034wcta.cloudfront.net/tier/11.svg" width="25"> 트리인가 (22-01-26 AC)

https://www.acmicpc.net/problem/6416

> 실행시간 128ms

트리의 특징만 검사하면 되는 문제였다 (DFS 할 필요없음...)

1.  트리의 루트노드는 1개 이하여야 한다  (노드가 없어도 트리이다 그때 루트노드는 없으므로...)
2.  정점에 들어오는 간선은 하나여야한다 (Map을 사용해 검사하였다)
3.  정점이 1개 이상일경우 , 정점의개수 = 간선의개수+1 이어야한다





### <img src ="https://d2gd6pc034wcta.cloudfront.net/tier/11.svg" width="25"> 개똥벌레 (22-01-25 AC)

https://www.acmicpc.net/problem/3020

> 실행시간 356ms

2차원배열 imos법으로 풀었는데 메모리초과가 떴다 

그래서 다른풀이를 알아보던중 O(N)으로도 풀 수 있는 방법을 보게 됐다

높이로만 1차원 배열을 만든 후 , 해당 인덱스에 값을 추가한다 

**종유석도 거꾸로 보면 아래에서 시작하므로 인덱스의 변화없이 종유석 차례에 장애물크기의 위치에 값을 추가한다 **

**높이로 1차원배열을 만들었으므로 뒤에서부터 누적합을 더해야한다**

idx = 3 인 배열에 값이 있다면 (1,2,3) 다 지나가야 하므로 장애물의 값을 구할 수 있다





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



