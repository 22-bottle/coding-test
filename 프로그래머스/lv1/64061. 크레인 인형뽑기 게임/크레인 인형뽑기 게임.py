def solution(board, moves):
    basket = []
    answer = 0
    for column in moves:
        doll = 0
        for row in range(len(board)):
            if board[row][column-1] != 0:
                doll = board[row][column-1]
                board[row][column-1] = 0
                break
        if doll == 0:
            continue
        elif len(basket) != 0 and doll == basket[-1]:
            del basket[-1]
            answer += 2
        else:
            basket.append(doll)

    return answer