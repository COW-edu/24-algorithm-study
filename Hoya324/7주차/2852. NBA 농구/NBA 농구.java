import java.io.*;
import java.util.*;

class Time {
	private int totalSec;

	public Time() {
		this.totalSec = 0;
	}

	public void addSec(int addedSec) {
		this.totalSec += addedSec;
	}

	public int getTotalSec() {
		return totalSec;
	}

	public void setTotalSec(final int totalSec) {
		this.totalSec = totalSec;
	}

	public static int MMSSToSec(String time) {
		String[] temp = time.split(":");
		return Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
	}

	public String toString() {
		int min = getTotalSec() / 60;
		int sec = getTotalSec() % 60;
		return String.format("%02d:%02d", min, sec);
	}
}

public class Main {

	private static final String TEAM_ONE = "1";
	private static final String TEAM_TWO = "2";
	private static final int TEAM_INDEX = 0;
	private static final int TIME_INDEX = 1;
	private static final int GAME_TIME_SEC = 48 * 60;

	private static String solution(int size, String[][] scoreTime) {

		int oneTeamScore = 0;
		int twoTeamScore = 0;
		Time oneTeamWinningTime = new Time();
		Time twoTeamWinningTime = new Time();
		Time currentTime = new Time();

		for (int memoCount = 0; memoCount < size; memoCount++) {
			String team = scoreTime[memoCount][TEAM_INDEX];
			String timeStr = scoreTime[memoCount][TIME_INDEX];
			
			int timeDiff = Time.MMSSToSec(timeStr) - currentTime.getTotalSec();
			
			if (oneTeamScore > twoTeamScore) {
				oneTeamWinningTime.addSec(timeDiff);
			} else if (twoTeamScore > oneTeamScore) {
				twoTeamWinningTime.addSec(timeDiff);
			}
			
			if (team.equals(TEAM_ONE)) {
				oneTeamScore++;
			} else {
				twoTeamScore++;
			}
			
			currentTime.setTotalSec(Time.MMSSToSec(timeStr));
		}
		
		int remainingTime = GAME_TIME_SEC - currentTime.getTotalSec();
		if (oneTeamScore > twoTeamScore) {
			oneTeamWinningTime.addSec(remainingTime);
		} else if (twoTeamScore > oneTeamScore) {
			twoTeamWinningTime.addSec(remainingTime);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(oneTeamWinningTime.toString()).append("\n");
		sb.append(twoTeamWinningTime.toString()).append("\n");

		return sb.toString();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int size = Integer.parseInt(br.readLine());
		String[][] scoreTime = new String[size][2];
		for (int inedx = 0; inedx < size; inedx++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			scoreTime[inedx][0] = st.nextToken();
			scoreTime[inedx][1] = st.nextToken();
		}

		bw.write(solution(size, scoreTime));
		bw.flush();
		bw.close();
	}
}