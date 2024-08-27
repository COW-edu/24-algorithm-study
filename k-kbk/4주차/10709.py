h, w = map(int, input().split())

for _ in range(h):
    line = list(input())
    count = -1
    flag = False

    for element in line:
        if element == "c":
            flag = True
            count = 0
        elif flag:
            count += 1
        print(count, end=" ")
    print()
