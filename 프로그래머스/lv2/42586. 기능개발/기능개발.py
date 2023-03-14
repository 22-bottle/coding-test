from math import ceil

def solution(progresses, speeds):
    answer = [1]
    days = [0] * len(progresses)
    for i in range(len(progresses)):
        days[i] = ceil((100 - progresses[i]) / speeds[i])
    criterion = days[0]
    del days[0]
    while len(days) > 0:
        if days[0] <= criterion:
            del days[0]
            answer[0] += 1
        else:
            criterion = days[0]
            del days[0]
            answer.insert(0, 1)
    return list(reversed(answer))