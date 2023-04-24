def solution(s):
    lst = s.split(' ')
    for idx in range(len(lst)):
        lst[idx] = lst[idx].capitalize()
    return ' '.join(string for string in lst)