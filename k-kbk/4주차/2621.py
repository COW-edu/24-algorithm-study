from collections import Counter

colors = []
nums = []

for _ in range(5):
    color, num = input().split()
    colors.append(color)
    nums.append(int(num))

maxNum = max(nums)
counts = sorted(Counter(nums).most_common(), key=lambda x: (-x[1], -x[0]))
isContinuous = sorted(nums) == list(range(min(nums), maxNum + 1))
score = 100 + maxNum

if counts[0][1] == 2:
    score = 200 + counts[0][0]

if counts[0][1] == 2 and counts[1][1] == 2:
    score = 300 + (counts[0][0] * 10) + counts[1][0]

if counts[0][1] == 3:
    score = 400 + counts[0][0]

if isContinuous:
    score = 500 + maxNum

if counts[0][1] == 3 and counts[1][1] == 2:
    score = 700 + (counts[0][0] * 10) + counts[1][0]

if counts[0][1] == 4:
    score = 800 + counts[0][0]

if len(set(colors)) == 1:
    if isContinuous:
        score = 900 + maxNum
    else:
        score = max(score, 600 + maxNum)

print(score)
