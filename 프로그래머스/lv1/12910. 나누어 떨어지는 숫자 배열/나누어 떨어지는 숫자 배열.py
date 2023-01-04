def solution(arr, divisor):
    answer = []
    for i in range(len(arr)):
        if arr[i] % divisor == 0:
            answer.append(arr[i])
    return sorted(answer) or [-1]