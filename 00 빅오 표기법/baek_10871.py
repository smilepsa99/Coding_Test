# [참고] split 함수 https://blockdmask.tistory.com/469
# ㄴ[참고] join 함수 https://blockdmask.tistory.com/468
# [참고] map 함수 https://blockdmask.tistory.com/531

n, x = map(int, input().split())
list_a = list(map(int, input().split()))

for a in list_a:
    if a < x:
        print(a, end = " ")