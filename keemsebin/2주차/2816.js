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
  let result = "";

  let posKBS1 = arr.indexOf("KBS1");
  let posKBS2 = arr.indexOf("KBS2");
  posKBS2 = posKBS1 > posKBS2 ? ++posKBS2 : posKBS2;

  for (let i = 0; i < posKBS1; i++) {
    result += "1";
  }
  for (let i = 0; i < posKBS1; i++) {
    result += "4";
  }

  for (let i = 0; i < posKBS2; i++) {
    result += "1";
  }
  for (let i = 0; i < posKBS2 - 1; i++) {
    result += "4";
  }

  console.log(result);
});
