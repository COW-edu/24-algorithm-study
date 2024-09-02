const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];

rl.on("line", function (line) {
  input.push(line);
}).on("close", function () {
  let [N, K] = input[0].split(" ").map(Number);

  let score = [];

  for (let i = 1; i <= N; i++) {
    let [num, a, b, c] = input[i].split(" ").map(Number);
    score.push({ num, a, b, c });
  }

  score.sort((a, b) => {
    if (a.a !== b.a) {
      return b.a - a.a;
    }
    if (a.b !== b.b) {
      return b.b - a.b;
    }
    return b.c - a.c;
  });

  let rank = 1;

  for (let i = 0; i < N; i++) {
    if (score[i].num === K) {
      console.log(rank);
      break;
    }
    if (
      i < N - 1 &&
      score[i].a === score[i + 1].a &&
      score[i].b === score[i + 1].b &&
      score[i].c === score[i + 1].c
    ) {
      continue;
    }
    rank++;
  }
});
