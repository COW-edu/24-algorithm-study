import java.io.*;

public class Main {

	private final static int ALPHABET_COUNT = 26;
	private final static String FAIL_RESULT = "I'm Sorry Hansoo";

	private static String solution(String name) {
		int[] alphabet = new int[ALPHABET_COUNT];
		int nameLength = name.length();
		for (int i = 0; i < nameLength; i++) {
			alphabet[name.charAt(i) - 'A']++;
		}

		int center = 0;
		int odd = 0;
		for (int i = 0; i < ALPHABET_COUNT; i++) {
			if (alphabet[i] % 2 != 0) {
				center = i;
				odd++;
			}
		}

		if (odd > 1 || (odd == 1 && nameLength % 2 == 0)) {
			return FAIL_RESULT;
		}

		StringBuilder sb = new StringBuilder();

		String result = "";
		for (int i = 0; i < ALPHABET_COUNT; i++) {
			for (int j = 0; j < alphabet[i] / 2; j++) {
				sb.append((char)(i + 'A'));
			}
		}

		result += sb.toString();
		String back = sb.reverse().toString();

		if (odd == 1) {
			result += (char)(center + 'A');
		}
		result += back;
		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String name = br.readLine();

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(solution(name));
		bw.flush();
		bw.close();
	}
}