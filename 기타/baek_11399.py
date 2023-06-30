n = int(input())
p = list(map(int, input().split()))

total_time = 0
atm_wait_time = 0
p.sort()

for atm_time in p:
    atm_wait_time += atm_time
    total_time += atm_wait_time

print(total_time)