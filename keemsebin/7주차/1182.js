const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];

rl.on("line", function (line) {
  input.push(line);
}).on("close", function () {
  let [N, S] = input[0].split(" ").map(Number);
  let arr = input[1].split(" ").map(Number);

  let count = 0;

  const recursive = (sum, depth) => {
    if (depth == N) {
      if (sum === S) {
        count++;
      }
      return;
    }

    recursive(sum + arr[depth], depth + 1);
    recursive(sum, depth + 1);
  };

  recursive(0, 0);

  console.log(count);
});
