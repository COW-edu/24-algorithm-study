print(result)

from itertools import combinations

N, M = map(int, input().split())
cards = list(map(int, input().split()))

result = 0

for combination in combinations(cards, 3):
    total = sum(combination)
    if result < total <= M:
        result = total

print(result)

# - 풀이 2

# N, M = map(int, input().split(" "))
# cards = list(map(int, input().split(" ")))

# result = 0

# for i in range(N):
#     for j in range(N):
#         for k in range(N):
#             if i == j or j == k or k == i:
#                 continue

#             number = cards[i] + cards[j] + cards[k]
#             if result < number <= M:
#                 result = number
