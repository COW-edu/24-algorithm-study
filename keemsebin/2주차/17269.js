const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];

rl.on("line", function (line) {
  input.push(line);
}).on("close", function () {
  const [N, M] = input[0].split(" ").map(Number);
  const [A, B] = input[1].split(" ");

  let result = 0;

  const alphabet = [
    3, 2, 1, 2, 4, 3, 1, 3, 1, 1, 3, 1, 3, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2,
    1,
  ];

  let combineName = "";
  let minLen = Math.min(N, M);

  for (let i = 0; i < minLen; i++) {
    combineName += A[i] + B[i];
  }

  combineName += A.slice(minLen) + B.slice(minLen);

  let nameLen = combineName.length;

  let score = [];

  for (let i = 0; i < nameLen; i++) {
    score.push(alphabet[combineName[i].charCodeAt() - "A".charCodeAt()]);
  }

  while (score.length > 2) {
    let temp = [];

    for (let i = 0; i < score.length - 1; i++) {
      temp.push((score[i] + score[i + 1]) % 10);
    }

    score = temp;
  }

  result = score[0] * 10 + score[1];
  console.log(result + "%");
});
