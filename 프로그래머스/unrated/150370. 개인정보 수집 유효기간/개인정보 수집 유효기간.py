def solution(today, terms, privacies):
    answer = []
    
    t_y, t_m, t_d = list(map(int, today.split(".")))
    
    term_dict = {}
    for term in terms:
        key, value = term.split(" ")
        term_dict[key] = int(value)
    
    for i in range(len(privacies)):
        p_date, term = privacies[i].split(" ")
        p_y, p_m, p_d = list(map(int, p_date.split(".")))
        p_m += term_dict[term]
        is_valid = (t_y - p_y) * 12 + (t_m - p_m)
        if is_valid > 0:
            answer.append(i + 1)
        elif is_valid == 0:
            if t_d - p_d >= 0:
                answer.append(i + 1)
    
    return answer