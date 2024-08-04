import java.io.*;

public class Main {

	private static int[] solution(String words) {
		int[] answer = new int[26];
		for (int i = 0; i < words.length(); i++) {
			int index = words.charAt(i) - 'a';
			answer[index]++;
		}
		return answer;
	}

	public static void main(String[] args) throws IOException {
		String input = getInput();
		StringBuilder sb = new StringBuilder();
		int[] result = solution(input);
		for (int num : result) {
			sb.append(num).append(" ");
		}
		resolve(sb.toString());
	}

	private static String getInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		return br.readLine();
	}

	private static void resolve(String answer) throws IOException {
		try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
			bw.write(answer);
		}
	}
}