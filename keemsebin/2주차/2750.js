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
  let arr = [];
  for (let i = 0; i < N; i++) {
    arr.push(input[i + 1]);
  }
  arr.sort((a, b) => a - b);
  console.log(arr.join("\n"));
});
