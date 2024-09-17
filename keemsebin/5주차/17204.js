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
  let arr = input.slice(1).map(Number);

  let visited = new Array(N).fill(false);
  let current = 0;
  let count = 0;

  while (!visited[current]) {
    if (current === K) {
      console.log(count);
      return;
    }
    visited[current] = true;
    current = arr[current];
    count++;
  }

  console.log(-1);
});
