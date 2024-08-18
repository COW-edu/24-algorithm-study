import java.util.*;
import java.io.*;

public class Main {

	private static String solution(char[][] chars, int N) {
		String answer = "";

		int horizontal = 0;
		int vertical = 0;
		for (int i = 0; i < N; i++) {
			int checkHorizontal = 0;
			int checkVertical = 0;

			for (int j = 0; j < N; j++) {
				if (chars[i][j] == '.') {
					checkHorizontal++;
				}
				if (chars[i][j] == 'X' || j == N-1) {
					if (checkHorizontal >= 2) horizontal++;
					checkHorizontal = 0;
				}

				if (chars[j][i] == '.') {
					checkVertical++;
				}
				if (chars[j][i] == 'X' || j == N-1) {
					if (checkVertical >= 2) vertical++;
					checkVertical = 0;
				}
			}
		}
		answer += horizontal + " " + vertical;

		return answer;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[][] inputs = getInput(br, N);
		String result = solution(inputs, N);
		resolve(result);
	}

	private static char[][] getInput(BufferedReader br, int N) throws IOException {
		char[][] map = new char[101][101];

		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j=0; j < N; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		return map;
	}

	private static void resolve(String answer) throws IOException {
		try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
			bw.write(String.valueOf(answer));
		}
	}
}
