const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];

rl.on("line", function (line) {
  input.push(line);
}).on("close", function () {
  let T = parseInt(input[0]);
  let result = [];

  for (let i = 0; i < T; i++) {
    let [a, b] = input[i + 1].split(" ").map(Number);
    let prize = 0;

    if (a === 1) {
      prize += 5000000;
    } else if (a >= 2 && a <= 3) {
      prize += 3000000;
    } else if (a >= 4 && a <= 6) {
      prize += 2000000;
    } else if (a >= 7 && a <= 10) {
      prize += 500000;
    } else if (a >= 11 && a <= 15) {
      prize += 300000;
    } else if (a >= 16 && a <= 21) {
      prize += 100000;
    }

    if (b === 1) {
      prize += 5120000;
    } else if (b >= 2 && b <= 3) {
      prize += 2560000;
    } else if (b >= 4 && b <= 7) {
      prize += 1280000;
    } else if (b >= 8 && b <= 15) {
      prize += 640000;
    } else if (b >= 16 && b <= 31) {
      prize += 320000;
    }
    result.push(prize);
  }

  console.log(result.join("\n"));
});
