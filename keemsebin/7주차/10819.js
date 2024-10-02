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
  let arr = input[1].split(" ").map(Number);
  let isVisited = Array(N).fill(false);
  let max = -Infinity;
  let result = [];

  let sum = (arr) => {
    let totalSum = 0;
    for (let i = 0; i < N - 1; i++) {
      totalSum += Math.abs(arr[i] - arr[i + 1]);
    }
    return totalSum;
  };

  //
  const dfs = (num) => {
    for (let i = 0; i < N; i++) {
      if (num === N) {
        max = Math.max(max, sum(result));
      } else if (!isVisited[i]) {
        isVisited[i] = true;
        result.push(arr[i]);
        dfs(num + 1);
        isVisited[i] = false;
        result.pop();
      }
    }
  };
  dfs(0);
  console.log(max);
});
