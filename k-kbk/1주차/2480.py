from collections import Counter

numbers = list(map(int, input().split(" ")))

# most_common(): 많이 나온 순으로 정렬
counter = Counter(numbers).most_common()

size = len(counter)

if size == 1:
    print(10_000 + numbers[0] * 1_000)
elif size == 2:
    number = counter[0][0]
    print(1_000 + number * 100)
else:
    print(max(numbers) * 100)
