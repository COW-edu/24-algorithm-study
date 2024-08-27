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
  let arr = [];
  for (let i = 0; i < N; i++) {
    arr.push(input[i + 1].split(" ").map((el) => parseInt(el)));
  }
  arr.sort((a, b) => {
    if (a[0] === b[0]) {
      return a[1] - b[1];
    } else {
      return a[0] - b[0];
    }
  });
  for (let i = 0; i < N; i++) {
    console.log(arr[i].join(" "));
  }
});
