def solution(s):
    answer = []
    alphabet = {}
    for i in range(len(s)):
        if s[i] not in alphabet:
            answer.append(-1)
        else:
            answer.append(i - alphabet[s[i]])
        alphabet[s[i]] = i
    return answer