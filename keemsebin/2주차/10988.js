const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];

rl.on("line", function (line) {
  input.push(line);
}).on("close", function () {
  let str = input[0];
  let reverseStr = str.split("").reverse().join("");

  if (str === reverseStr) {
    console.log(1);
  } else {
    console.log(0);
  }
});
