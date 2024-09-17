n, m = map(int, input().split())
nums = list(map(int, input().split()))

left, right = 0, 1
result = 0

while left <= right and right <= n:
    acc = sum(nums[left:right])

    if acc == m:
        result += 1
        left += 1
        right += 1

    elif acc < m:
        right += 1

    else:
        left += 1

print(result)
