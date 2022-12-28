'''import re # re module

def solution(new_id):
    st = new_id
    st = st.lower()
    st = re.sub('[^a-z0-9\-_.]', '', st) # a~z, 0~9, -_. 제외 다른 문자를 ''로 바꿈
    st = re.sub('\.+', '.', st) # '.'이 하나 이상 있는 패턴을 '.'으로 바꿈
    st = re.sub('^[.]|[.]$', '', st) # '.'으로 시작하거나 '.'으로 끝나면 ''로 바꿈
    st = 'a' if len(st) == 0 else st[:15] # if문 작성 팁
    st = re.sub('^[.]|[.]$', '', st)
    st = st if len(st) > 2 else st + "".join([st[-1] for i in range(3-len(st))])
    return st'''


def solution(new_id):
    new_id = new_id.lower()
    for letter in new_id:
        if not letter.isalnum() and letter not in ['-', '_', '.']:
            new_id = new_id.replace(letter, '')
        new_id = new_id.replace('..', '.')
    if new_id[0] == '.':
        new_id = new_id[1:]
    if not len(new_id) == 0:
        if new_id[-1] == '.':
            new_id = new_id[:-1]
    if len(new_id) == 0:
        new_id = new_id + 'a'
    if len(new_id) >= 16:
        new_id = new_id[:15]
        if new_id[14] == '.':
            new_id = new_id[:14]
    while len(new_id) <= 2:
        new_id = new_id + new_id[len(new_id)-1]
        
    return new_id