n = int(input())

words = [input() for _ in range(n)]
result = 0

for word in words:
    stack = []

    for char in word:
        if len(stack) == 0:
            stack.append(char)
            continue

        last = stack[-1]
        if last == char:
            stack.pop()
        else:
            stack.append(char)

    if len(stack) == 0:
        result += 1

print(result)
