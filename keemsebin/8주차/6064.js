const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];

rl.on("line", function (line) {
  input.push(line);
}).on("close", function () {
  let arr = input.slice(1);
  let result = [];

  const getGcd = (a, b) => {
    while (b !== 0) {
      [a, b] = [b, a % b];
    }
    return a;
  };

  const getLcm = (a, b) => (a * b) / getGcd(a, b);

  arr.forEach((item) => {
    let [M, N, x, y] = item.split(" ").map(Number);
    const lcm = getLcm(M, N);

    let found = false;

    for (let i = x; i <= lcm; i += M) {
      if (((i - 1) % N) + 1 === y) {
        result.push(i);
        found = true;
        break;
      }
    }

    if (!found) result.push(-1);
  });

  console.log(result.join("\n"));
});
