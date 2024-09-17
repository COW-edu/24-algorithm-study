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

  for (let i = 1; i <= N; i++) {
    const items = input[i];
    let leftStack = [];
    let rightStack = [];

    for (let char of items) {
      if (char === "<") {
        if (leftStack.length > 0) {
          rightStack.push(leftStack.pop());
        }
      } else if (char === ">") {
        if (rightStack.length > 0) {
          leftStack.push(rightStack.pop());
        }
      } else if (char === "-") {
        if (leftStack.length > 0) {
          leftStack.pop();
        }
      } else {
        leftStack.push(char);
      }
    }
    console.log(leftStack.join("") + rightStack.reverse().join(""));
  }
});
