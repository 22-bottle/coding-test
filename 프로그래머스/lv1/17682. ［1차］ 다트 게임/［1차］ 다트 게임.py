def solution(dartResult):
    answer = []
    
    while len(dartResult) > 0:
        if dartResult[1] == '0':
            score = 10
            dartResult = dartResult[2:]
        else:
            score = int(dartResult[0])
            dartResult = dartResult[1:]
        bonus = dartResult[0]
        if len(dartResult) > 1 and (dartResult[1] == '#' or dartResult[1] == '*'):
            option = dartResult[1]
            dartResult = dartResult[2:]
        else:
            option = None
            dartResult = dartResult[1:]
        
        if bonus == 'D':
            score *= score
        elif bonus == 'T':
            score *= score * score
        
        if option == '*':
            if len(answer) > 0:
                answer[-1] *= 2
            score *= 2
        elif option == '#':
            score = -score
            
        answer.append(score)

    return sum(answer)