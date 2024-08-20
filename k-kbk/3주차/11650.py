points = [input().split() for _ in range(int(input()))]

points.sort(key=lambda x: [int(x[0]), int(x[1])])

for xy in points:
    print(f"{xy[0]} {xy[1]}")
