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
  let M = Number(input[1]);
  let result = 0;

  let ingredient = input[2].split(" ").map(Number);

  for (let i = 0; i < ingredient.length; i++) {
    for (let j = i + 1; j < ingredient.length; j++) {
      if (ingredient[j] + ingredient[i] == M) {
        result++;
        break;
      }
    }
  }

  console.log(result);
});
