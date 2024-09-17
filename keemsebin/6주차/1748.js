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
  let sum = 0;

  for (let i = 1; i <= N; i *= 10) {
    sum += N - i + 1;
  }

  console.log(sum);
});
