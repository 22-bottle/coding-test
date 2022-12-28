'''def solution(array, commands):
    return list(map(lambda x:sorted(array[x[0]-1:x[1]])[x[2]-1], commands))'''
# lambda로 슬라이싱 및 정렬하는 함수 정의
# map으로 commands의 element에 lambda 적용 후 list 형태로 return

def solution(array, commands):
    answer = []
    
    for element in commands:
        sliced_array = array[element[0]-1:element[1]]
        sliced_array.sort()
        answer.append(sliced_array[element[2]-1])
        
    return answer