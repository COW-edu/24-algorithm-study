const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];

rl.on("line", function (line) {
  input.push(line);
}).on("close", function () {
  input = input.join("");
  let ans = [];
  let temp = "";
  let isTag = false;
  for (let i = 0; i < input.length; i++) {
    const char = input[i];
    // 괄호 존재 그대로 push
    if (char === "<") {
      ans.push(temp);
      ans.push("<");
      temp = "";
      isTag = true;
      // 괄호 존재 그대로 push
    } else if (char === ">") {
      ans.push(">");
      isTag = false;
    } else {
      // 괄호 안의 문자열은 그대로 Push
      if (isTag) {
        ans.push(char);
      } else {
        if (char === " ") {
          ans.push(temp);
          temp += " ";
          ans.push(" ");
          temp = "";
        } else {
          temp = char + temp;
        }
      }
    }
  }

  ans.push(temp);
  console.log(ans.join(""));
});
