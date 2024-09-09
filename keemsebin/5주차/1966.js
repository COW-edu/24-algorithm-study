const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];

rl.on("line", function (line) {
  input.push(line);
}).on("close", function () {
  let T = Number(input.shift());
  let result = [];

  for (let i = 0; i < T; i++) {
    const [total, targetIndex] = input[i * 2].split(" ").map(Number);
    const important = input[i * 2 + 1].split(" ").map(Number);

    let queue = important.map((importance, idx) => ({ importance, idx }));

    let count = 0;

    while (queue.length > 0) {
      const current = queue.shift();

      if (queue.some((item) => item.importance > current.importance)) {
        queue.push(current);
      } else {
        count++;

        if (current.idx === targetIndex) {
          result.push(count);
          break;
        }
      }
    }
  }

  console.log(result.join("\n"));
});
