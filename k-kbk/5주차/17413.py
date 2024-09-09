from collections import deque

line = input()
stack = deque()
isSkipped = False

for char in line:
    if char == "<":
        print("".join(stack), end="<")
        stack.clear()
        isSkipped = True
    elif char == ">":
        print(">", end="")
        isSkipped = False
    elif char == " ":
        print("".join(stack), end=" ")
        stack.clear()
    else:
        if isSkipped:
            print(char, end="")
        else:
            stack.appendleft(char)


print("".join(stack))
