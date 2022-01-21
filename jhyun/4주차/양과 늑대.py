from collections import deque
#트리, dfs로 탐색하려니 왼쪽, 오른쪽을 탐색했을 경우를 구현 못하겠음..
#답을 참고했는데, 그래프 + bfs로 바꿔서 탐색하는 방법이 있었음.
#각 노드들을 탐색하면서 데리고 다니는 동물을 비트로 관리하는 아이디어
#visit[노드번호][동물 집합], 이런식으로 구성하여 재방문하지 않게함
class Point:
    def __init__(self, cur, sheep, wolf, state):
        self.cur = cur
        self.sheep = sheep
        self.wolf = wolf
        self.state = state

visited = [[False for _ in range(1 << 17)] for _ in range(17)]
q = deque([])
graph = []
def bfs(info: list):
    #탐색하면서 합한 최대 양의 개수를 반환
    global graph, q
    q.append(Point(0, 1, 0, 1))
    visited[0][1] = True
    ret = 0
    while len(q) != 0:
        p: Point = q.popleft()
        ret = max(ret, p.sheep)

        for nxt in graph[p.cur]:
            ns, nw = 0, 0
            #이전에 방문한 적이 없다
            if info[nxt] == 0 and (p.state & (1 << nxt)) == 0:
                ns = 1
            if info[nxt] == 1 and (p.state & (1 << nxt)) == 0:
                nw = 1
            #늑대의 수가 양 이상이다.
            if info[nxt] and p.sheep <= p.wolf + nw:
                continue
            nstate = p.state | (1 << nxt)
            if visited[nxt][nstate]:
                continue
            visited[nxt][nstate] = True
            q.append(Point(nxt, p.sheep + ns, p.wolf + nw, nstate))

    return ret

def init(info: list, edges: list):
    global graph
    graph = [[] for _ in range(len(info))]
    for s, e in edges:
        graph[s].append(e)
        graph[e].append(s)
    return

def solution(info: list, edges: list):
    init(info, edges)
    answer = bfs(info)
    return answer