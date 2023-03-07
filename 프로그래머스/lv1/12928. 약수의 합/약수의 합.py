def solution(n):
    answer = n
    for num in range(1, n // 2 + 1):
        if n % num == 0:
            answer += num
    return answer