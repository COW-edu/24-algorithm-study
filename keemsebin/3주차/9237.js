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
  let arr = input[1].split(" ").map(Number);

  arr.sort((a, b) => b - a);
  let max = 0;
  for (let i = 0; i < N; i++) {
    arr[i] += i + 1; // 나무가 다 자란 다음날 이장님 초대
    max = Math.max(max, arr[i]);
  }
  console.log(max + 1); // 1을 더해주는 이유는 0부터 시작했기 때문
});
