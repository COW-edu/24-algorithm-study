import java.io.*;
import java.util.*;

public class Main {
	private static String solution(int[][] members) {
		Arrays.sort(members, (o1, o2) -> {
			return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
		});
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < members.length; i++) {
			sb.append(members[i][0]).append(" ").append(members[i][1]).append("\n");
		}
		return sb.toString();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] members = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			members[i][0] = Integer.parseInt(st.nextToken());
			members[i][1] = Integer.parseInt(st.nextToken());
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(solution(members)));
		bw.flush();
		bw.close();
	}
}