# n이 2이상 30이하 이므로 제약 없음

def solution(n, lost, reserve):
    answer = 0
    students = [1] * n # 학생의 체육복 수
    for i in lost: # lost 반영
        students[i - 1] = students[i - 1] - 1
    for i in reserve: # reserve 반영
        students[i - 1] = students[i - 1] + 1
    for i in range(n):
        if students[i] == 0: # 체육복이 없으면
            if i != 0 and students[i - 1] == 2: # 앞번호 학생에게 여분있는지 확인
                answer = answer + 1
            elif i != n - 1 and students[i + 1] == 2: # 뒷번호 학생에게 여분있는지 확인
                answer = answer + 1
                students[i + 1] = 1 # 뒷번호 학생의 체육복 감소
        else: # 체육복이 있으면
            answer = answer + 1
    return answer