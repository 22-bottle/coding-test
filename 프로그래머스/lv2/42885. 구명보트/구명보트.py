# n이 50000 이하 이므로 O(n^2)까지 가능
# 배열 수정하지 않아도 될 때는 굳이 수정할 필요 없음

def solution(people, limit):
    answer = 0
    people.sort() # 정렬 -> O(nlogn)
    l = 0
    r = len(people) - 1
    while l < r: # 최악의 경우 n번 검사 -> O(n)
        if people[l] + people[r] <= limit:
            l += 1
            r -= 1
        else:
            r -= 1
        answer += 1
    if l == r:
        answer += 1
    return answer
