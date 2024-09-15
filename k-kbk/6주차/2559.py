n, k = map(int, input().split())
nums = list(map(int, input().split()))

acc = sum(nums[:k])
result = acc

for i in range(n - k):
    acc += nums[i + k] - nums[i]
    if acc > result:
        result = acc

print(result)
