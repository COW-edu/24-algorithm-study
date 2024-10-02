const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];

rl.on("line", function (line) {
  input.push(line);
}).on("close", function () {
  let K = Number(input[0]);
  let arr = input[1].split(" ").map(Number);
  let tree = [];

  for (let i = 0; i < K; i++) {
    tree.push([]);
  }

  const preOrder = (node, level) => {
    if (node.length === 1) {
      tree[level].push(node[0]);
      return;
    }

    let parent = Math.floor(node.length / 2);
    let left = node.slice(0, parent);
    let right = node.slice(parent + 1, node.length);

    tree[level].push(node[parent]);
    preOrder(left, level + 1);
    preOrder(right, level + 1);
  };

  preOrder(arr, 0);

  console.log(tree.map((item) => item.join(" ")).join("\n"));
});
