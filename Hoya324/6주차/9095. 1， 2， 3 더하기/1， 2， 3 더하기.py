T = int(input())
for _ in range(T):
    n = int(input())
    dp = [0] * (12)
    dp[1], dp[2], dp[3] = 1, 2, 4
    if n < 4:
        print(dp[n])
        continue
    else:      
        for i in range(4, n+1):
                dp[i] = dp[i-1] + dp[i-2] + dp[i-3]
    print(dp[n])