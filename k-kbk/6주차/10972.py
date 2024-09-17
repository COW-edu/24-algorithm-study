n = int(input())
nums = list(map(int, input().split()))

for i in range(n - 1, 0, -1):
    if nums[i - 1] < nums[i]:
        for j in range(n - 1, 0, -1):
            if nums[i - 1] < nums[j]:
                nums[i - 1], nums[j] = nums[j], nums[i - 1]
                nums = nums[:i] + sorted(nums[i:])

                for i in nums:
                    print(i, end=" ")
                exit()
print(-1)
