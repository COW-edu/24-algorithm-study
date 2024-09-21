const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];

rl.on("line", function (line) {
  input.push(line);
}).on("close", function () {
  let [N, K] = input[0].split(" ").map(Number);
  let arr = input[1].split(" ").map(Number);

  let windowSum = arr.slice(0, K).reduce((sum, num) => sum + num, 0);
  let maxSum = windowSum;

  for (let i = K; i < N; i++) {
    windowSum = windowSum - arr[i - K] + arr[i];
    maxSum = Math.max(maxSum, windowSum);
  }

  console.log(maxSum);
});
