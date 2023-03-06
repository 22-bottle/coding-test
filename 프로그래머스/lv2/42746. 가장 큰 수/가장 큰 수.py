# n이 100000 이하이므로 O(n^2) 불가능
# 사전식으로 비교할 때는 string 상태에서 비교해야 함
# map 함수 사용

def solution(numbers):
    numbers = list(map(str, numbers))
    numbers.sort(key=lambda x:x * 3, reverse=True)
    return str(int(''.join(numbers)))