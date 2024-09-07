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
  let word = input.slice(1).map((item) => item.split(""));
  let result = 0;

  for (let i = 0; i < N; i++) {
    let goodWord = word[i];
    let stack = [];
    for (let j = 0; j < goodWord.length; j++) {
      if (stack.length > 0 && stack[stack.length - 1] === goodWord[j]) {
        stack.pop();
      } else {
        stack.push(goodWord[j]);
      }
    }
    if (stack.length === 0) result++;
  }

  console.log(result);
});
