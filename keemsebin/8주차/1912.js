const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];

rl.on("line", function (line) {
  input.push(line);
}).on("close", function () {
  let N = input[0];
  let arr = input[1].split(" ").map(Number);
  // DP 선택 이유 : "연속된" 몇개의 수 중 가장 큰 합을 원하기 때문
  let dp = Array.from({ length: N }).fill(-Infinity);

  dp[0] = arr[0];

  for (let i = 1; i < N; i++) {
    dp[i] = Math.max(arr[i], dp[i - 1] + arr[i]);
  }

  console.log(Math.max(...dp));
});
