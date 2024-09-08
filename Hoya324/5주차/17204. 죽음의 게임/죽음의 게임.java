import java.io.*;
import java.util.*;

public class Main {

	private static boolean[] visits;
	private static int[] persons;
	private static int result = 0;

	private static int solution(int target) {
		return dfs(persons[0], target);
	}

	private static int dfs(int person, int target) {
		if (visits[person]) {
			return -1;
		}
		result++;
		if (person == target) {
			return result;
		}
		visits[person] = true;
		return dfs(persons[person], target);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int personCount = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());

		initDFS(personCount, br);

		bw.write(String.valueOf(solution(target)));
		bw.flush();
		bw.close();
	}

	private static void initDFS(final int personCount, final BufferedReader br) throws IOException {
		visits = new boolean[personCount];
		Arrays.fill(visits, false);
		visits[0] = true;
		persons = new int[personCount];

		for (int index = 0; index < personCount; index++) {
			persons[index] = Integer.parseInt(br.readLine());
		}
	}
}