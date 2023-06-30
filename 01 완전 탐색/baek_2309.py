# 1 (실패 : 문제 잘못 이해함)
num = [int(input()) for i in range(9)]

num.sort()
total = sum(num)
answer_list = []

for i in range(len(num) - 1):
    index = 0
    answer = []
    for j in range(i + 1, len(num)):
        two = num[i] + num[j]
        result = total - two
        if result < 100:
            index = j
            break
        else:
            continue

    for x in range(len(num)):
        if x != i and x != index:
            answer.append(num[x])
    answer.sort()
    answer_list.append(answer)

for i in answer_list:
    print(i)

# -----------------------------------------------------------------------------------------------------------

# 2 (성공)
num = [int(input()) for i in range(9)]
# num = [20, 7, 23, 19, 10, 15, 25, 8, 13]

total = sum(num)
for i in range(len(num) - 1):
    for j in range(i + 1, len(num)):
        sum = total - (num[i] + num[j])
        if sum == 100:
            answer = [num[k] for k in range(len(num)) if k != i and k != j]
            answer.sort()
            break
    if sum == 100:
        break

for item in answer:
    print(item)