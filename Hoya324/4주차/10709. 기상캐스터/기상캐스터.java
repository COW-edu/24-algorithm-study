import java.io.*;
import java.util.*;

public class Main {

	private static String solution(int height, int width, int[][] map) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < height; i++) {
			int cloudStep = -1;
			for (int j = 0; j < width; j++) {
				int currentMapUnit = map[i][j];
				if (currentMapUnit == 0) {
					cloudStep = 1;
					continue;
				}
				if (cloudStep < 0) {
					continue;
				}
				if (currentMapUnit < 0 && cloudStep > 0) {
					map[i][j] = cloudStep;
					cloudStep++;
				}
			}
		}

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}

		return sb.toString();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int height = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());
		int[][] map = new int[height][width];

		for (int i = 0; i < height; i++) {
			String[] row = br.readLine().split("");
			for (int j = 0; j < width; j++) {
				String nowMapUnit = row[j];
				if (nowMapUnit.equals(".")) {
					map[i][j] = -1;
					continue;
				}
				map[i][j] = 0;
			}
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(solution(height, width, map));
		bw.flush();
		bw.close();
	}
}