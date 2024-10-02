import java.util.Scanner;

public class Main {
	static int N;
	static int[][] W;
	static boolean[] visited;
	static int minCost = Integer.MAX_VALUE;

	static void DFS(int currentCity, int visitedCityCount, int currentCost, int start) {
		if (minCost < currentCost) {
			return;
		}

		if (visitedCityCount == N) {
			if (W[currentCity][start] != 0) {
				minCost = Math.min(minCost, currentCost + W[currentCity][start]);
			}
			return;
		}

		// 모든 도시를 순회하며 DFS 탐색
		for (int i = 0; i < N; i++) {
			if (!visited[i] && W[currentCity][i] != 0) {
				visited[i] = true;
				DFS(i, visitedCityCount + 1, currentCost + W[currentCity][i], start); // 다음 도시로 이동
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		W = new int[N][N];
		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				W[i][j] = sc.nextInt();
			}
		}

		visited[0] = true;
		DFS(0, 1, 0, 0);

		System.out.println(minCost);
	}

}