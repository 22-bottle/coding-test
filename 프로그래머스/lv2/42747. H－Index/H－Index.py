# n이 1000이하 이므로 O(n^2)까지 가능

def solution(citations):
    citations.sort(reverse=True) # 내림차순 정렬 -> O(nlogn)
    cnt = 0
    if citations[0] == 0:
        return 0
    while citations[cnt] > cnt + 1:
        cnt += 1
        if len(citations) == cnt or citations[cnt] < cnt + 1:
            return cnt
    return cnt + 1