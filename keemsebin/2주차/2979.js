const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];

rl.on("line", function (line) {
  input.push(line);
}).on("close", function () {
  let [A, B, C] = input[0].split(" ").map(Number);
  let parkingLot = new Array(101).fill(0);

  for (let i = 1; i <= 3; i++) {
    let [start, end] = input[i].split(" ").map(Number);
    for (let j = start; j < end; j++) {
      parkingLot[j]++;
    }
  }

  let totalFee = 0;
  for (let i = 0; i < 101; i++) {
    if (parkingLot[i] === 1) totalFee += A;
    else if (parkingLot[i] === 2) totalFee += B * 2;
    else if (parkingLot[i] === 3) totalFee += C * 3;
  }
  console.log(totalFee);
});
