import java.io.*;
import java.util.*;

public class Main {

	private final static int GOLD_POINT = 3;
	private final static int SILVER_POINT = 2;

	private static int solution(int countryCount, int targetCountry, int[][] numberOfMedalsByCountry) {
		int[] winningPoints = new int[countryCount+1];
		for (int i = 0; i < countryCount; i++) {
			int currentCountry = numberOfMedalsByCountry[i][0];
			winningPoints[currentCountry] = numberOfMedalsByCountry[currentCountry-1][1] * GOLD_POINT;
			winningPoints[currentCountry] += numberOfMedalsByCountry[currentCountry-1][2] * SILVER_POINT;
			winningPoints[currentCountry] += numberOfMedalsByCountry[currentCountry-1][3];
		}
		int winnerPoint = winningPoints[targetCountry];

		Arrays.sort(winningPoints);
		int rank = 1;
		int rankCount = 1;
		winningPoints[0] = 0;
		for (int rankIndex = countryCount; rankIndex >= 1; rankIndex--) {
			rankCount++;
			if (rankIndex + 1 < countryCount && winningPoints[rankIndex + 1] == winningPoints[rankIndex]) {
				continue;
			}
			if (winningPoints[rankIndex] == winnerPoint) {
				break;
			}
			rank = rankCount;
		}
		return rank;
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int countryCount = Integer.parseInt(st.nextToken());
		int targetIndex = Integer.parseInt(st.nextToken()) - 1;

		int[][] numberOfMedalsByCountry = new int[countryCount][4];
		for (int i = 0; i < countryCount; i++) {
			numberOfMedalsByCountry[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(solution(countryCount, numberOfMedalsByCountry[targetIndex][0], numberOfMedalsByCountry)));
		bw.flush();
		bw.close();
	}
}