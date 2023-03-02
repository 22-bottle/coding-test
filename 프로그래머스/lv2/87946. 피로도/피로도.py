# n이 8 이하이므로 시간 제약 없음
from itertools import permutations

def solution(k, dungeons):
    answer = 0
    pers = list(permutations(dungeons, len(dungeons))) # 던전의 순열
    for per in pers: # 각 순열마다
        hp = k # 처음 피로도
        cnt = 0 # 탐험한 던전 수
        for dungeon in per: # 각 던전마다
            if hp >= dungeon[0]: # 최소 피로도보다 현재 피로도가 높으면 탐험
                hp -= dungeon[1] # 피로도 감소
                cnt += 1 # 탐험한 던전 수 증가
        if cnt > answer:
            answer = cnt # answer 갱신
    return answer