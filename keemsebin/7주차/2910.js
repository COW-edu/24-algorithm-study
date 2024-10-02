const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];

rl.on("line", function (line) {
  input.push(line);
}).on("close", function () {
  let [N, C] = input[0].split(" ").map(Number);
  let arr = input[1].split(" ").map(Number);

  let map = new Map();
  let result = [];

  arr.forEach((item) => {
    map.set(item, (map.get(item) || 0) + 1);
  });

  const mapToArray = [...map];

  map = new Map(mapToArray.sort((a, b) => b[1] - a[1]));

  for (const [key, value] of map) {
    for (let i = 0; i < value; i++) {
      result.push(key);
    }
  }
  console.log(result.join(" "));
});
