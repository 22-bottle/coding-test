from math import sqrt, ceil

def solution(r1, r2):
    answer = 0
    
    r1_pow = r1 * r1
    r2_pow = r2 * r2
    for x in range(1, r2 + 1):
        x_pow = x * x
        max_y = int(sqrt(r2_pow - x_pow))
        min_y = ceil(sqrt(r1_pow - x_pow)) if x < r1 else 0
        answer += max_y - min_y + 1
    
    return answer << 2