import sys

input = sys.stdin.readline

n = int(input())
m = int(input())
items = list(map(int, input().split()))

items.sort()
count = 0
start = 0
end = len(items) - 1

while start < end:
    value = items[start] + items[end]
    if value < m:
        start += 1
    elif value > m:
        end -= 1
    else:
        count += 1
        start += 1
        end -= 1

print(count)
