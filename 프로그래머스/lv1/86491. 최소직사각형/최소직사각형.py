def solution(sizes):
    bigger = 0
    smaller = 0
    for size in sizes:
        bigger = max(size) if max(size) > bigger else bigger
        smaller = min(size) if min(size) > smaller else smaller
    
    return bigger * smaller