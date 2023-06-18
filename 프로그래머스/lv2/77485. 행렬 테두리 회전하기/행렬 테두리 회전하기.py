def solution(rows, columns, queries):
    answer, m = [], []
    
    for i in range(rows):
        temp = []
        for j in range(columns):
            temp.append((columns * i) + (j + 1))
        m.append(temp)
    
    for query in queries:
        a, b, c, d = query[0]-1, query[1]-1, query[2]-1, query[3]-1
        first = m[a][b]
        min_value = first
        
        for i in range(a, c):
            m[i][b] = m[i + 1][b]
            min_value = min(min_value, m[i + 1][b])
        for i in range(b, d):
            m[c][i] = m[c][i + 1]
            min_value = min(min_value, m[c][i + 1])
        for i in range(c, a, -1):
            m[i][d] = m[i - 1][d]
            min_value = min(min_value, m[i - 1][d])
        for i in range(d, b, -1):
            m[a][i] = m[a][i - 1]
            min_value = min(min_value, m[a][i - 1])
        
        m[a][b + 1] = first
        answer.append(min_value)
        
    return answer