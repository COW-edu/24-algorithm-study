import java.util.*;
import java.io.*;

public class Main {

	private static final int TOTAL_FLOWER_COUNT = 3;
	private static final int[] dx = {0, 0, -1, 1};
	private static final int[] dy = {-1, 1, 0, 0};
	private static int answer = Integer.MAX_VALUE;
	private static int[][] flowerBedCost;
	private static boolean[][] visited;
	private static int length;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		length = Integer.parseInt(br.readLine());

		flowerBedCost = new int[length][length];
		visited = new boolean[length][length];
		StringTokenizer st;
		for (int i = 0; i < length; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < length; j++) {
				flowerBedCost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		DFS(0, 0);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

	static void DFS(int depth, int sum) {
		if (sum >= answer) {
			return; // 현재까지의 합이 이미 최소 비용보다 크면 종료
		}

		if (depth == TOTAL_FLOWER_COUNT) { // 문제상 종료 조건
			answer = Math.min(sum, answer);
		} else {
			// 각 위치를 탐색하여 꽃을 심기
			for (int i = 1; i < length - 1; i++) {
				for (int j = 1; j < length - 1; j++) {
					if (isNotVisited(j, i)) {
						int cost = calculateCost(j, i);
						DFS(depth + 1, sum + cost);
						clearVisit(j, i);
					}
				}
			}
		}
	}

	static boolean isNotVisited(int x, int y) {
		// 꽃의 주변 위치가 방문된 상태인지 확인
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (visited[ny][nx]) {
				return false; // 주변에 이미 심어진 꽃이 있는 경우
			}
		}
		return true; // 심을 수 있는 경우
	}

	static int calculateCost(int x, int y) {
		int currentCost = flowerBedCost[y][x];
		visited[y][x] = true; // 현재 위치 방문 처리
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			currentCost += flowerBedCost[ny][nx]; // 주변 비용 계산
			visited[ny][nx] = true; // 주변 위치 방문 처리
		}
		return currentCost; // 총 비용 반환
	}

	static void clearVisit(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			visited[ny][nx] = false; // 방문 기록 초기화
		}
		visited[y][x] = false; // 현재 위치 방문 기록 초기화
	}
}