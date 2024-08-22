k = int(input())

origin = []
height = []
width = []

for _ in range(6):
    direction, length = map(int, input().split())
    origin.append((direction, length))
    if direction in [1, 2]:
        width.append(length)
    else:
        height.append(length)

large = max(height) * max(width)
small = 1

for i in range(6):
    if origin[i][0] == origin[(i + 2) % 6][0]:
        small *= origin[(i + 1) % 6][1]

print((large - small) * k)
