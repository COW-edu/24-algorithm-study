N = int(input())
scores = list(map(int, input().split(" ")))

if N == 2:
    print(abs(scores[0] - scores[1]))
else:
    print(max(scores) - min(scores))
