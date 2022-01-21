max_v = 0
N = 0
ans_map = {}
Info = []
def add_log(lion_sum: int, appeach_sum: int, log: str):
    global ans_map
    if lion_sum <= appeach_sum:
        return
    dist = lion_sum - appeach_sum
    if dist in ans_map:
        ans_map[dist].append(log)
    else:
        ans_map[dist] = [log]

#i번째 과녁에 화살을 한 번씩 쏴본다.
#lion_sum: 라이언 점수합, appeach_sum: 어피치 점수합, cnt: 남은 화살, log: 과녁에 몇발맞췄는지 기록
def recur(i: int, lion_sum: int, appeach_sum: int, cnt: int, log: str):
    global N, max_v, Info, ans_map
    if i == len(Info):
        #1~10점까지 모두 쏘고 남은 화살은 0점에 다 쏨
        add_log(lion_sum, appeach_sum, str(cnt) + log)
        return
    if cnt > Info[i]:
        if Info[i] == 0: #어피치가 i점 과녁에 못 맞췄으면 감소시키지 않음
            recur(i + 1, lion_sum + i, appeach_sum, cnt - (Info[i] + 1), log + str(Info[i] + 1))
        else: #어피치가 i점 과녁에 맞춘게 있으면 감소
            recur(i + 1, lion_sum + i, appeach_sum - i, cnt - (Info[i] + 1), log + str(Info[i] + 1))
    recur(i + 1, lion_sum, appeach_sum, cnt, log + '0')

def solution(n, info: list):
    answer = []
    global max_v, N, Info, ans_map
    N = n
    Info = info.copy()
    Info.reverse()
    for i in range(len(info) - 1):
        if info[i] > 0:
            max_v += 10 - i
    recur(1, 0, max_v, n, "")
    if len(ans_map) == 0:
        answer = [-1]
    else:
        max_v = max(ans_map.keys())
        ans_list = ans_map[max_v]
        sorted(ans_list, reverse=True)
        answer = [int(x) for x in ans_list[0]]
        answer = answer[::-1]
    return answer