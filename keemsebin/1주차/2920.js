const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];

rl.on("line", function (line) {
  input.push(line);
}).on("close", function () {
  let pitches = input[0].split(" ").map(Number);
  let result;

  for (let i = 0; i < pitches.length - 1; i++) {
    if (pitches[i] < pitches[i + 1]) {
      if (result === "descending") {
        result = "mixed";
        break;
      }
      result = "ascending";
    } else if (pitches[i] > pitches[i + 1]) {
      if (result === "ascending") {
        result = "mixed";
        break;
      }
      result = "descending";
    }
  }
  console.log(result);
});
