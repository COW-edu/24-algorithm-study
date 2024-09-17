from itertools import combinations

n = int(input())

nums = [list(map(int, input().split(" "))) for _ in range(n)]
members = list(range(n))
result = 100 * 20

for startTeam in combinations(members, n // 2):
    start, link = 0, 0
    linkTeam = list(set(members) - set(startTeam))

    for c in combinations(startTeam, 2):
        start += nums[c[0]][c[1]]
        start += nums[c[1]][c[0]]

    for c in combinations(linkTeam, 2):
        link += nums[c[0]][c[1]]
        link += nums[c[1]][c[0]]

    result = min(result, abs(start - link))

print(result)
