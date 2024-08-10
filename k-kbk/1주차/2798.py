N, M = map(int, input().split(" "))
cards = list(map(int, input().split(" ")))

result = 0

for i in range(N):
    for j in range(1, N):
        for k in range(2, N):
            if i == j or j == k or k == i:
                continue

            number = cards[i] + cards[j] + cards[k]
            if result < number <= M:
                result = number

print(result)
