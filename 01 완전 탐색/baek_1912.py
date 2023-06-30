# # 1 (실패) (문제 잘못 이해함)
# # [참고] sort 와 sorted https://mizykk.tistory.com/119
# n = int(input())
# a = list(map(int, input().split()))
# sorted_a = sorted(a)

# plus = []
# for i in range(n - 1):
#     plus.append(a[i] + a[i + 1])
# plus.sort()

# if plus[-1] < sorted_a[-1]:
#     print(sorted_a[-1])
# else:
#     print(plus[-1])

# # -----------------------------------------------------------------------------------------------------------

# # 2 (실패)
# # [참고답안] https://wook-2124.tistory.com/406
# # [참고] max 함수 https://blockdmask.tistory.com/411

# n = int(input())
# list_n = list(map(int, input().split()))

# candidate = list()
# for i in range(n - 1):
#     bigger = max(list_n[i], list_n[i] + list_n[i+1])
#     candidate.append(bigger)

# print(max(candidate))

# # [참고] https://velog.io/@hygge/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98Python-%EB%B0%B1%EC%A4%80-1912-%EC%97%B0%EC%86%8D%ED%95%A9-DP

# # -----------------------------------------------------------------------------------------------------------

# # 3 (제출X) (조건 빠뜨림 : "연속된" 수를 더한다는 조건 빼먹음)
# # [참고] 경우의 수 만드는 라이브러리 https://armontad-1202.tistory.com/entry/%ED%8C%8C%EC%9D%B4%EC%8D%AC-%EB%AA%A8%EB%93%A0-%EA%B2%BD%EC%9A%B0%EC%9D%98-%EC%88%98-%EC%B6%94%EC%B6%9C-%EA%B0%80%EB%8A%A5%ED%95%9C-%EB%9D%BC%EC%9D%B4%EB%B8%8C%EB%9F%AC%EB%A6%AC

# from itertools import *
# n = 10
# nums = [10, -4, 3, 1, 5, 6, -35, 12, 21, -1]

# case_list = []
# sums = []

# for i in range(1, n + 1):
#     case = list(map(list, combinations(nums, i)))
#     case_list += case

# for j in range(len(case_list)):
#     x = sum(case_list[j])
#     sums.append(x)

# print(sums)

# -----------------------------------------------------------------------------------------------------------

# [답안설명] https://data-marketing-bk.tistory.com/52
# 완전탐색 공부 중에, 완전탐색으로 풀면 시간초과 나는 문제 예시로 나온 DP 문제인데 아예 못 풀겠어서 답안 보고 품

# n = 10
# nums = [10, -4, 3, 1, 5, 6, -35, 12, 21, -1]

# n = 10
# nums = [2, 1, -4, 3, 4, -4, 6, 5, -5, 1]

# n = 5
# nums = [-1, -2, -3, -4, -5]

# print(nums)
# print()
# for i in range(1, n):
#     bigger = max(nums[i], nums[i - 1] + nums[i])
#     if bigger == nums[i]:
#         print(f"{i}) {nums[i]} (인덱스 {i}번째의 값)")
#     elif bigger == nums[i - 1] + nums[i]:
#         print(f"{i}) {nums[i - 1]} + {nums[i]} = {nums[i - 1] + nums[i]} (인덱스 {i}번째까지의 합)")
#     nums[i] = bigger

# print()
# print(nums)
# answer = max(nums)
# print(f"정답 : {answer}")

# -----------------------------------------------------------------------------------------------------------

# case = []
# # 1개
# for i in range(5 - (1 - 1)):
#     x = nums[i]
#     case.append(x)

# # 2개
# for i in range(5 - (2 - 1)):
#     x = nums[i] + nums[i + 1]
#     case.append(x)

# # 3개
# for i in range(5 - (3 - 1)):
#     x = nums[i] + nums[i + 1] + nums[i + 2]
#     case.append(x)
# #...

# n = 5
# nums = [-1, -2, -3, -4, -5]

# case = []
# # 일반화
# for i in range(1, n + 1):
#     for j in range(n - (i - 1)):
#         x = nums[j: j + i]
#         case.append(sum(x))

# print(max(case))


# 4 (시간초과) (완전 탐색으로 모든 경우의 수를 따져봤기 때문)

# n = 10
# nums = [10, -4, 3, 1, 5, 6, -35, 12, 21, -1] 
# # 33

# n = 10
# nums = [2, 1, -4, 3, 4, -4, 6, 5, -5, 1] 
# # 14

# n = 5
# nums = [-1, -2, -3, -4, -5] 
# -1

n = int(input())
nums = list(map(int, input().split()))

case = []
for i in range(1, n + 1):
    for j in range(n - (i - 1)):
        x = nums[j: j + i]
        case.append(sum(x))

print(max(case))

# -----------------------------------------------------------------------------------------------------------

# n = int(input())
# nums = list(map(int, input().split()))

# n = 10
# nums = [10, -4, 3, 1, 5, 6, -35, 12, 21, -1] 
# # 33

# n = 10
# nums = [2, 1, -4, 3, 4, -4, 6, 5, -5, 1] 
# 14

# n = 5
# nums = [-1, -2, -3, -4, -5] 
# -1

# 4번의 시간 복잡도 : 이중 반복문으로 인해 O(n^2)
# ㄴ n이 최대 10만이므로, 최대 100억개 연산 (10만 x 10만)
# ㄴ 컴퓨터는 대략 1초에 1억개 연산 가능 (https://blog.naver.com/kks227/220769859177)
# ㄴ 1억 < 100억 으로 시간 초과

# ⇒ 반복문을 하나만 써서 작성한다면? 아예 새로운 아이디어가 필요할 듯

# 5 (성공)

# n = int(input())
# nums = list(map(int, input().split()))

# sum_list = [nums[0]]
# sum = nums[0]

# for i in range(1, n):
#     if nums[i] < nums[i] + sum:         # sum > 0 로 바꿀 수 있어서 바꿈
#         sum += nums[i]
#     else:
#         sum = nums[i]
#     sum_list.append(sum)

# print(max(sum_list))


# n = 10
# nums = [10, -4, 3, 1, 5, 6, -35, 12, 21, -1]

# 인덱스 0번째 값부터 1번째값, 2번째값 ... 순으로 인접한 값들을 더해나가는데,
# [인덱스 (x-1)번째 값까지 더한 합] + [인덱스 x번째 값] < [인덱스 x번째 값] 이라면,
#  ㄴ 즉, [인덱스 (x-1)번째 값까지 더한 합] < 0 이라면,
# [인덱스 (x-1)번째 값까지 더한 합] 을 버리고, [인덱스 x번째 값] 부터 다시 더해나가기 시작함

n = int(input())
nums = list(map(int, input().split()))

sum_list = [nums[0]]       # 이전까지의 총합을 모아둔 리스트 (sum_list)
sum = nums[0]              # 이전까지의 총합 (sum)

for i in range(1, n):      # nums 의 값들을 인접한 순서대로 더하는 작업을 반복할건데..
    if sum > 0:            # 만약 이전까지의 총합이 양수라면, (이전까지의 총합 + 현재 인덱스번째의 값 > 현재 인덱스번째의 값)
        sum += nums[i]     # 이전까지의 총합에 현재 인덱스번째의 값을 더함
    else:                  # 만약 이전까지의 총합이 음수라면, (총합이 줄어들므로, 이전까지의 합을 버리고 다시 시작)
        sum = nums[i]      # 이전까지의 총합을 현재 인덱스번째의 값으로 갱신함
    sum_list.append(sum)   # 매 순회마다의, 이전까지의 총합을 sum_list 에 넣음

print(max(sum_list))       # 이전까지의 총합을 모아둔 sum_list 에서, 최댓값을 출력
# print(sum_list)