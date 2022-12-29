def solution(k, m, score):
    answer = 0
    left = 0
    for i in range(k, 0, -1):
        i_apples = score.count(i)
        if i_apples >= m - left:
            i_apples -= m - left
            box = 1
            left = i_apples % m
        else:
            left += i_apples
            box = 0
        box += i_apples // m
        answer += box * m * i
    return answer