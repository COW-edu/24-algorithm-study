const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];

rl.on("line", function (line) {
  input.push(line);
}).on("close", function () {
  let arr = input[1].split(" ").map(Number);
  let compare = input[3].split(" ").map(Number);

  let arrSet = new Set(arr);
  let result = [];

  for (let item of compare) {
    if (arrSet.has(item)) {
      result.push(1);
    } else {
      result.push(0);
    }
  }

  console.log(result.join("\n"));
});
