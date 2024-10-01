const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];

rl.on("line", function (line) {
  input.push(line);
}).on("close", function () {
  let T = Number(input[0]);
  let order = input[1].split(" ");
  let result = [];

  const dfs = (count, arr) => {
    if (count === T + 1) {
      result.push(arr.join(""));
      return;
    }
    let lastNum = arr[arr.length - 1];
    if (order[count - 1] === "<") {
      for (let j = 0; j <= 9; j++) {
        if (!arr.includes(j) && lastNum < j) {
          dfs(count + 1, [...arr, j]);
        }
      }
    } else if (order[count - 1] === ">") {
      for (let z = 0; z <= 9; z++) {
        if (!arr.includes(z) && lastNum > z) {
          dfs(count + 1, [...arr, z]);
        }
      }
    }
  };

  for (let i = 0; i <= 9; i++) {
    dfs(1, [i]);
  }
  result.sort((a, b) => a - b);

  let min = result[0];
  let max = result[result.length - 1];
  console.log(max);
  console.log(min);
});
