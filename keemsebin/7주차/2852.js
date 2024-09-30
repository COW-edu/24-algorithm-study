const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];

function formatTime(minutes, seconds) {
  if (seconds >= 60) {
    minutes += Math.floor(seconds / 60);
    seconds = seconds % 60;
  }
  return `${String(minutes).padStart(2, "0")}:${String(seconds).padStart(
    2,
    "0"
  )}`;
}

rl.on("line", function (line) {
  input.push(line);
}).on("close", function () {
  let N = Number(input[0]);

  let aTime = 0;
  let bTime = 0;
  let lastTime = 0;
  let score1 = 0;
  let score2 = 0;

  function timeToSeconds(time) {
    const [mm, ss] = time.split(":").map(Number);
    return mm * 60 + ss;
  }

  function secondsToTime(seconds) {
    const mm = Math.floor(seconds / 60);
    const ss = seconds % 60;
    return formatTime(mm, ss);
  }

  for (let i = 1; i <= N; i++) {
    let [team, time] = input[i].split(" ");
    let currentTime = timeToSeconds(time);

    if (score1 > score2) {
      aTime += currentTime - lastTime;
    } else if (score2 > score1) {
      bTime += currentTime - lastTime;
    }

    if (team === "1") {
      score1++;
    } else if (team === "2") {
      score2++;
    }

    lastTime = currentTime;
  }

  const endTime = timeToSeconds("48:00");

  if (score1 > score2) {
    aTime += endTime - lastTime;
  } else if (score2 > score1) {
    bTime += endTime - lastTime;
  }

  console.log(secondsToTime(aTime));
  console.log(secondsToTime(bTime));
});
