import java.util.*;
import java.io.*;

public class Main {

	private static final int[] dy = {-1, 1, 0, 0};
	private static final int[] dx = {0, 0, -1, 1};
	private static boolean[][] visited;
	private static int[][] field;
	private static int colLength;
	private static int rowLength;

	private static int solution() {
		int totalCount = 0;

		for (int row = 0; row < rowLength; row++) {
			for (int col = 0; col < colLength; col++) {
				if (visited[row][col]) {
					continue;
				}
				if (field[row][col] == 1) {
					DFS(col, row);
					totalCount++;
				}
			}
		}
		return totalCount;
	}

	private static void DFS(int x, int y) {
		visited[y][x] = true;

		for (int direction = 0; direction < 4; direction++) {
			int nextY = y + dy[direction];
			int nextX = x + dx[direction];
			if (nextX < 0 || nextY < 0 || nextX >= colLength || nextY >= rowLength) {
				continue;
			}
			if (!visited[nextY][nextX] && field[nextY][nextX] == 1) {
				DFS(nextX, nextY);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int testCase = 0; testCase < T; testCase++) {
			st = new StringTokenizer(br.readLine());
			colLength = Integer.parseInt(st.nextToken());
			rowLength = Integer.parseInt(st.nextToken());
			int target = Integer.parseInt(st.nextToken());

			field = new int[rowLength][colLength];
			visited = new boolean[rowLength][colLength];
			for (int i = 0; i < rowLength; i++) {
				Arrays.fill(field[i], 0);
				Arrays.fill(visited[i], false);
			}
			for (int i = 0; i < target; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				field[y][x] = 1;
			}

			sb.append(solution()).append("\n");
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}