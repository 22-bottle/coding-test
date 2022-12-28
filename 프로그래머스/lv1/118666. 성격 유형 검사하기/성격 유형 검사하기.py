def solution(survey, choices):
    score = [3,2,1,0,1,2,3]
    result = ""
    answer = ""
    for i in range(len(survey)):
        if choices[i] <= 4:
            result += survey[i][0] * score[choices[i]-1]
        else:
            result += survey[i][1] * score[choices[i]-1]
    
    answer += "R" if result.count("R") >= result.count("T") else "T"
    answer += "C" if result.count("C") >= result.count("F") else "F"
    answer += "J" if result.count("J") >= result.count("M") else "M"
    answer += "A" if result.count("A") >= result.count("N") else "N"

    return answer