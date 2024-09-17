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
  let arr = input[1].split(" ").map(Number);

  let i = N - 2;
  while (i >= 0 && arr[i] <= arr[i + 1]) {
    i--;
  }

  if (i === -1) {
    console.log(-1);
    return;
  }

  let j = N - 1;
  while (arr[i] <= arr[j]) {
    j--;
  }

  [arr[i], arr[j]] = [arr[j], arr[i]];

  let left = i + 1;
  let right = N - 1;

  while (left < right) {
    [arr[left], arr[right]] = [arr[right], arr[left]];
    left++;
    right--;
  }

  console.log(arr.join(" "));
});
