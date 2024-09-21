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
  let arr = input.slice(1).map((item) => item.split(" ").map(Number));
  const check = new Array(N).fill(false);

  let teamNum = N / 2;
  let minDiff = Infinity;

  const calculateTeamScore = (team) => {
    let score = 0;
    for (let i = 0; i < team.length; i++) {
      for (let j = i + 1; j < team.length; j++) {
        score += arr[team[i]][team[j]] + arr[team[j]][team[i]];
      }
    }
    return score;
  };

  const dfs = (idx, count) => {
    if (count === teamNum) {
      let startTeam = [];
      let linkTeam = [];

      for (let i = 0; i < N; i++) {
        if (check[i]) {
          startTeam.push(i);
        } else {
          linkTeam.push(i);
        }
      }

      let startScore = calculateTeamScore(startTeam);
      let linkScore = calculateTeamScore(linkTeam);
      let diff = Math.abs(startScore - linkScore);
      minDiff = Math.min(minDiff, diff);
      return;
    }

    for (let i = idx; i < N; i++) {
      if (!check[i]) {
        check[i] = true;
        dfs(i + 1, count + 1);
        check[i] = false;
      }
    }
  };

  dfs(0, 0);
  console.log(minDiff);
});
