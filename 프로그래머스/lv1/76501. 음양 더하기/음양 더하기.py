'''def solution(absolutes, signs):
    return sum(absolute if sign else -absolute for absolute, sign in zip(absolutes, signs))''' # sum 함수, if + for, zip 함수


def solution(absolutes, signs):
    answer = 0
    
    for i in range(len(absolutes)):
        answer = answer + absolutes[i] if signs[i] else answer - absolutes[i]
    
    return answer