def solution(a, b):
    days = ["THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"]
    date = [0, 31, 60, 91, 121, 152, 182, 213, 244, 274, 305, 335]
    return days[(date[a-1]+b) % 7]