'''def solution(nums):
    from itertools import combinations as cb # combinations(조합) 함수 사용
    answer = 0
    for a in cb(nums, 3):
        if is_prime(sum(a)) == True:
            answer += 1
    return answer'''

import math

def is_prime(x):
    for i in range(2, int(math.sqrt(x) + 1)):
    	if x % i == 0:
            return False
    return True

def solution(nums):
    answer = 0
    for i in range(0, len(nums)-2):
        for j in range(i+1, len(nums)-1):
            for k in range(j+1, len(nums)):
                if is_prime(nums[i]+nums[j]+nums[k]) == True:
                    answer += 1
    
    return answer