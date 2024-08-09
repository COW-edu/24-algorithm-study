T = int(input())


def calculateReward1(rank):
    rewards = [5_000_000, 3_000_000, 2_000_000, 500_000, 300_000, 100_000]
    index = 1

    while rank > index:
        rank -= index
        index += 1

    return rewards[index - 1]


def calculateReward2(rank):
    rewards = [5_120_000, 2_560_000, 1_280_000, 640_000, 320_000]
    index = 1
    acc = 1

    while rank > acc:
        rank -= acc
        acc *= 2
        index += 1

    return rewards[index - 1]


for _ in range(T):
    a, b = map(int, input().split(" "))
    reward1 = 0
    reward2 = 0

    if 1 <= a <= 21:
        reward1 = calculateReward1(a)

    if 1 <= b <= 31:
        reward2 = calculateReward2(b)

    print(reward1 + reward2)
