# 1월 셋째주



###  <img src ="https://d2gd6pc034wcta.cloudfront.net/tier/11.svg" width="25"> 출근경로

https://www.acmicpc.net/problem/5569

> 실행시간 168ms

2차원배열 조합문제 였다 + 백트래킹까지
다음 열을 검사하기 위해 현재 행위치를 재귀함수 파라미터 세팅을 해야한다
선생님 위치에서 학생들이 보이는지 여부를 알아야하므로 선생님 위치는 Point 객체를 생성하여 리스트에 저장했다



### <img src ="https://d2gd6pc034wcta.cloudfront.net/tier/11.svg" width="25"> 트리인가

https://www.acmicpc.net/problem/6416

> 실행시간 276ms

순열문제 + 구현문제였다
순열을 비트연산자로 구현하였다
회전연산정보를 가지고 순열로 경우의 수를 만들었다



### <img src ="https://d2gd6pc034wcta.cloudfront.net/tier/11.svg" width="25"> 개똥벌레

https://www.acmicpc.net/problem/3020

> 실행시간 1160ms

감시피하기 문제와 비슷하다
2차원배열 조합문제 + 백트래킹이다
현재 위치에서 오른쪽으로 갈 경우(r,c => 1)와 , 왼쪽으로 갈 경우(r,c-1 = 1) 조건을 잘 설정해야한다
c-1인 경우를 설정하였으므로 2차원 배열 시작 idx는 (1,1)로 생각하였다



### <img src ="https://d2gd6pc034wcta.cloudfront.net/tier/14.svg" width="25"> 개미굴

https://www.acmicpc.net/problem/14725

> 실행시간 132ms

규칙을 찾으면 쉽게 풀 수 있다
현재의 누적합이 다음의 숫자보다 작을 경우 +1을 해준게 정답이다



### <img src ="https://d2gd6pc034wcta.cloudfront.net/tier/15.svg" width="25"> 소수의 곱 (22-01-25 AC)

https://www.acmicpc.net/problem/2014

> 실행시간 272ms

오름차순으로 나타내기 위해 PirorityQueue를 사용했으며 

중복되는 값이 생기면 안되므로 ` if(tmpNum%ni==0) break; `조건문을 넣어줘야했다

소수들을 priorityQueue에 다 넣어주고 하나씩 빼면서 

곱한 값을 넣어주고 빼낸 값이 기존 소수로 나눠떨어지면 더 이상 곱하지 않는다 (다른 수로 만들 수 있다=중복값이 생긴다)

**곱셈이므로 숫자가 커질수있다 Long 타입으로 해야한다**



