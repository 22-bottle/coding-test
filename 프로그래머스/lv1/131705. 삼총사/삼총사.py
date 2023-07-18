from itertools import combinations

def solution(number):
    answer = 0
    
    num_c = combinations(number, 3)
    for c in num_c:
        if sum(c) == 0:
            answer += 1
    
    return answer