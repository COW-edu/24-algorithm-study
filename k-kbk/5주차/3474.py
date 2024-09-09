import sys

input = sys.stdin.readline

t = int(input())

for _ in range(t):
    n = int(input())

    count = 0
    x = 5

    while x <= n:
        count += n // x
        x *= 5

    print(count)
