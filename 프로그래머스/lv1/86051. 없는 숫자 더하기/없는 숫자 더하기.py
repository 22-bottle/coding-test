'''def solution(numbers):
    return 45 - sum(numbers)'''

def solution(numbers):
    answer = 0
    for i in range(10):
        answer = answer + i if i not in numbers else answer

    return answer