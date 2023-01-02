def solution(answers):
    answer = []
    score = [0,0,0]
    omr = [[1,2,3,4,5], [2,1,2,3,2,4,2,5], [3,3,1,1,2,2,4,4,5,5]]
    for i in range(len(answers)):
        if answers[i] == omr[0][i%5]:
            score[0] += 1
        if answers[i] == omr[1][i%8]:
            score[1] += 1
        if answers[i] == omr[2][i%10]:
            score[2] += 1
    for i in range(3):
        if score[i] == max(score):
            answer.append(i + 1)
    return answer