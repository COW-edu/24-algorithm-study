const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];

rl.on("line", function (line) {
  input.push(line);
}).on("close", function () {
  let N = parseInt(input[0]);
  let arr = input.slice(1);

  let row = [];
  let col = [];

  for (let i = 0; i < N; i++) {
    let rowCnt = 0;
    for (let j = 0; j < N; j++) {
      if (arr[i][j] === ".") {
        rowCnt++;
      } else {
        if (rowCnt >= 2) {
          row.push(rowCnt);
        }
        rowCnt = 0;
      }
    }
    if (rowCnt >= 2) {
      row.push(rowCnt);
    }
  }

  for (let i = 0; i < N; i++) {
    let colCnt = 0;
    for (let j = 0; j < N; j++) {
      if (arr[j][i] === ".") {
        colCnt++;
      } else {
        if (colCnt >= 2) {
          col.push(colCnt);
        }
        colCnt = 0;
      }
    }
    if (colCnt >= 2) {
      col.push(colCnt);
    }
  }

  console.log(row.length, col.length);
});
