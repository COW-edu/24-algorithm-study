import sys

input = sys.stdin.readline

n = int(input())

for i in range(n):
    line = list(input().strip())
    left = []
    right = []

    for j in line:
        if j == "<":
            if left:
                right.append(left.pop())
        elif j == ">":
            if right:
                left.append(right.pop())
        elif j == "-":
            if left:
                left.pop()
        else:
            left.append(j)

    left.extend(reversed(right))

    print("".join(left))
