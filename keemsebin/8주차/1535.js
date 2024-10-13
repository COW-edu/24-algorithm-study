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

  let healthArr = input[1].split(" ").map(Number);
  let joyArr = input[2].split(" ").map(Number);
  let dp = Array(101).fill(0);

  for (let i = 0; i < N; i++) {
    for (let health = 100; health > healthArr[i]; health--) {
      dp[health] = Math.max(dp[health], dp[health - healthArr[i]] + joyArr[i]);
    }
  }

  console.log(Math.max(...dp.slice(1)));
});
