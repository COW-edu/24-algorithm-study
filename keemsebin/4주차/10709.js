const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];

rl.on("line", function (line) {
  input.push(line);
}).on("close", function () {
  let [H, W] = input[0].split(" ").map(Number);

  let board = [];
  let result = Array.from({ length: H }, () => Array(W).fill(-1));

  for (let i = 1; i <= H; i++) {
    board.push(input[i].split(""));
  }

  for (let i = 0; i < H; i++) {
    let cnt = -1;
    for (let j = 0; j < W; j++) {
      if (board[i][j] === "c") {
        cnt = 0;
      }
      result[i][j] = cnt;
      if (cnt !== -1) cnt++;
    }
  }

  result.forEach((row) => {
    console.log(row.join(" "));
  });
});
