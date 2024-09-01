from collections import defaultdict

ddict = defaultdict(int)

n = input()
for num in input().split():
    ddict[num] = 1

m = input()
nums = input().split()

for num in nums:
    print(ddict[num])
