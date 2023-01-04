def solution(arr, divisor):
    answer = []
    for i in range(len(arr)):
        if arr[i] % divisor == 0:
            answer.append(arr[i])
    return sorted(answer) or [-1] # 빈 list는 False이기 때문에 or 사용 가능
