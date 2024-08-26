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
  arr.sort((a, b) => a - b);
  console.log(arr.join("\n"));
});
