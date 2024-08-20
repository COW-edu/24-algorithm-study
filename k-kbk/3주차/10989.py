import sys

n = int(sys.stdin.readline())
count = [0] * 10_001

for _ in range(n):
    num = int(sys.stdin.readline())
    count[num] += 1

for i in range(10_001):
    if count[i] != 0:
        for _ in range(count[i]):
            print(i)
