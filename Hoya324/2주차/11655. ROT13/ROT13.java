import java.io.*;

public class Main {
	private static String solution(String str) {
		StringBuilder answer = new StringBuilder();

		for (int i = 0; i < str.length(); i++) {
			char currentChar = str.charAt(i);

			if (Character.isUpperCase(currentChar)) {
				char shifted = (char) ((currentChar - 'A' + 13) % 26 + 'A');
				answer.append(shifted);
			} else if (Character.isLowerCase(currentChar)) {
				char shifted = (char) ((currentChar - 'a' + 13) % 26 + 'a');
				answer.append(shifted);
			} else {
				answer.append(currentChar);
			}
		}

		return answer.toString();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(solution(str));
		bw.flush();
		bw.close();
	}
}