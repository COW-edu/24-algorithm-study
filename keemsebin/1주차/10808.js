const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];

rl.on("line", function (line) {
  input.push(line);
}).on("close", function () {
  let alphabet = new Array(26).fill(0);
  let word = input[0].split("");

  word.forEach((char) => {
    alphabet[char.charCodeAt(0) - 97]++;
  });

  console.log(alphabet.join(" "));
});
