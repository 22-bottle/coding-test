def solution(d, budget):
    d.sort()
    sum = 0
    count = 0
    for i in range(len(d)):
        sum += d[i]
        if sum <= budget:
            count += 1
        else:
            break
    return count