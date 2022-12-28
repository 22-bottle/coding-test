'''def solution(nums):
    return min(len(nums)/2, len(set(nums)))''' # min 함수 사용


def solution(nums):
    if len(nums) / 2 >= len(set(nums)):
        return len(set(nums))
    else:
        return len(nums) / 2