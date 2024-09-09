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
  let ps = input.slice(1);
  let result = [];

  for (let arr of ps) {
    let stack = [];
    let isValid = true;

    for (let i = 0; i < arr.length; i++) {
      if (arr[i] === "(") {
        stack.push(arr[i]);
      } else if (arr[i] === ")") {
        if (stack.length === 0) {
          isValid = false;
          break;
        }
        stack.pop();
      }
    }

    if (stack.length === 0 && isValid) {
      result.push("YES");
    } else {
      result.push("NO");
    }
  }

  console.log(result.join("\n"));
});
