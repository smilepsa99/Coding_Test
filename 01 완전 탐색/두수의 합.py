# 알고리즘 블로그 - 완전탐색 https://blog.naver.com/kks227/220769870195

# baek_1912 의 쉬운 버전
# n 개의 수를 입력받은 후, 그 중 서로 다른 2개를 더해서 나올 수 있는 합 중 가장 큰 걸 구하라
n = 10
nums = [10, -4, 3, 1, 5, 6, -35, 12, 21, -1]

# 1. 완전 탐색 활용 : O(n^2)
list1 = []
for i in range(n - 1):
    for j in range(i + 1, n):
        x = nums[i] + nums[j]
        list1.append(x)
print(max(list1))

# 2. 정렬(sort) 활용 : O(nlogn)
nums.sort()
print(nums[-1] + nums[-2])