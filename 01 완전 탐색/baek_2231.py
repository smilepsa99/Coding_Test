# 어떤 자연수 N이 있을 때, 그 자연수 N의 분해합은 N과 N을 이루는 각 자리수의 합을 의미한다. 
# 어떤 자연수 M의 분해합이 N인 경우, M을 N의 생성자라 한다. 
# 예를 들어, 245의 분해합은 256(=245+2+4+5)이 된다. 따라서 245는 256의 생성자가 된다. 
# 물론, 어떤 자연수의 경우에는 생성자가 없을 수도 있다. 반대로, 생성자가 여러 개인 자연수도 있을 수 있다.
# 자연수 N이 주어졌을 때, N의 가장 작은 생성자를 구해내는 프로그램을 작성하시오.

# 입력
# 첫째 줄에 자연수 N(1 ≤ N ≤ 1,000,000)이 주어진다.

# 출력
# 첫째 줄에 답을 출력한다. 생성자가 없는 경우에는 0을 출력한다.

# 예제 입력 1 : 216
# 예제 출력 1 : 198

""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""

# 1 (성공)
# [참고] 각 자리수 분리, 합 https://go-hard.tistory.com/96

# 거꾸로 만들어보기 : 숫자 입력 -> 이 숫자를 생성자로 하는 분해합 출력
# x = 198
# y = sum(map(int, str(x)))
# print(x + y)

# 제대로 돌려서 만들어보기

# n = x + sum(map(int, str(x)))
# sum(map(int, str(x))) 의 범위, x의 범위는?

n = int(input())
min = n - 9 * len(str(n))
if min < 0:
    min = 0
exist = False
for x in range(min, n):
    test = x + sum(map(int, str(x)))
    if test == n:
        exist = True
        print(x)
        break
if exist == False:
    print(0)

# -----------------------------------------------------------------------------------------------------------

# 2 (성공) (코드를 좀 더 줄여봄)
# [참고] 완전탐색 정석풀이(다른사람 코드) https://www.acmicpc.net/source/62786775
"""
n = int(input())
result = 0
for i in range(n):
  sum = i
  for j in str(i):
    sum += int(j)
  if sum == n:
    result = i
    break
print(result)
"""

n = int(input())

min = n - 9 * len(str(n))
if min < 0:
    min = 0
result = 0

for x in range(min, n):
    test = x + sum(map(int, str(x)))
    if test == n:
        result = x
        break
print(result)


# -----------------------------------------------------------------------------------------------------------
# [+참고] 파이썬 1위 코드(다른사람 코드) https://www.acmicpc.net/source/53246434

"""
N = int(input())
ans = 0
for i in range(max(0,N-len(str(N))*9),N):
    if sum(map(int,str(i))) + i == N:
        ans = i
        break
print(ans)
"""