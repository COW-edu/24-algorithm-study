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

  //  11655
  let result = "";
  for (let i = 0; i < str.length; i++) {
    let ascii = str.charCodeAt(i);
    if (ascii >= 65 && ascii <= 90) {
      ascii += 13;
      if (ascii > 90) {
        ascii -= 26;
      }
    } else if (ascii >= 97 && ascii <= 122) {
      ascii += 13;
      if (ascii > 122) {
        ascii -= 26;
      }
    }
    result += String.fromCharCode(ascii);
  }

  console.log(result);
});
