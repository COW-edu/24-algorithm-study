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
  let [start, end] = input[1].split("*");
  let result = [];
  let files = input.slice(2);

  for (let i = 0; i < N; i++) {
    let file = files[i].trim();

    if (file.length < start.length + end.length) {
      result.push("NE");
      continue;
    }
    if (file.startsWith(start) && file.endsWith(end)) {
      let middleLength = file.length - start.length - end.length;
      if (middleLength >= 0) {
        result.push("DA");
      } else {
        result.push("NE");
      }
    } else {
      result.push("NE");
    }
  }
  console.log(result.join("\n"));
});
