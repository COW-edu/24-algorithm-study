s = input().split(" ")

result = []

for word in s:
    newWord = ""

    for char in word:
        asciiCode = ord(char)
        if ord("A") <= asciiCode <= ord("Z"):
            newWord += chr(ord("A") + (asciiCode - ord("A") + 13) % 26)
        elif ord("a") <= asciiCode <= ord("z"):
            newWord += chr(ord("a") + (asciiCode - ord("a") + 13) % 26)
        else:
            newWord += char

    result.append(newWord)

print(" ".join(result))
