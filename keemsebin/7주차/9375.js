const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];

rl.on("line", function (line) {
  input.push(line);
}).on("close", function () {
  let N = Number(input[0]);

  let arr = input.slice(1);
  let result = [];
  let index = 0;

  for (let i = 0; i < N; i++) {
    let caseNum = Number(arr[index]);
    let map = new Map();

    for (let j = 0; j < caseNum; j++) {
      let [item, itemTitle] = arr[index + j + 1].split(" ");
      map.set(itemTitle, (map.get(itemTitle) || 0) + 1);
    }
    let sum = 1;
    for (let value of map.values()) {
      sum *= value + 1;
    }
    index += caseNum + 1;
    result.push(sum - 1);
  }

  console.log(result.join("\n"));
});
