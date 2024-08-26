const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];

rl.on("line", function (line) {
  input.push(line);
}).on("close", function () {
  let T = Number(input[0]);
  let candy = [];
  for (let i = 0; i < T; i++) {
    let N = Number(input[i * 2 + 1]);
    let arr = input[i * 2 + 2].split(" ").map(Number);
    candy.push({ N, arr });
  }
  function makeEven(arr) {
    return arr.map((v) => (v % 2 === 0 ? v : v + 1));
  }

  function isSame(arr) {
    return arr.every((v) => v === arr[0]);
  }

  function isPossible(N, arr) {
    let count = 0;
    arr = makeEven(arr);

    while (!isSame(arr)) {
      let newArr = new Array(N).fill(0);
      for (let i = 0; i < N; i++) {
        newArr[i] = arr[i] / 2 + arr[(i - 1 + N) % N] / 2;
      }
      arr = makeEven(newArr);
      count++;
    }
    return count;
  }

  for (let { N, arr } of candy) {
    console.log(isPossible(N, arr));
  }
});
