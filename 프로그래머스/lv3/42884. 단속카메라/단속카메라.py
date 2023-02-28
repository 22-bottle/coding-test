# n이 10000 이하 이므로 O(n^2)까지 가능

def solution(routes):
    answer = 0
    routes.sort(key=lambda x:x[1]) # 정렬 -> O(nlogn)
    camera = -30001 # 마지막 카메라의 위치
    for route in routes:
        if route[0] > camera: # 카메라의 위치를 벗어나면
            camera = route[1] # 카메라 추가 설치
            answer += 1
    return answer
