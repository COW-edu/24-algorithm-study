n, k = map(int, input().split())

nums = [int(input()) for _ in range(n)]
index = 0
m = 0

for _ in range(n):
    target = nums[index]
    m += 1

    if target == k:
        print(m)
        break

    index = target
else:
    print(-1)
