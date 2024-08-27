const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];

rl.on("line", function (line) {
  input.push(line);
}).on("close", function () {
  const K = parseInt(input[0]);
  const sides = input.slice(1).map((line) => line.split(" ").map(Number));

  let maxWidth = 0,
    maxHeight = 0;
  let maxWidthIndex = 0,
    maxHeightIndex = 0;

  for (let i = 0; i < 6; i++) {
    const [direction, length] = sides[i];
    if (direction <= 2 && length > maxWidth) {
      maxWidth = length;
      maxWidthIndex = i;
    } else if (direction > 2 && length > maxHeight) {
      maxHeight = length;
      maxHeightIndex = i;
    }
  }

  const smallWidth = Math.abs(
    sides[(maxHeightIndex + 5) % 6][1] - sides[(maxHeightIndex + 1) % 6][1]
  );
  const smallHeight = Math.abs(
    sides[(maxWidthIndex + 5) % 6][1] - sides[(maxWidthIndex + 1) % 6][1]
  );

  const area = (maxWidth * maxHeight - smallWidth * smallHeight) * K;

  console.log(area);
});
