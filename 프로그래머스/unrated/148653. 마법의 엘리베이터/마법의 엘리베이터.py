def solution(storey):
    answer = 0
    
    while storey > 0:
        target = storey % 10
        storey = storey // 10
        if (target > 5) or (target == 5 and storey % 10 >= 5):
            answer += 10 - target
            storey += 1
        else:
            answer += target
    
    return answer