def solution(s):
    stack = 0
    for i in range(len(s)):
        if s[i] == '(':
            stack += 1
        else:
            if stack <= 0:
                return False
            else:
                stack -= 1
    if stack > 0:
        return False
    return True