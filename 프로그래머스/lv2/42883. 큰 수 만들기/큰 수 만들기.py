# n이 1이상 10이하 이므로 제약 없음

def solution(number, k):
    pivot = 1
    while k > 0:
        if pivot < 1:
            pivot += 1 # pivot이 1이상임을 보장
        if number[pivot] > number[pivot - 1]: # pivot보다 앞자리가 더 작은 경우
            number = number[0:pivot - 1] + number[pivot:] # pivot의 앞자리 삭제
            pivot -= 1 # pivot도 한 칸 전진하게 됨
            k -= 1 # k 감소
        else: # pivot이 앞자리보다 작거나 같은 경우
            pivot += 1 # pivot 증가
        if pivot >= len(number): # 남은 숫자가 다 같거나 내림차순으로 되어 있는 경우
            number = number[:len(number) - k] # 뒷자리 k개 삭제
            break
    return number