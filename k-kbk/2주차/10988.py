word = input()

isPalindrome = True

for i in range(int(len(word) / 2)):
    if word[i] != word[-1 - i]:
        isPalindrome = False
        break

print(1 if isPalindrome else 0)
