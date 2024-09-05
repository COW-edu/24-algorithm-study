t = int(input())

for _ in range(t):
    line = input()
    stack = []

    for char in line:
        if len(stack) == 0:
            stack.append(char)
            continue

        last = stack[-1]

        if last == "(" and char == ")":
            stack.pop()
        else:
            stack.append(char)

    print("YES" if len(stack) == 0 else "NO")
