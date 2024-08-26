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
  let arr = [];
  for (let i = 0; i < N; i++) {
    let [age, name] = input[i + 1].split(" ");
    arr.push({ age, name });
  }
  arr.sort((a, b) => a.age - b.age);

  console.log(arr.map((el) => `${el.age} ${el.name}`).join("\n"));
});
