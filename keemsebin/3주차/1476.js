const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];

rl.on("line", function (line) {
  input.push(line);
}).on("close", function () {
  let [E, S, M] = input[0].split(" ").map(Number);
  let year = 1;
  while (true) {
    if (
      (year - E) % 15 === 0 &&
      (year - S) % 28 === 0 &&
      (year - M) % 19 === 0
    ) {
      console.log(year);
      process.exit();
    }
    year++;
  }
});
