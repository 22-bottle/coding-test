from itertools import permutations

def solution(numbers):
    answer = []
    num_list = []
    per_list = []
    num_list2 = []
    for num in numbers:
        num_list.append(num)
    for i in range(1, len(numbers) + 1):
        per_list += list(permutations(num_list, i))
    for per in per_list:
        num_list2.append(int("".join(per)))
    
    for num in num_list2:
        if num < 2:
            continue
        is_prime = True
        for i in range(2, int(num ** 0.5) + 1):
            if num % i == 0:
                is_prime = False
                break
        if is_prime:
            answer.append(num)
            
    return len(set(answer))