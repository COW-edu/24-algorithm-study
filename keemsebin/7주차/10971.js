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
  let arr = input.slice(1).map((item) => item.split(" ").map(Number));
  let visited = Array(N).fill(false);
  let min = Infinity;

  const dfs = (current, count, cost) => {
    if (count === N) {
      if (arr[current][0] !== 0) {
        min = Math.min(min, cost);
        return;
      }
    }
    for (let i = 0; i < N; i++) {
      if (!visited[current] && !arr[current][i] !== 0) {
        visited[i] = true;
        dfs(i, count + 1, cost + arr[current][i]);
        visited[i] = false;
      }
    }
  };

  dfs(0, 1, 0);
  console.log(min);
});
