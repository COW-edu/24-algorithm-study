N = int(input())
answers = input()

bonus = 0
result = 0

for i in range(N):
    if answers[i] == "O":
        result += bonus + i + 1
        bonus += 1
    else:
        bonus = 0

print(result)
