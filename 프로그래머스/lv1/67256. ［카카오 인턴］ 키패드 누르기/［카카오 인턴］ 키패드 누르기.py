def solution(numbers, hand):
    answer = ""
    left = {1:1, 4:2, 7:3}
    mid = {2:1, 5:2, 8:3, 0:4}
    right = {3:1, 6:2, 9:3}
    left_hand = [4,1]
    right_hand = [4,3]
    
    for number in numbers:
        if number in left.keys():
            answer = answer + "L"
            left_hand = [left[number],1]
        elif number in right.keys():
            answer = answer + "R"
            right_hand = [right[number],3]
        else:
            left_distance = 1 if left_hand[1] == 1 else 0
            right_distance = 1 if right_hand[1] == 3 else 0
            left_distance += abs(left_hand[0] - mid[number])
            right_distance += abs(right_hand[0] - mid[number])

            if left_distance > right_distance:
                answer = answer + "R"
                right_hand = [mid[number],2]
            elif right_distance > left_distance:
                answer = answer + "L"
                left_hand = [mid[number],2]
            else:
                if hand == "left":
                    answer = answer + "L"
                    left_hand = [mid[number],2]
                else:
                    answer = answer + "R"
                    right_hand = [mid[number],2]

    return answer