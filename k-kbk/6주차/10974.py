from itertools import permutations

n = int(input())
per = permutations(range(1, n + 1), n)

for per in list(per):
    print(" ".join(map(str, per)))
