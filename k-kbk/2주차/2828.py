n, m = map(int, input().split(" "))

j = int(input())

start = 1
end = m

result = 0

for _ in range(j):
    x = int(input())
    move = 0

    if x > end:
        while end < x:
            start += 1
            end += 1
            move += 1

    if x < start:
        while start > x:
            start -= 1
            end -= 1
            move += 1

    result += move

print(result)
