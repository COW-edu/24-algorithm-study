const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];

rl.on("line", function (line) {
  input.push(line);
}).on("close", function () {
  let strArr = input.slice(0, input.length - 1);
  let result = [];

  for (let arr of strArr) {
    let stack = [];
    let isValid = true;

    for (let item of arr) {
      if (item === "(" || item === "[") {
        stack.push(item);
      } else if (item === "]") {
        if (stack.length === 0 || stack[stack.length - 1] !== "[") {
          isValid = false;
          break;
        }

        stack.pop();
      } else if (item === ")") {
        if (stack.length === 0 || stack[stack.length - 1] !== "(") {
          isValid = false;
          break;
        }

        stack.pop();
      }
    }

    if (stack.length === 0 && isValid) {
      result.push("yes");
    } else {
      result.push("no");
    }
  }

  console.log(result.join("\n"));
});
