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
  let isVisited = Array.from({ length: N }, () => Array(N).fill(false));
  let dir = [
    [-1, 0],
    [0, -1],
    [0, 1],
    [1, 0],
  ];
  let min = Infinity;

  // 상하좌우를 비교하며 조건에 하나라도 해당하면 false, 그렇지 않다면 true를 반환하여
  // 꽃의 중심점을 찾음
  const findLocation = (i, j) => {
    if (isVisited[i][j]) return false;
    for (let [dx, dy] of dir) {
      const curX = i + dx;
      const curY = j + dy;
      if (
        curX < 0 ||
        curY < 0 ||
        curX >= N ||
        curY >= N ||
        isVisited[curX][curY]
      ) {
        return false;
      }
    }
    return true;
  };

  // 씨앗을 심기 위해, 현재 + 상하좌우 값을 true로 설정
  // 백트래킹을 위해 방문 후에는 현재+상하좌우 값을 다시 false로 설정
  const visited = (x, y, place) => {
    isVisited[x][y] = place;

    for (let [dx, dy] of dir) {
      let nx = x + dx;
      let ny = y + dy;
      isVisited[nx][ny] = place;
    }
  };

  const dfs = (totalCost, count) => {
    // 종료 조건.
    if (count === 3) {
      min = Math.min(min, totalCost);
      return;
    }

    // 가장자리를 제외하고 중첩 for문을 돌려준다.
    // 씨앗의 중심 + 상하좌우 값을을 더하여 cost 측정
    // cost+totalCost 값을 통해 누적
    // 완전 탐색을 통해 모든 경우를 봐야하기 때문에 visited 함수를 통해 방문여부를 체크한다.
    for (let i = 1; i < N - 1; i++) {
      for (let j = 1; j < N - 1; j++) {
        if (findLocation(i, j)) {
          let cost = arr[i][j];
          for (let [dx, dy] of dir) {
            cost += arr[i + dx][j + dy];
          }
          visited(i, j, true);
          dfs(totalCost + cost, count + 1);
          visited(i, j, false);
        }
      }
    }
  };

  dfs(0, 0);
  console.log(min);
});
