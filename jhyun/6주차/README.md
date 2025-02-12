# 문제
### 최소비용구하기

문제 접근 방법
> 도시와 버스의 관계를 묵시적 그래프로 나타낼 수 있고 그래프 탐색 방법으로 문제의 답을 도출할 수 있다.

시간제한이 짧고, 도시의 개수와 버스의 개수가 많기 때문에 그리디한 방법을 사용해야 한다.

즉, 가장 짧은 엣지부터 방문하고, 이미 짧은 경로를 알고 있다면 이후의 노드들은 탐색하지 않아야 한다.

우선순위 큐를 사용하여 가장 짧은 cost의 엣지부터 방문하도록 하는게 포인트다.

### 트리의 지름

문제 접근 방법
> 모든 정점에서 BFS를 수행을 시도했더니 메모리 초과가 발생했다. 이유를 모르겠어서 정답을 참고했는데, 방식이 인상 깊어 기록으로 남기는게 좋을 것 같았다.

트리의 지름을 구하는 방법으로 루트 노드에서 가장 먼 정점을 구한다. 트리의 특성 상 절반으로 연산을 줄일 수 있기 때문이다. 이후 해당 정점에서 다시 가장 먼 정점의 거리를 구하면 트리의 지름이 된다.

### 트럭

문제 접근 방법
> 간단한 문제이지만 논리를 헷갈려서 헤맸던 문제였다. 입력의 크기가 작기 때문에 다리를 다 빠져나가는 시간을 바로 계산하지 않고, 1초 단위로 계산하여도 100만으로 시간이 충분하다. 따라서 time이라는 변수를 증가시켜 계산하도록 하고, 무게 제한을 구현하기 위해 deque를 사용하였다. 이후 트럭의 대기 큐에서 하나씩 빼내어 넣게 되는데, 이 때 주의할 점은 트럭이 다리를 다 빠져나갔을 때 다른 트럭이 동시에 들어올 수 있다는 점에 유의한다.

### 여왕벌

문제 접근 방법
> 처음 시도한 방식 (태스크4에서 시간초과): N개의 입력에 대해 2M-1번씩 순회하여 누적합을 저장

개선한 방식: N개의 입력에 대해서도 누적합을 하고, 마지막에 M^2으로 출력

### 가운데를 말해요

문제 접근 방법
> min heap과 max heap을 사용하면 O(1)에 가깝게 연산을 수행할 수 있다. 각 큐의 사이즈를 조절하여 가운데로 맞춰주도록 하면 된다.
