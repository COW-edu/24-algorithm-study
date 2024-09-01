const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];

rl.on("line", function (line) {
  input.push(line);
}).on("close", function () {
  let N = input[0].split(""); // 문자열을 배열로 변환
  let count = {};

  // 알파벳 별로 개수 세기
  N.forEach((element) => {
    count[element] = (count[element] || 0) + 1;
  });

  let odd = 0;
  let oddChar = "";

  // 사전순으로 키 정렬
  const sortedKeys = Object.keys(count).sort();

  // 홀수 개수의 문자가 몇 개인지 체크
  for (let key of sortedKeys) {
    if (count[key] % 2 === 1) {
      odd++;
      oddChar = key;
    }
  }

  if (odd > 1) {
    console.log("I'm Sorry Hansoo");
    return;
  }

  let arr = Array(N.length).fill("");
  let idx = 0;

  // 정렬된 키에 따라 팰린드롬 절반 생성
  for (let key of sortedKeys) {
    let halfCount = Math.floor(count[key] / 2);
    for (let i = 0; i < halfCount; i++) {
      arr[idx] = key;
      arr[N.length - idx - 1] = key;
      idx++;
    }
  }

  // 만약 홀수 개의 문자가 있으면 중앙에 배치
  if (odd === 1) {
    arr[Math.floor(N.length / 2)] = oddChar;
  }

  console.log(arr.join(""));
});
