import java.io.*;
import java.util.*;

public class Main {
	private static int solution(int N, int[] days, int[] pays) {
		int[] greedy = new int[N+2];

		for (int today = 1; today < N+1; ++today) {
			int future = today + days[today];
			if (future <= N+1) {
				greedy[future] = Math.max(greedy[future], greedy[today] + pays[today]);
			}
			greedy[today + 1] = Math.max(greedy[today], greedy[today + 1]);
		}

		return greedy[N+1];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] days = new int[N+1];
		int[] pays = new int[N+1];
		StringTokenizer st;
		for (int i = 1; i < N+1; i++) {
			st = new StringTokenizer(br.readLine());
			days[i] = Integer.parseInt(st.nextToken());
			pays[i] = Integer.parseInt(st.nextToken());
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(solution(N, days, pays)));
		bw.flush();
		bw.close();
	}
}