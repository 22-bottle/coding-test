'''def solution(a, b):
    return sum([x*y for x, y in zip(a,b)])''' # zip과 sum 활용

def solution(a, b):
    answer = 0
    for i in range(len(a)):
        answer = answer + a[i]*b[i]
    return answer