from collections import Counter

n = int(input())
nNums = Counter(set(input().split()))

m = int(input())
mNums = input().split()

for num in mNums:
    print(nNums.get(num, 0))
