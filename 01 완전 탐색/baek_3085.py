"""
상근이는 어렸을 적에 "봄보니 (Bomboni)" 게임을 즐겨했다.
가장 처음에 N x N 크기에 사탕을 채워 놓는다. 사탕의 색은 모두 같지 않을 수도 있다. 
상근이는 사탕의 색이 다른 인접한 두 칸을 고른다. 그 다음 고른 칸에 들어있는 사탕을 서로 교환한다. 
이제, 모두 같은 색으로 이루어져 있는 가장 긴 연속 부분(행 또는 열)을 고른 다음 그 사탕을 모두 먹는다.
사탕이 채워진 상태가 주어졌을 때, 상근이가 먹을 수 있는 사탕의 최대 개수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 보드의 크기 N이 주어진다. (3 ≤ N ≤ 50)
다음 N개 줄에는 보드에 채워져 있는 사탕의 색상이 주어진다. 빨간색은 C, 파란색은 P, 초록색은 Z, 노란색은 Y로 주어진다.
사탕의 색이 다른 인접한 두 칸이 존재하는 입력만 주어진다.

출력
첫째 줄에 상근이가 먹을 수 있는 사탕의 최대 개수를 출력한다.

예제 입력 1     | 예제 출력 1
3                 3
CCP
CCP
PPC

예제 입력 2     | 예제 출력 2
4                 4
PPPP
CYZY
CCPY
PPCC

예제 입력 3     | 예제 출력 3
5                 4
YCPZY
CYZZP
CCPPP
YCYZC
CPPZZ
"""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""

# <아이디어 구상>

# 특정값 접근하기
# n = 3
# candy = [
#     "CCP",
#     "CCP",
#     "PPC"
#       ]

# print(candy[0][0])

# 특정값의, 가로줄 세로줄 중 몇개가 같은 줄을 구성하는지

# count = 0
# candy[0][0] # 과 같은지 따져봐야할,
# # 가로줄
# candy[0][1], # 같다면, candy[0][2] 까지
# # 세로줄
# candy[1][0], # 같다면, candy[2][0] 까지

# c = 1
# r = 2

# c_count = 1
# r_count = 1


# for i in range(n):
#     if i != c:
#         if candy[c][r] == candy[i][r]:
#             c_count += 1

# for i in range(n):
#     if i != r:
#         if candy[c][r] == candy[c][i]:
#             r_count += 1
# print(max(c_count, r_count))
        

# r_count = 1

# for _ in range(1, n): # 가로줄 확인

#     r_index = j + _
#     if r_index == n:
#         break

#     if candy[i][j] == candy[i][r_index]:
#         r_count += 1

# c_count = 1

# for _ in range(1, n): # 새로줄 확인

#     c_index = i + _
#     if c_index == n:
#         break

#     if candy[i][j] == candy[c_index][j]:
#         c_count += 1

# print(max(r_count, c_count))

# n = 3
# candy = [
#     "CCP",
#     "CCP",
#     "PPC"
#       ]

# candy = []
# for i in range(n):
#     x = list(input())
#     candy.append(x)

# print(candy)

# 교환없이, 먹을 수 있는 개수 출력

# def check(list):
#     count = 1

#     for c in range(n):
#         for r in range(n):
#             c_count = 1
#             r_count = 1
#             for i in range(c + 1, n):
#                 if list[c][r] == list[i][r]:
#                     c_count += 1
#                 else:
#                     break

#             for i in range(r + 1, n):
#                 if list[c][r] == list[c][i]:
#                     r_count += 1
#                 else:
#                     break
#             count = max(count, c_count, r_count)
    
#     return count

# 인접한 다른 사탕, 교환할 수 있는 경우들 구하기

# candy = [['C', 'C', 'P'], ['C', 'C', 'P'], ['P', 'P', 'C']]
# count_list = []

# for c in range(n - 1):
#     for r in range(n):
#         if candy[c][r] != candy[c + 1][r]:
#             candy[c][r], candy[c + 1][r] = candy[c + 1][r], candy[c][r]
#             count_list.append(check(candy))
#             candy[c][r], candy[c + 1][r] = candy[c + 1][r], candy[c][r]

# for c in range(n):
#     for r in range(n - 1):
#         if candy[c][r] != candy[c][r + 1]:
#             candy[c][r], candy[c][r + 1] = candy[c][r + 1], candy[c][r]
#             count_list.append(check(candy))
#             candy[c][r], candy[c][r + 1] = candy[c][r + 1], candy[c][r]

# print(max(count_list))

# -----------------------------------------------------------------------------------------------------------

# 1 (시간초과)

# n = int(input())
# candy = [list(input()) for i in range(n)]

# # 함수 : 먹을 수 있는 사탕개수 체크
# def check(list):
#     count = 1

#     for c in range(n):
#         for r in range(n):
#             c_count = 1
#             r_count = 1
#             for i in range(c + 1, n):
#                 if list[c][r] == list[i][r]:
#                     c_count += 1
#                 else:
#                     break

#             for i in range(r + 1, n):
#                 if list[c][r] == list[c][i]:
#                     r_count += 1
#                 else:
#                     break
#             count = max(count, c_count, r_count)
    
#     return count

# # 인접한 다른 사탕 교환한 뒤에, 개수체크(함수) 후, 다시 원상태로 복원

# count_list = []

# # 열(column) 체크
# for c in range(n - 1):
#     for r in range(n):
#         if candy[c][r] != candy[c + 1][r]:
#             candy[c][r], candy[c + 1][r] = candy[c + 1][r], candy[c][r]
#             count_list.append(check(candy))
#             candy[c][r], candy[c + 1][r] = candy[c + 1][r], candy[c][r]

# # 행(row) 체크
# for c in range(n):
#     for r in range(n - 1):
#         if candy[c][r] != candy[c][r + 1]:
#             candy[c][r], candy[c][r + 1] = candy[c][r + 1], candy[c][r]
#             count_list.append(check(candy))
#             candy[c][r], candy[c][r + 1] = candy[c][r + 1], candy[c][r]

# print(max(count_list))

# -----------------------------------------------------------------------------------------------------------

# # 2 (시간초과)

# n = int(input())
# candy = [list(input()) for i in range(n)]

# # n = 3
# # candy = [['C', 'C', 'P'], ['C', 'C', 'P'], ['P', 'P', 'C']]

# # n = 4
# # candy = [['P', 'P', 'P', 'P'], ['C', 'Y', 'Z', 'Y'], ['C', 'C', 'P', 'Y'], ['P', 'P', 'C', 'C']]

# # n = 5
# # candy = [['Y', 'C', 'P', 'Z', 'Y'], ['C', 'Y', 'Z', 'Z', 'P'], ['C', 'C', 'P', 'P', 'P'], ['Y', 'C', 'Y', 'Z', 'C'], ['C', 'P', 'P', 'Z', 'Z']]  

# # 함수 : 먹을 수 있는 사탕개수 체크
# def check(list):
#     count_set = set()

#     for c in range(n):
#         for r in range(n):
#             c_count = 1
#             r_count = 1
#             for i in range(c + 1, n):
#                 if list[c][r] == list[i][r]:
#                     c_count += 1
#                 else:
#                     break

#             for i in range(r + 1, n):
#                 if list[c][r] == list[c][i]:
#                     r_count += 1
#                 else:
#                     break
#             count_set.update([c_count, r_count])
    
#     return max(count_set)

# # 인접한 다른 사탕 교환한 뒤에, 개수체크(함수) 후, 다시 원상태로 복원

# check_list = []

# # 열(column) 체크
# for c in range(n - 1):
#     for r in range(n):
#         if candy[c][r] != candy[c + 1][r]:
#             candy[c][r], candy[c + 1][r] = candy[c + 1][r], candy[c][r]
#             check_list.append(check(candy))
#             candy[c][r], candy[c + 1][r] = candy[c + 1][r], candy[c][r]

# # 행(row) 체크
# for c in range(n):
#     for r in range(n - 1):
#         if candy[c][r] != candy[c][r + 1]:
#             candy[c][r], candy[c][r + 1] = candy[c][r + 1], candy[c][r]
#             check_list.append(check(candy))
#             candy[c][r], candy[c][r + 1] = candy[c][r + 1], candy[c][r]

# print(max(check_list))

# -----------------------------------------------------------------------------------------------------------

# 3 (실패)

n = int(input())
candy = [list(input()) for i in range(n)]

# n = 3
# candy = [['C', 'C', 'P'], ['C', 'C', 'P'], ['P', 'P', 'C']]

# n = 4
# candy = [['P', 'P', 'P', 'P'], ['C', 'Y', 'Z', 'Y'], ['C', 'C', 'P', 'Y'], ['P', 'P', 'C', 'C']]

# n = 5
# candy = [['Y', 'C', 'P', 'Z', 'Y'], ['C', 'Y', 'Z', 'Z', 'P'], ['C', 'C', 'P', 'P', 'P'], ['Y', 'C', 'Y', 'Z', 'C'], ['C', 'P', 'P', 'Z', 'Z']]  


def check(list):
    count_set = set()

    for c in range(n):
        r_count = 1
        for r in range(n - 1):
            if list[c][r] == list[c][r + 1]:
                r_count += 1
            count_set.add(r_count)

    for r in range(n):
        c_count = 1
        for c in range(n - 1):
            if list[c][r] == list[c + 1][r]:
                c_count += 1
            count_set.add(c_count)

    return max(count_set)

check_list = []

for c in range(n):
    for r in range(n - 1):
        if candy[c][r] != candy[c][r + 1]:
            candy[c][r], candy[c][r + 1] = candy[c][r + 1], candy[c][r]
            check_list.append(check(candy))
            candy[c][r], candy[c][r + 1] = candy[c][r + 1], candy[c][r]

for c in range(n - 1):
    for r in range(n):
        if candy[c][r] != candy[c + 1][r]:
            candy[c][r], candy[c + 1][r] = candy[c + 1][r], candy[c][r]
            check_list.append(check(candy))
            candy[c][r], candy[c + 1][r] = candy[c + 1][r], candy[c][r]

print(max(check_list))
# -----------------------------------------------------------------------------------------------------------

# 4 (성공) (왜 성공한줄 모르고 답안 따라서 씀)

# [참고] 검색한 답안 https://enhjh.tistory.com/43

# n = 3
# candy = [['C', 'C', 'P'], ['C', 'C', 'P'], ['P', 'P', 'C']]

# n = 4
# candy = [['P', 'P', 'P', 'P'], ['C', 'Y', 'Z', 'Y'], ['C', 'C', 'P', 'Y'], ['P', 'P', 'C', 'C']]

# n = 5
# candy = [['Y', 'C', 'P', 'Z', 'Y'], ['C', 'Y', 'Z', 'Z', 'P'], ['C', 'C', 'P', 'P', 'P'], ['Y', 'C', 'Y', 'Z', 'C'], ['C', 'P', 'P', 'Z', 'Z']]  

n = int(input())
candy = [list(input()) for i in range(n)]

def check(list):
    count = 1


    # 행(row), 가로 체크
    for c in range(n):
        r_count = 1
        for r in range(n - 1):
            if list[c][r] == list[c][r + 1]:
                r_count += 1
            else:
                r_count = 1
            if count < r_count:
                count = r_count

    # 열(column), 세로 체크
    for r in range(n):
        c_count = 1
        for c in range(n - 1):
            if list[c][r] == list[c + 1][r]:
                c_count += 1
            else:
                c_count = 1
            if count < c_count:
                count = c_count

    return count

# 인접한 다른 사탕 교환한 뒤에, 개수체크(함수) 후, 다시 원상태로 복원

check_list = []

# 행(row), 가로 교환
for c in range(n):
    for r in range(n - 1):
        if candy[c][r] != candy[c][r + 1]:
            candy[c][r], candy[c][r + 1] = candy[c][r + 1], candy[c][r]
            check_list.append(check(candy))
            candy[c][r], candy[c][r + 1] = candy[c][r + 1], candy[c][r]

# 열(column), 세로 교환
for c in range(n - 1):
    for r in range(n):
        if candy[c][r] != candy[c + 1][r]:
            candy[c][r], candy[c + 1][r] = candy[c + 1][r], candy[c][r]
            check_list.append(check(candy))
            candy[c][r], candy[c + 1][r] = candy[c + 1][r], candy[c][r]

print(max(check_list))

# -----------------------------------------------------------------------------------------------------------

# 5 (성공)

n = int(input())
candy = [list(input()) for i in range(n)]

# n = 3
# candy = [['C', 'C', 'P'], ['C', 'C', 'P'], ['P', 'P', 'C']]

# n = 4
# candy = [['P', 'P', 'P', 'P'], ['C', 'Y', 'Z', 'Y'], ['C', 'C', 'P', 'Y'], ['P', 'P', 'C', 'C']]

# n = 5
# candy = [['Y', 'C', 'P', 'Z', 'Y'], ['C', 'Y', 'Z', 'Z', 'P'], ['C', 'C', 'P', 'P', 'P'], ['Y', 'C', 'Y', 'Z', 'C'], ['C', 'P', 'P', 'Z', 'Z']]  

def check(list):
    count_set = set()

    for c in range(n):
        r_count = 1
        for r in range(n - 1):
            if list[c][r] == list[c][r + 1]:
                r_count += 1
            else:                  # 1. 조건에 안맞을 때,
                r_count = 1        # r_count 를 1로 초기화하지 않으면, 다음 순회중에 조건에 맞는 경우가 나왔을 때 문제가 됨
            count_set.add(r_count) # 2. if문 안에서 추가하지 않으면, 
                                   # (크기 상관없이) 마지막 순회에서 얻은 r_count 값만 추가되서 문제가 됨
    for r in range(n):
        c_count = 1
        for c in range(n - 1):
            if list[c][r] == list[c + 1][r]:
                c_count += 1
            else:
                c_count = 1
            count_set.add(c_count)

    return max(count_set)


check_list = []

for c in range(n):
    for r in range(n - 1):
        if candy[c][r] != candy[c][r + 1]:
            candy[c][r], candy[c][r + 1] = candy[c][r + 1], candy[c][r]
            check_list.append(check(candy))
            candy[c][r], candy[c][r + 1] = candy[c][r + 1], candy[c][r]

for c in range(n - 1):
    for r in range(n):
        if candy[c][r] != candy[c + 1][r]:
            candy[c][r], candy[c + 1][r] = candy[c + 1][r], candy[c][r]
            check_list.append(check(candy))
            candy[c][r], candy[c + 1][r] = candy[c + 1][r], candy[c][r]

print(max(check_list))

# -----------------------------------------------------------------------------------------------------------

# 6 (성공) (시간단축)

n = int(input())
candy = [list(input()) for i in range(n)]

def check(list):
    count = 1

    for c in range(n):
        r_count = 1
        for r in range(n - 1):
            if list[c][r] == list[c][r + 1]:
                r_count += 1
                if count < r_count:
                    count = r_count
            else:                  
                r_count = 1

    for r in range(n):
        c_count = 1
        for c in range(n - 1):
            if list[c][r] == list[c + 1][r]:
                c_count += 1
                if count < c_count:
                    count = c_count
            else:
                c_count = 1       

    return count


max_count = 1

for c in range(n):
    for r in range(n - 1):
        if candy[c][r] != candy[c][r + 1]:
            candy[c][r], candy[c][r + 1] = candy[c][r + 1], candy[c][r]
            if max_count < check(candy):
                max_count = check(candy)
            candy[c][r], candy[c][r + 1] = candy[c][r + 1], candy[c][r]

for c in range(n - 1):
    for r in range(n):
        if candy[c][r] != candy[c + 1][r]:
            candy[c][r], candy[c + 1][r] = candy[c + 1][r], candy[c][r]
            if max_count < check(candy):
                max_count = check(candy)
            candy[c][r], candy[c + 1][r] = candy[c + 1][r], candy[c][r]

print(max_count)
