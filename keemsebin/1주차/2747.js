const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];

rl.on("line", function (line) {
  input.push(line);
}).on("close", function () {
  let N = parseInt(input[0]);

  const fabonacci = (n) => {
    if (n === 0) return 0;
    if (n === 1) return 1;
    let fibo = [0, 1];
    for (let i = 2; i <= n; i++) {
      fibo[i] = fibo[i - 1] + fibo[i - 2];
    }
    return fibo[n];
  };
  console.log(fabonacci(N));
});
