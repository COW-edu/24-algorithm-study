n = int(input())

origin = n
count = 0

while True:
    count += 1
    n = (n % 10) * 10 + ((n // 10) + (n % 10)) % 10

    if n == origin:
        break

print(count)
