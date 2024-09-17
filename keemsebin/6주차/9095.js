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
  let arr = input.slice(1).map(Number);

  const dp = (n) => {
    let dpArr = new Array(n + 1).fill(0);

    dpArr[1] = 1;
    dpArr[2] = 2;
    dpArr[3] = 4;

    for (let i = 4; i <= n; i++) {
      dpArr[i] = dpArr[i - 1] + dpArr[i - 2] + dpArr[i - 3];
    }
    return dpArr[n];
  };

  for (let i = 0; i < N; i++) {
    console.log(dp(arr[i]));
  }
});
