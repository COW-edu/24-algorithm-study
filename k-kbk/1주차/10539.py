N = int(input())
arrB = list(map(int, input().split(" ")))
arrA = [arrB[0]]

if N != 1:
    for i in range(1, N):
        arrA.append(arrB[i] * (i + 1) - sum(arrA[:i]))

print(" ".join(map(str, arrA)))
