n = int(input())

room = [input() for _ in range(n)]

width = 0
height = 0


def checkPlace(line):
    count = 0
    total = 0

    for char in line:
        if char == ".":
            count += 1
        else:
            if count >= 2:
                total += 1
            count = 0

    if count >= 2:
        total += 1

    return total


for line in room:
    width += checkPlace(line)

for i in range(n):
    line = "".join([room[j][i] for j in range(n)])
    height += checkPlace(line)

print(width, height)
