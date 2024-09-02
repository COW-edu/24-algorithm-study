const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];

rl.on("line", function (line) {
  input.push(line);
}).on("close", function () {
  let score = [];

  for (let i = 0; i < 5; i++) {
    let [color, size] = input[i].split(" ");
    score.push({ color, size: parseInt(size) });
  }

  let colorCount = {};
  let sizeCount = {};

  for (let i = 0; i < 5; i++) {
    colorCount[score[i].color] = (colorCount[score[i].color] || 0) + 1;
    sizeCount[score[i].size] = (sizeCount[score[i].size] || 0) + 1;
  }

  let maxSizeCount = Math.max(...Object.values(sizeCount));

  let isFlush = Object.keys(colorCount).length === 1;
  let sizes = Object.keys(sizeCount)
    .map(Number)
    .sort((a, b) => a - b);

  let uniqueSizes = [...new Set(sizes)];
  let isStraight =
    uniqueSizes.length === 5 && uniqueSizes[4] - uniqueSizes[0] === 4;

  let highCard = Math.max(...sizes);

  if (isStraight && isFlush) {
    console.log(900 + highCard);
  } else if (maxSizeCount === 4) {
    let fourKindValue = Object.keys(sizeCount).find(
      (key) => sizeCount[key] === 4
    );
    console.log(800 + parseInt(fourKindValue));
  } else if (maxSizeCount === 3 && Object.keys(sizeCount).length === 2) {
    let threeKindValue = Object.keys(sizeCount).find(
      (key) => sizeCount[key] === 3
    );

    let secondKindValue = Object.keys(sizeCount).find(
      (key) => sizeCount[key] === 2
    );
    console.log(
      700 + parseInt(secondKindValue) + parseInt(threeKindValue) * 10
    );
  } else if (isFlush) {
    console.log(600 + highCard);
  } else if (isStraight) {
    console.log(500 + highCard);
  } else if (maxSizeCount === 3) {
    let threeKindValue = Object.keys(sizeCount).find(
      (key) => sizeCount[key] === 3
    );
    console.log(400 + parseInt(threeKindValue));
  } else if (
    maxSizeCount === 2 &&
    Object.values(sizeCount).filter((count) => count === 2).length === 2
  ) {
    let pairValues = Object.keys(sizeCount)
      .filter((key) => sizeCount[key] === 2)
      .map(Number)
      .sort((a, b) => b - a);
    console.log(300 + pairValues[0] * 10 + pairValues[1]);
  } else if (maxSizeCount === 2) {
    let pairValue = Object.keys(sizeCount).find((key) => sizeCount[key] === 2);
    console.log(200 + parseInt(pairValue));
  } else {
    console.log(100 + highCard);
  }
});
