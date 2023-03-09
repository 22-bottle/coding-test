def solution(arr):
    return [-1] if len(arr) == 1 else arr[:arr.index(min(arr))] + arr[arr.index(min(arr)) + 1:]