def solution(word):
    answer = 0
    next_word = {'A':'E', 'E':'I', 'I':'O', 'O':'U'}
    word = list(word)
    my_word = []
    while (my_word != word):
        if len(my_word) < 5: # 길이가 5보다 작으면 A 추가
            my_word.append('A')
        else:
            for i in range(4, -1, -1):
                if my_word[i] == 'U':
                    my_word.pop(i)
                else:
                    my_word[i] = next_word[my_word[i]]
                    break
        answer += 1
    return answer