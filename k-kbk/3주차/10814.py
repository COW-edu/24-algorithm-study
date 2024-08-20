members = [input().split() for _ in range(int(input()))]

members.sort(key=lambda x: int(x[0]))

for member in members:
    print(f"{member[0]} {member[1]}")
