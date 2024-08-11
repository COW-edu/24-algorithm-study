const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];

rl.on("line", function (line) {
  input.push(line);
}).on("close", function () {
  let height = input.map(Number);
  let totalSum = height.reduce((a, b) => a + b, 0);
  let found = false;

  for (let i = 0; i < 8; i++) {
    for (let j = i + 1; j < 9; j++) {
      if (totalSum - height[i] - height[j] === 100) {
        let result = height.filter((_, index) => index !== i && index !== j);
        result.sort((a, b) => a - b);
        result.forEach((h) => console.log(h));
        found = true;
        break;
      }
    }
    if (found) break;
  }
});
