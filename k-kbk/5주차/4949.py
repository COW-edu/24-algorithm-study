while True:
    line = input()
    
    if line == ".":
        break
    
    stack = []
    
    for char in line:
        if char in ["(", ")", "[", "]"]:
            if len(stack) == 0:
                stack.append(char)
                continue
        else:
            continue
        
        last = stack[-1]
        
        if (last == "(" and char == ")") or (last == "[" and char == "]") :
            stack.pop()
        else:
            stack.append(char)

    print("yes"  if len(stack) == 0 else "no")