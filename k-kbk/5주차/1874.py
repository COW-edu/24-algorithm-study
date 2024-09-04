import sys

input = sys.stdin.readline

n = int(input())
stack = []
result = ""
now = 0
isPossible = True

for _ in range(n):
    x = int(input())

    if x >= now:
        while now < x:
            now += 1
            stack.append(now)
            result += "+"

    last = stack[-1]

    if last == x:
        stack.pop()
        result += "-"
    else:
        isPossible = False
        break

if isPossible:
    print("\n".join(result))
else:
    print("NO")
