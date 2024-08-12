counts = [3, 2, 1, 2, 4, 3, 1, 3, 1, 1, 3, 1, 3, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1]

n, m = map(int, input().split(" "))
a, b = input().split(" ")

name = []

minLength = min(n, m)

for i in range(minLength):
    name.append(a[i])
    name.append(b[i])

name += a[minLength:] + b[minLength:]

nameLength = len(name)

for i in range(nameLength):
    name[i] = counts[ord(name[i]) - ord("A")]

for i in range(nameLength - 2):
    for j in range(nameLength - i - 1):
        name[j] += name[j + 1]

print(f"{(name[0] % 10 * 10 + name[1] % 10)}%")
