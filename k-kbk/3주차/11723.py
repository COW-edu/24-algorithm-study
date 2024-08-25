import sys

input = sys.stdin.readline

m = int(input())
s = set()

for i in range(m):
    line = input().rstrip()

    if line == "all":
        s = set(range(1, 21))
        continue
    if line == "empty":
        s = set()
        continue

    command, n = line.split(" ")
    n = int(n)

    if command == "add":
        s.add(n)
        continue
    if command == "remove":
        s.discard(n)
        continue
    if command == "check":
        print(1 if n in s else 0)
        continue
    if command == "toggle":
        if n in s:
            s.remove(n)
        else:
            s.add(n)
        continue
