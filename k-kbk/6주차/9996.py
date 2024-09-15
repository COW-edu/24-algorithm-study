import sys

input = sys.stdin.readline

n = int(input())

pattern = input()
start, end = pattern.split("*")

for _ in range(n):
    name = input()
    print(
        "DA"
        if len(name) >= len(pattern) - 1
        and name.startswith(start)
        and name.endswith(end)
        else "NE"
    )
