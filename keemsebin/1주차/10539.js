const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];

rl.on("line", function (line) {
  input.push(line);
}).on("close", function () {
  let N = parseInt(input[0]);
  let B = input[1].split(" ").map(Number);
  let A = [];

  A.push(B[0]);

  for (let i = 1; i < N; i++) {
    A.push(B[i] * (i + 1) - B[i - 1] * i);
  }
  console.log(A.join(" "));
});
