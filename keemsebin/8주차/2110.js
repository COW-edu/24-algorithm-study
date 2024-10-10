const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];

rl.on("line", function (line) {
  input.push(line);
}).on("close", function () {
  let [N, C] = input[0].split(" ").map(Number);
  let distance = input.slice(1).map(Number);
  distance.sort((a, b) => a - b);

  let start = 1;
  let end = distance[distance.length - 1] - distance[0];
  let result = 0;

  while (start <= end) {
    const mid = Math.floor((start + end) / 2);

    let count = 1;
    let prev = distance[0];
    for (const dis of distance) {
      if (dis - prev < mid) continue;
      prev = dis;
      count += 1;
    }

    if (count < C) end = mid - 1;
    else {
      start = mid + 1;
      result = mid;
    }
  }

  console.log(result);
});
