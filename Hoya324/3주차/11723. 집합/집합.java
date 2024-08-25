import java.io.*;
import java.util.*;

public class Main {
	private final static String ADD = "add";
	private final static String REMOVE = "remove";
	private final static String CHECK = "check";
	private final static String TOGGLE = "toggle";
	private final static String ALL = "all";
	private final static String EMPTY = "empty";

	private static String solution(int M, BufferedReader br) throws IOException {
		boolean[] set = new boolean[21];
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int value;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			switch (command) {
				case ADD:
					value = Integer.parseInt(st.nextToken());
					set[value] = true;
					break;
				case REMOVE:
					value = Integer.parseInt(st.nextToken());
					set[value] = false;
					break;
				case CHECK:
					value = Integer.parseInt(st.nextToken());
					if (set[value]) {
						sb.append(1);
					} else {
						sb.append(0);
					}
					sb.append("\n");
					break;
				case TOGGLE:
					value = Integer.parseInt(st.nextToken());
					set[value] = !set[value];
					break;
				case ALL:
					boolean[] trueSet = new boolean[21];
					Arrays.fill(trueSet, true);
					set = trueSet.clone();
					break;
				case EMPTY:
					boolean[] emptySet = new boolean[21];
					set = emptySet.clone();
					break;
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int M = Integer.parseInt(br.readLine());

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(solution(M, br)));
		bw.flush();
		bw.close();
	}
}