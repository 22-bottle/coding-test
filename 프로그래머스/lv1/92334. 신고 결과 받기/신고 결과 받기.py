'''
def solution(id_list, report, k):
    answer = [0] * len(id_list)    
    reports = {x : 0 for x in id_list} #누가 몇 번 신고받았는지에 대한 dictionary

    for r in set(report): #set으로 중복 제거
        reports[r.split()[1]] += 1

    for r in set(report):
        if reports[r.split()[1]] >= k:
            answer[id_list.index(r.split()[0])] += 1 #list.index() 활용

    return answer
'''
def solution(id_list, report, k):
    answer = []
    
    dic = {}
    dic2 = {}
    for i in id_list:
        dic[i] = []
        dic2[i] = 0
    
    for i in report:
        user1 = i.split()[0]
        user2 = i.split()[1]
        if user1 not in dic[user2]:
            dic[user2].append(user1)
    
    for i in dic:
        if len(dic[i]) >= k:
            for j in dic[i]:
                dic2[j] += 1
    
    answer = list(dic2.values())
            
    return answer