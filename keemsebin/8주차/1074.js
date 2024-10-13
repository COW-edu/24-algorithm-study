const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];

rl.on("line", function (line) {
  input.push(line);
}).on("close", function () {
  let [N, r, c] = input[0].split(" ").map(Number);
  let z = Array.from({ length: 2 ** N }).map(() => Array.from(2 ** N));
  let result = 0;

  const Z = (x, y, num) => {
    if (r === x && c === y) {
      console.log(result);
      return;
    }

    let half = num / 2;
    if (x <= r && y <= c && x + num > r && y + num > c) {
      Z(x, y, half);
      Z(x, y + half, half);
      Z(x + half, y, half);
      Z(x + half, y + half, half);
    } else {
      result += num * num;
    }
  };
  Z(0, 0, 2 ** N);
});
