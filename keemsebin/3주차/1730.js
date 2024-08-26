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
  let moves = input[1].split("");
  let arr = Array.from({ length: N }, () => Array(N).fill("."));
  let x = 0,
    y = 0;
  let dir = { U: [-1, 0], D: [1, 0], L: [0, -1], R: [0, 1] };

  function updateCell(x, y, move) {
    if (move === "U" || move === "D") {
      if (arr[x][y] === ".") arr[x][y] = "|";
      else if (arr[x][y] === "-") arr[x][y] = "+";
    } else {
      if (arr[x][y] === ".") arr[x][y] = "-";
      else if (arr[x][y] === "|") arr[x][y] = "+";
    }
  }

  for (let move of moves) {
    let [dx, dy] = dir[move];
    let nx = x + dx;
    let ny = y + dy;

    if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
      updateCell(x, y, move);
      x = nx;
      y = ny;
      updateCell(x, y, move);
    }
  }

  for (let i = 0; i < N; i++) {
    console.log(arr[i].join(""));
  }
});
