const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];

rl.on("line", function (line) {
  input.push(line);
}).on("close", function () {
  let arr = [];
  let gather = ["a", "e", "i", "o", "u"];

  // 모음을 포함하는지 확인하는 함수
  const isGather = (item) => {
    return gather.some((v) => item.includes(v));
  };

  // 모음/자음이 연속으로 3번 오는지 확인하는 함수
  const sequence = (item) => {
    for (let i = 0; i < item.length - 2; i++) {
      let count = 0;
      for (let j = 0; j < 3; j++) {
        if (gather.includes(item[i + j])) {
          count++;
        }
      }
      if (count === 3 || count === 0) {
        return false;
      }
    }
    return true;
  };

  // 같은 글자가 연속으로 두번 오는지 확인하는 함수
  const isDouble = (item) => {
    for (let i = 0; i < item.length - 1; i++) {
      if (item[i] === item[i + 1] && item[i] !== "e" && item[i] !== "o") {
        return true;
      }
    }
    return false;
  };

  for (let item of input) {
    if (item === "end") {
      break;
    }
    let isAccepted = false;
    if (isGather(item) && sequence(item) && !isDouble(item)) {
      isAccepted = true;
    }
    let message = isAccepted ? "acceptable." : "not acceptable.";
    arr.push("<" + item + "> is " + message);
  }
  console.log(arr.join("\n"));
});
