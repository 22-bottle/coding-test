def solution(n):
    return int(''.join(sorted([c for c in str(n)], reverse=True)))