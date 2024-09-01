import java.io.*;
import java.util.*;

public class Main {

	private static String solution(int problemCount, Map<String, Integer> poketmonMap,
		Map<Integer, String> poketmonNumberMap, String[] problemPocketmon) {
		StringBuilder sb = new StringBuilder();
		for (String target : problemPocketmon) {
			if (Character.isDigit(target.charAt(0))) {
				sb.append(poketmonNumberMap.get(Integer.parseInt(target))).append("\n");
				continue;
			}
			sb.append(poketmonMap.get(target)).append("\n");
		}
		return sb.toString();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int pocketmonCount = Integer.parseInt(st.nextToken());
		int problemCount = Integer.parseInt(st.nextToken());

		Map<String, Integer> poketmonMap = new HashMap<>();
		Map<Integer, String> poketmonNumberMap = new HashMap<>();

		for (int i = 0; i < pocketmonCount; i++) {
			String name = br.readLine();
			poketmonMap.put(name, i + 1);
			poketmonNumberMap.put(i + 1, name);
		}

		String[] problemPocketmon = new String[problemCount];
		for (int i = 0; i < problemCount; i++) {
			problemPocketmon[i] = br.readLine();
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(solution(problemCount, poketmonMap, poketmonNumberMap, problemPocketmon));
		bw.flush();
		bw.close();
	}
}