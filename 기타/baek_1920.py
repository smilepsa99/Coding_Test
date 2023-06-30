import sys

def binary_search(data, search):
    if len(data) == 1:
        if search == data[0]:
            return 1
        else:
            return 0
    elif len(data) == 0:
        return 0
    
    else:
        medium = len(data) // 2
        if search == data[medium]:
            return 1
        elif search < data[medium]:
            return binary_search(data[:medium], search)
        else:
            return binary_search(data[medium:], search)

# [참고] sys.stdin.readline() 사용법
# https://velog.io/@ecvheo1/%EC%9E%85%EB%A0%A5-%EB%B0%9B%EB%8A%94-%EB%B0%A9%EB%B2%95-sys.stdin.readline    

n = int(input())
n_list = list((map(int,sys.stdin.readline().split())))
n_list.sort()
m = int(input())
m_list = list((map(int,sys.stdin.readline().split())))

for item in m_list:
    print(binary_search(n_list, item))