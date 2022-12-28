def solution(s):
    half = len(s) // 2
    answer = s[half] if len(s) % 2 != 0 else s[half-1:half+1]
    return answer