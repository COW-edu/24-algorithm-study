n = int(input())

period = sorted(map(int, input().split()), reverse=True)

result = 0

for i in range(n):
    result = max(result, period[i] + i)

print(result + 2)
