const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];

rl.on("line", function (line) {
  input.push(line);
}).on("close", function () {
  let index = 0;
  let arr = [];
  let result = [];
  let set = new Set();

  while (true) {
    let items = input[index];
    if (items === "0") break;
    arr.push(items.split(" ").map(Number));
    index++;
  }

  const dfs = (count, start, k, items, isVisited) => {
    if (count === 6) {
      let res = result.sort((a, b) => a - b).join(" ");
      set.add(res);
      return;
    }
    for (let i = start; i < k; i++) {
      if (!isVisited[i] && !result.includes(items[i])) {
        isVisited[i] = true;
        result.push(items[i]);
        dfs(count + 1, i, k, items, isVisited);
        result.pop();
        isVisited[i] = false;
      }
    }
  };

  for (let i = 0; i < arr.length; i++) {
    let [k, ...items] = arr[i];
    let isVisited = Array(k).fill(false);

    dfs(0, 0, k, items, isVisited);

    for (let item of set) {
      console.log(item);
    }
    set = new Set();
    result = [];

    if (i !== arr.length - 1) {
      console.log();
    }
  }
});
