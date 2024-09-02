const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];

rl.on("line", function (line) {
  input.push(line);
}).on("close", function () {
  let [N, M] = input[0].split(" ").map(Number);
  let arr = input.slice(1, N + 1);
  let question = input.slice(N + 1);

  let map = new Map();
  arr.forEach((el, index) => {
    let name = el;
    map.set(name, index + 1);
  });

  let result = [];

  question.forEach((el) => {
    if (map.has(el)) {
      result.push(map.get(el));
    } else {
      result.push(arr[el - 1]);
    }
  });
  console.log(result.join("\n"));
});
