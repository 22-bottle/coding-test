def solution(left, right):
    answer = 0
    for num in range(left, right+1):
        answer += -num if int(num ** 0.5) == num ** 0.5 else num
    return answer