import java.util.*;
import java.io.*;

public class Main {

	private static final int LOTTO_COUNT = 6;

	public static int k;
	public static int[] s;
	public static boolean[] visited;
	public static List<String> results = new ArrayList<>();

	private static void DFS(int start, int count, StringBuilder currentLotto) {
		if (count == LOTTO_COUNT) {
			results.add(currentLotto.toString());
			return;
		}

		for (int i = start; i < k; i++) {
			if (!visited[i]) {
				visited[i] = true;
				int len = currentLotto.length();
				currentLotto.append(s[i]).append(" ");

				DFS(i + 1, count + 1, currentLotto);

				visited[i] = false;
				currentLotto.setLength(len);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());

			if (k == 0) break;

			s = new int[k];
			visited = new boolean[k];

			for (int i = 0; i < k; i++) {
				s[i] = Integer.parseInt(st.nextToken());
			}

			results.clear();
			DFS(0, 0, new StringBuilder());

			for (String result : results) {
				output.append(result).append("\n");
			}

			output.append("\n");
		}

		System.out.print(output);
	}
}