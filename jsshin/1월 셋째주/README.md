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



### <img src ="https://d2gd6pc034wcta.cloudfront.net/tier/11.svg" width="25"> 개똥벌레 (22-01-25 AC)

https://www.acmicpc.net/problem/3020

> 실행시간 356ms

2차원배열 imos법으로 풀었는데 메모리초과가 떴다 

그래서 다른풀이를 알아보던중 O(N)으로도 풀 수 있는 방법을 보게 됐다

높이로만 1차원 배열을 만든 후 , 해당 인덱스에 값을 추가한다 

**종유석도 거꾸로 보면 아래에서 시작하므로 인덱스의 변화없이 종유석 차례에 장애물크기의 위치에 값을 추가한다 **

**높이로 1차원배열을 만들었으므로 뒤에서부터 누적합을 더해야한다**

idx = 3 인 배열에 값이 있다면 (1,2,3) 다 지나가야 하므로 장애물의 값을 구할 수 있다



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



