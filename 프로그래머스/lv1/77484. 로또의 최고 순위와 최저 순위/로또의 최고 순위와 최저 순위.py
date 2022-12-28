'''
return [rank[len(set(lottos) & set(win_nums)) + lottos.count(0)], rank[len(set(lottos) & set(win_nums))]] # count 함수와 set의 교집합 사용
'''

def solution(lottos, win_nums):
    answer = []

    rank = {6:1, 5:2, 4:3, 3:4, 2:5, 1:6, 0:6}
    correct = 0
    unknown = 0
    for num in lottos:
        if num in win_nums:
            correct += 1
        elif num == 0:
            unknown += 1
            
    answer.append(rank[correct+unknown])
    answer.append(rank[correct])
    
    return answer