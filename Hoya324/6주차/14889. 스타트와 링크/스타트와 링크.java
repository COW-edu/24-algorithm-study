import java.io.*;
import java.util.StringTokenizer;

public class Main {
	private static int peopleCount;
	private static int[][] synergy;
	private static boolean[] isSelected;
	private static int minDiff = Integer.MAX_VALUE;

	public static int backtracking(int depth, int currentPerson) {
		if (depth == peopleCount / 2) {
			int diff = calculateAbilityDifference();
			minDiff = Math.min(minDiff, diff);
			return minDiff;
		}

		for (int nextPerson = currentPerson; nextPerson < peopleCount; nextPerson++) {
			if (!isSelected[nextPerson]) {
				isSelected[nextPerson] = true;
				backtracking(depth + 1, nextPerson + 1);
				isSelected[nextPerson] = false;
			}
		}
		return minDiff;
	}

	public static int calculateAbilityDifference() {
		int startTeamAbility = 0;
		int linkTeamAbility = 0;

		for (int personA = 0; personA < peopleCount; personA++) {
			for (int personB = 0; personB < peopleCount; personB++) {
				if (isSelected[personA] && isSelected[personB]) {
					startTeamAbility += synergy[personA][personB];
				} else if (!isSelected[personA] && !isSelected[personB]) {
					linkTeamAbility += synergy[personA][personB];
				}
			}
		}

		return Math.abs(startTeamAbility - linkTeamAbility);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		peopleCount = Integer.parseInt(br.readLine());
		synergy = new int[peopleCount][peopleCount];
		isSelected = new boolean[peopleCount];

		StringTokenizer st;
		for (int personA = 0; personA < peopleCount; personA++) {
			st = new StringTokenizer(br.readLine());
			for (int personB = 0; personB < peopleCount; personB++) {
				synergy[personA][personB] = Integer.parseInt(st.nextToken());
			}
		}

		bw.write(String.valueOf(backtracking(0, 0)));
		bw.flush();
		bw.close();
	}
}