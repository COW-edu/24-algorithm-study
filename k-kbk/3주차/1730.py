directions = {
    "U": (-1, 0),
    "D": (1, 0),
    "L": (0, -1),
    "R": (0, 1),
}

n = int(input())
commands = list(input())

points = [[chr(46)] * n for _ in range(n)]
x, y = 0, 0


def draw(points, command):
    if command in ["U", "D"]:
        points[y][x] = (
            chr(124) if points[y][x] == chr(46) or points[y][x] == chr(124) else chr(43)
        )
    if command in ["L", "R"]:
        points[y][x] = (
            chr(45) if points[y][x] == chr(46) or points[y][x] == chr(45) else chr(43)
        )


for command in commands:
    newX = x + directions[command][1]
    newY = y + directions[command][0]
    if 0 <= newX < n and 0 <= newY < n:
        draw(points, command)
        x = newX
        y = newY
        draw(points, command)

for row in points:
    print("".join(row))
