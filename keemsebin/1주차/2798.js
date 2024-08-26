const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];

rl.on("line", function (line) {
  input.push(line);
}).on("close", function () {
  let [N, M] = input[0].split(" ").map(Number);
  let arr = input[1].split(" ").map(Number);
  let result = 0;

  for (let i = 0; i < N - 2; i++) {
    for (let j = i + 1; j < N - 1; j++) {
      for (let k = j + 1; k < N; k++) {
        let sum = arr[i] + arr[j] + arr[k];
        if (sum <= M && sum > result) {
          result = sum;
        }
      }
    }
  }
  console.log(result);
});
