const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];

rl.on("line", function (line) {
  input.push(line);
}).on("close", function () {
  // 11723
  const N = parseInt(input[0]);
  const set = new Set();
  let answer = [];

  for (let i = 0; i < N; i++) {
    const [command, x] = input[i + 1].split(" ");
    let num = Number(x);
    switch (command) {
      case "add":
        set.add(num);
        break;
      case "remove":
        set.delete(num);
        break;
      case "check":
        answer.push(set.has(num) ? 1 : 0);
        break;
      case "toggle":
        if (set.has(num)) {
          set.delete(num);
        } else {
          set.add(num);
        }
        break;
      case "all":
        for (let j = 1; j <= 20; j++) {
          set.add(j);
        }
        break;
      case "empty":
        set.clear();
        break;
    }
  }
  console.log(answer.join("\n"));
});
