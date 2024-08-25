e, s, m = map(int, input().split())

count = 1
x, y, z = 1, 1, 1

while True:
    if e == x and s == y and m == z:
        break

    x += 1
    if x == 16:
        x = 1
    y += 1
    if y == 29:
        y = 1
    z += 1
    if z == 20:
        z = 1

    count += 1

print(count)
