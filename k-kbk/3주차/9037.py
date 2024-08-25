t = int(input())


def makeEven(candies):
    for i in range(len(candies)):
        if candies[i] % 2 == 1:
            candies[i] += 1


for _ in range(t):
    n = int(input())
    candies = list(map(int, input().split()))
    count = 0
    makeEven(candies)

    while len(set(candies)) != 1:
        temp = candies.copy()
        for i in range(n):
            candies[i] /= 2
            candies[i] += temp[i - 1] / 2
        makeEven(candies)
        count += 1

    print(count)
