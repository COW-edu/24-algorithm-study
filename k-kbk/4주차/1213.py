from collections import Counter

name = input()
counter = Counter(name)
result = ""

if len(name) % 2 == 0:
    if all(count % 2 == 0 for count in counter.values()):
        for key in sorted(counter):
            result = (
                result[: len(result) // 2]
                + key * counter[key]
                + result[len(result) // 2 :]
            )
    else:
        result = "I'm Sorry Hansoo"
else:
    oddCount = 0
    oddCountedChar = ""

    for key in sorted(counter):
        if counter[key] % 2 != 0:
            oddCount += 1
            oddCountedChar = key

    if oddCount == 1:
        result = oddCountedChar
        counter[oddCountedChar] -= 1
        for key in sorted(counter, reverse=True):
            result = key * (counter[key] // 2) + result + key * (counter[key] // 2)
    else:
        result = "I'm Sorry Hansoo"

print(result)
