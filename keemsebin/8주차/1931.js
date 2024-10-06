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
  let meeting = input.slice(1).map((item) => item.split(" ").map(Number));
  meeting.sort((a, b) => {
    if (a[1] === b[1]) {
      return a[0] - b[0];
    }
    return a[1] - b[1];
  });

  let result = 0;
  let temp = 0;
  meeting.forEach((item) => {
    if (temp <= item[0]) {
      temp = item[1];
      result++;
    }
  });

  console.log(result);
});
