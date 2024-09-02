const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];

rl.on("line", function (line) {
  input.push(line);
}).on("close", function () {
  let N = Number(input[0]);
  let arr = input.slice(1).map((el) => el.split(" ").map(Number));

  // 최대로 얻을 수 있는 이익을 구해야 한다. == DP로 접근
  let dp = Array(N + 1).fill(0);

  // i번째 날에 상담을 하는 경우 vs 하지 않는 경우
  for (let i = 0; i < N; i++) {
    if (i + arr[i][0] <= N) {
      dp[i + arr[i][0]] = Math.max(dp[i + arr[i][0]], dp[i] + arr[i][1]);
    }
    dp[i + 1] = Math.max(dp[i + 1], dp[i]);
  }

  console.log(dp[N]);
});
