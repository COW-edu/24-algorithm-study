import java.util.*;
import java.io.*;

public class Main {
	public static int k;
	public static String[] signs;
	public static boolean[] visited;
	public static List<String> results = new ArrayList<>();

	private static void DFS(int count, String num) {
		if (count == k + 1) {
			results.add(num);
			return;
		}

		for (int i = 0; i <= 9; i++) {
			if (!visited[i]) {
				if (count == 0 || checkCondition(num.charAt(count - 1) - '0', i, signs[count - 1])) {  // 부등호 조건을 만족한다면
					visited[i] = true;
					DFS(count + 1, num + i);
					visited[i] = false;
				}
			}
		}
	}

	private static boolean checkCondition(int a, int b, String sign) {
		if (sign.equals("<")) {
			return a < b;
		} else {
			return a > b;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		k = Integer.parseInt(br.readLine());
		signs = br.readLine().split(" ");
		visited = new boolean[10];

		DFS(0, "");
		
		Collections.sort(results);
		System.out.println(results.get(results.size() - 1)); 
		System.out.println(results.get(0));
	}
}