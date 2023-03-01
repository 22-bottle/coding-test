from itertools import permutations

def solution(numbers):
    answer = []
    num_list = []
    per_list = []
    num_list2 = []
    for num in numbers: # 숫자 하나씩 parsing
        num_list.append(num)
    for i in range(1, len(numbers) + 1): # permutation 찾기
        per_list += list(permutations(num_list, i))
    for per in per_list: # int로 바꾸기
        num_list2.append(int("".join(per)))
    
    num_list2 = set(num_list2) # 중복값 제거
    for num in num_list2:
        if num < 2: # 0 or 1은 무시
            continue
        is_prime = True
        for i in range(2, int(num ** 0.5) + 1):
            if num % i == 0:
                is_prime = False
                break
        if is_prime: # 소수만 담기
            answer.append(num)
            
    return len(answer)
