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
  let arr = input.slice(1);
  let result = [];

  for (let i = 0; i < N; i++) {
    let str = arr[i];
    let num = "";

    for (let j = 0; j <= str.length; j++) {
      if (j < str.length && str[j] >= "0" && str[j] <= "9") {
        num += str[j];
      } else {
        if (num.length > 0) {
          result.push(BigInt(num));
          num = "";
        }
      }
    }
  }

  /*
   * BigInt의 경우 직접적인 뺄셈 연산 불가능
   * a < b이면 -1을 반환 -> a를 b앞에 위치
   * a > b이면 1을 반환 -> a를 b뒤에 위치
   * a === b이면 0을 반환 -> a와 b의 위치 변경 x
   */

  result.sort((a, b) => {
    if (a < b) return -1;
    if (a > b) return 1;
    return 0;
  });

  console.log(result.map((num) => num.toString()).join("\n"));
});
