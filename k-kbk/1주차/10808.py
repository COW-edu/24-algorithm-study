S = input()

alphabet = "abcdefghijklmnopqrstuvwxyz"

result = dict()

for char in alphabet:
    result[char] = 0

for char in S:
    result[char] += 1

print(" ".join(map(str, result.values())))
