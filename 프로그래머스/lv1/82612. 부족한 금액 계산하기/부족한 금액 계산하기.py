def solution(price, money, count):
    for i in range(count):
        money -= (i+1) * price
    answer = -money if money < 0 else 0
    return answer