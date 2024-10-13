const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];

rl.on("line", function (line) {
  input.push(line);
}).on("close", function () {
  let N = input[0];
  let arr = input.slice(1);
  let tree = [];
  let preOrderResult = "";
  let inOrderResult = "";
  let postOrderResult = "";
  arr.map((item) => {
    let [node, left, right] = item.split(" ");
    tree[node] = [left, right];
  });

  const preOrder = (node) => {
    if (node === ".") return;
    let [left, right] = tree[node];
    preOrderResult += node;
    preOrder(left);
    preOrder(right);
  };

  const inOrder = (node) => {
    if (node === ".") return;
    let [left, right] = tree[node];
    inOrder(left);
    inOrderResult += node;
    inOrder(right);
  };

  const postOrder = (node) => {
    if (node === ".") return;
    let [left, right] = tree[node];
    postOrder(left);
    postOrder(right);
    postOrderResult += node;
  };

  preOrder("A");
  inOrder("A");
  postOrder("A");

  console.log(preOrderResult);
  console.log(inOrderResult);
  console.log(postOrderResult);
});
