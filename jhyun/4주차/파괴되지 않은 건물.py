'''
1차원 배열 기준 누적합이기 때문에 배열의 길이는 상관하지 않고 처리하기 위하여 a, b + 1에 각각 c와 c의 반대 부호 값을 연산하는게 핵심이다.
이걸 2차원 배열로 확장하면 즉, 2차원 배열에서 (x1,y1)부터 (x2,y2)까지 n만큼의 변화는 (x1,y1)에 +n, (x1,y2+1)에 -n, (x2+1,y1)에 -n, (x2+1,y2+1)에 +n을 한 것과 같다.
'''
mask = []
N, M = 0, 0 #세로, 가로
def solution(board, skill):
    global mask, N, M
    N = len(board); M = len(board[0])
    mask = [[0 for _ in range(M + 1)] for _ in range(N + 1)]
    answer = 0
    #누적합을 위해 mask 배열에 연산
    for s in skill:
        t, r1, c1, r2, c2, degree = s
        if t == 1:
            degree *= -1
        mask[r1][c1] += degree
        mask[r2 + 1][c2 + 1] += degree
        mask[r1][c2 + 1] += -degree
        mask[r2 + 1][c1] += -degree

    #위쪽에서 아래쪽으로 누적합 수행
    for c in range(M + 1):
        for r in range(1, N + 1):
            mask[r][c] += mask[r - 1][c]
    #왼쪽에서 오른쪽으로 누적합 수행
    for r in range(N + 1):
        for c in range(1, M + 1):
            mask[r][c] += mask[r][c - 1]
    #파괴되지 않은 건물 카운트
    for r in range(N):
        for c in range(M):
            if board[r][c] + mask[r][c] > 0:
                answer += 1
    return answer