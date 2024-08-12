pricing = list(map(int, input().split(" ")))

parkingTime = [list(map(int, input().split(" "))) for _ in range(3)]

counts = [0] * 101

for time in parkingTime:
    for i in range(time[0], time[1]):
        counts[i] += 1

result = 0

for count in counts:
    if count != 0:
        result += pricing[count - 1] * count

print(result)
