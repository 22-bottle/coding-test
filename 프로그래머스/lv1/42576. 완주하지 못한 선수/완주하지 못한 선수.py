# 1 <= n <= 10^5 이므로 완전탐색 O(n^2)은 피해야 함.
# sort O(nlogn)로 해결

'''import collections
# collections.Counter는 어떤 요소가 몇 개 있는지 dictionary 형태로 반환

def solution(participant, completion):
    answer = collections.Counter(participant) - collections.Counter(completion)
    return list(answer.keys())[0]'''

def solution(participant, completion):
    participant.sort()
    completion.sort()
    
    for i in range(len(completion)):
        if participant[i] != completion[i]:
            return participant[i]
    return participant[-1]