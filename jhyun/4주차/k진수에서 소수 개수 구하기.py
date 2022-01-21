m = {}
def is_prime(str_num: str) -> bool:
    num = int(str_num)
    if num == 1: return False
    elif num == 2: return True
    for i in range(3, int(num**(1/2)) + 1):
        if num % i == 0:
            return False
    return True

#int로 들어온 수를 문자열로 진법 변환
def convert(n: int, k: int) -> str:
    digit = ""
    while(n != 0):
        if n % k == 0:
            digit += '0'
        else:
            digit += str(n % k)
        n = n // k
    return digit[::-1]

def findNum(digit: str):
    global m
    nums = digit.split('0')
    for num in nums:
        if len(num) == 0: continue
        m[num] = m.get(num, 0) + 1

def countPrime() -> int:
    cnt = 0
    for key in m.keys():
        if is_prime(key):
            cnt += m[key]
    return cnt

def solution(n, k):
    digit = convert(n, k)
    findNum(digit)
    answer = countPrime()
    return answer