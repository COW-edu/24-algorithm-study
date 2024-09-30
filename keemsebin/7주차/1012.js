const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];

rl.on("line", function (line) {
  input.push(line);
}).on("close", function () {
  let T = Number(input[0]);
  let index = 1;
  let result = [];
  let count = 0;

  const dir = [
    [-1, 0],
    [1, 0],
    [0, 1],
    [0, -1],
  ];

  // 인접 관계를 알아내기 위한 방법
  // 방문한 적이 없으며 & 배추가 심어져 있는 땅을 값이 존재할때까지 탐색을 진행한다.
  const dfs = (x, y, arr, isVisited, M, N) => {
    isVisited[x][y] = true;
    for ([dx, dy] of dir) {
      const nx = x + dx;
      const ny = y + dy;
      if (
        nx >= 0 &&
        ny >= 0 &&
        nx < M &&
        ny < N &&
        !isVisited[nx][ny] &&
        arr[nx][ny]
      ) {
        dfs(nx, ny, arr, isVisited, M, N);
      }
    }
  };

  for (let i = 0; i < T; i++) {
    let [M, N, K] = input[i + index].split(" ").map(Number);
    let arr = Array.from({ length: M }, () => Array(N).fill(false));
    let isVisited = Array.from({ length: M }, () => Array(N).fill(false));

    for (let j = 1; j <= K; j++) {
      let [x, y] = input[i + j + index].split(" ");
      arr[x][y] = true;
    }

    // 방문한 이력이 없으며 & 배추가 심어져 있는 땅인 경우 dfs 통해 탐색 후 count를 증가시켜준다.
    for (let z = 0; z < M; z++) {
      for (y = 0; y < N; y++) {
        if (!isVisited[z][y] && arr[z][y]) {
          dfs(z, y, arr, isVisited, M, N);
          count++;
        }
      }
    }
    result.push(count);
    count = 0;
    index += K;
  }

  console.log(result.join("\n"));
});
