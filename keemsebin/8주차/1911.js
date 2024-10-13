const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];

rl.on("line", function (line) {
  input.push(line);
}).on("close", function () {
  let [N, L] = input[0].split(" ").map(Number);
  let arr = input.slice(1).map((item) => item.split(" ").map(Number));
  let count = 0;
  let result = 0;
  arr.sort((a, b) => a[0] - b[0]);

  for (let i = 0; i < N; i++) {
    let [start, end] = arr[i];
    if (count < start) {
      count = start;
    }
    while (count < end) {
      result++;
      count += L;
    }
  }

  console.log(result);
});
