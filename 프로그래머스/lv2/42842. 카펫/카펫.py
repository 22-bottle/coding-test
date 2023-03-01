def solution(brown, yellow):
    tuples = []
    for i in range(1, int(yellow ** 0.5) + 1): # yellow의 약수 구하기
        if yellow % i == 0:
            tuples.append((yellow / i, i))
    for tp in tuples: # 하나씩 검사
        if (tp[0] + tp[1] + 2) * 2 == brown:
            return [tp[0] + 2, tp[1] + 2]