def solution(s):
    half = int(len(s)/2)
    answer = s[half] if len(s) % 2 != 0 else s[half-1:half+1]
    return answer