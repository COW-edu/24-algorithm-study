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
  let N = input.slice(1).map(Number);

  //  0이 나오는 조건 = 10으로 나누어 떨어지는 수.
  //  따라서 문제에서 n!에서 10의 개수를 구하는 문제로 바뀐다.
  //  10의 개수는 소인수 분해를 통해 2와 5의 개수 중 최솟값을 찾으면 된다.
  const factorial = (num) => {
    let two = 0;
    let five = 0;

    for (let i = 2; i <= num; i *= 2) {
      two += Math.floor(num / i);
    }

    for (let i = 5; i <= num; i *= 5) {
      five += Math.floor(num / i);
    }

    return Math.min(two, five);
  };

  for (let j = 0; j < T; j++) {
    console.log(factorial(N[j]));
  }
});
