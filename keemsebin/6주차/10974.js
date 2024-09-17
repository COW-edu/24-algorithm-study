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
  let answer = [];

  let visited = Array.from(N * N).fill(0);
  let selected = Array.from(N * N).fill(0);

  const dfs = (n) => {
    if (n === N) {
      let result = [];
      for (let i = 0; i < N; i++) {
        result.push(selected[i]);
      }

      answer.push(result.join(" "));
    }

    for (let i = 1; i <= N; i++) {
      if (visited[i]) {
        continue;
      }

      selected[n] = i;
      visited[i] = true;
      dfs(n + 1);
      visited[i] = false;
    }
  };

  dfs(0);
  console.log(answer.join("\n"));
});
