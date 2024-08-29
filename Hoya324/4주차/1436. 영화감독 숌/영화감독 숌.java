import java.io.*;

public class Main {

	private final static String TARGET_TITLE = "666";

	private static String solution(int N) {
		int count = 0;
		int title = 666;

		while (true) {
			if (String.valueOf(title).contains(TARGET_TITLE)) {
				count++;
			}

			if (count == N) {
				break;
			}
			title++;
		}
		return String.valueOf(title);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(solution(N));
		bw.flush();
		bw.close();
	}
}