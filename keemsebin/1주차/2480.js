const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];

rl.on("line", function (line) {
  input.push(line);
}).on("close", function () {
  let [first, second, third] = input[0].split(" ").map(Number);

  // 1. 세가지 수가 모두 같은 경우
  if (first === second && second === third) {
    console.log(10000 + first * 1000);
  }
  // 2. 두 수만 같은 경우
  else if (first === second || first === third) {
    console.log(1000 + first * 100);
  } else if (second === third) {
    console.log(1000 + second * 100);
  }
  // 3. 모두 다른 경우
  else {
    console.log(Math.max(first, second, third) * 100);
  }
});
