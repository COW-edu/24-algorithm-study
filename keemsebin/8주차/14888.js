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
  let arr = input[1].split(" ").map(Number);
  let [add, sub, mul, div] = input[2].split(" ").map(Number);

  let min = Infinity;
  let max = -Infinity;

  const dfs = (count, result, add, sub, mul, div) => {
    if (count === N) {
      min = Math.min(min, result);
      max = Math.max(max, result);
    }
    if (add > 0) {
      dfs(count + 1, result + arr[count], add - 1, sub, mul, div);
    }
    if (sub > 0) {
      dfs(count + 1, result - arr[count], add, sub - 1, mul, div);
    }
    if (mul > 0) {
      dfs(count + 1, result * arr[count], add, sub, mul - 1, div);
    }
    if (div > 0) {
      dfs(count + 1, parseInt(result / arr[count]), add, sub, mul, div - 1);
    }
  };
  dfs(1, arr[0], add, sub, mul, div);
  console.log(max ? max : 0);
  console.log(min ? min : 0);
});
