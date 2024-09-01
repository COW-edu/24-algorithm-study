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

  let ans = 0;
  let count = 0;

  while (ans < N) {
    count++;
    if (count.toString().includes("666")) {
      ans++;
    }
  }

  console.log(count);
});
