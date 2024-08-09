n = int(input())

if n <= 2:
    print(1)
else:
    prev1 = 1
    prev2 = 1
    result = 0

    for i in range(n - 2):
        result = prev1 + prev2
        prev1 = prev2
        prev2 = result

    print(result)
