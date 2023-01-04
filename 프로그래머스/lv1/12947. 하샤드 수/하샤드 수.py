def solution(x):
    splited_x = list(str(x))
    sum = 0
    for i in range(len(splited_x)):
        sum += int(splited_x[i])
    answer = True if x % sum == 0 else False
    return answer