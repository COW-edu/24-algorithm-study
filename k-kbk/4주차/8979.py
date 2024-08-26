n, k = map(int, input().split())

countries = []
target = []

for _ in range(n):
    temp = list(map(int, input().split()))
    countries.append(temp)

    if temp[0] == k:
        target = temp[1:]

countries.sort(key=lambda x: (-x[1], -x[2], -x[3]))

for i in range(n):
    if countries[i][1:] == target:
        print(i + 1)
        break
