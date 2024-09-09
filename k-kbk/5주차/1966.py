from collections import deque

t = int(input())

for _ in range(t):
    n, m = map(int, input().split())
    queue = deque((i, int(num)) for i, num in enumerate(input().split()))
    count = 1

    while True:
        maxNum = max(queue, key=lambda x: x[1])[1]
        first = queue.popleft()

        if first[1] == maxNum:
            if first[0] == m:
                break
            count += 1
        else:
            queue.append(first)

    print(count)
