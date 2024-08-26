const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];

rl.on("line", function (line) {
  input.push(line);
}).on("close", function () {
  const [N, M] = input[0].split(" ").map(Number);
  const J = input[1].split("");
  const location = input.slice(2).map(Number);

  let left = 1;
  let right = M;
  let result = 0;
  let move = 0;

  for (let i = 0; i < location.length; i++) {
    if (location[i] < left) {
      move = left - location[i];
      result += move;
      left -= move;
      right -= move;
    } else if (location[i] > right) {
      move = location[i] - right;
      result += move;
      right += move;
      left += move;
    }
  }

  console.log(result);
});
