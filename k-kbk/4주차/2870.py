n = int(input())

result = []

for _ in range(n):
    line = input()
    start = -1

    for i in range(len(line)):
        if ord("0") > ord(line[i]) or ord("9") < ord(line[i]):
            if start != -1:
                result.append(int(line[start:i]))
                start = -1
        elif start == -1:
            start = i

    if start != -1:
        result.append(int(line[start:]))

print("\n".join(map(str, sorted(result))))
