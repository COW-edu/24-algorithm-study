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
  let min = Math.min(...B);
  let max = Math.max(...B);

  console.log(max - min);
});
