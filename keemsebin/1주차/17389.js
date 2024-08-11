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
  let OX = input[1].split("");
  let score = 0;
  let bonus = 0;

  for (let i = 0; i < N; i++) {
    if (OX[i] === "O") {
      score += i + 1 + bonus;
      bonus++;
    } else {
      bonus = 0;
    }
  }
  console.log(score);
});
