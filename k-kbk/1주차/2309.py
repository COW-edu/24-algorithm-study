dwarfs = [int(input()) for _ in range(9)]

total = sum(dwarfs)
isSolved = False

for i in range(9):
    for j in range(9):
        if i == j:
            continue

        if total - dwarfs[i] - dwarfs[j] == 100:
            dwarfs[i] = -1
            dwarfs[j] = -1
            isSolved = True
            break

    if isSolved:
        break

print("\n".join(map(str, sorted(dwarfs)[2:])))
