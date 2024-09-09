const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];

rl.on("line", function (line) {
  input.push(line);
}).on("close", function () {
  let T = Number(input[0]);
  let N = input.slice(1).map(Number);

  let stack = [];
  let result = [];
  let index = 1;

  for (let num of N) {
    while (index <= num) {
      stack.push(index++);
      result.push("+");
    }

    if (num !== stack[stack.length - 1]) {
      return console.log("NO");
    }
    result.push("-");
    stack.pop();
  }

  console.log(result.join("\n"));
});
