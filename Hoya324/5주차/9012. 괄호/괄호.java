import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	private static final String NO = "NO";
	private static final String YES = "YES";
	private static final char RIGHT_PARENTHESES = ')';

	private static String solution(String parentheses) {
		Deque<Character> stack = new ArrayDeque<>();

		for (int index = 0; index < parentheses.length(); index++) {
			char currentParentheses = parentheses.charAt(index);
			if (stack.isEmpty()) {
				if (currentParentheses == RIGHT_PARENTHESES) {
					return NO;
				}
				stack.push(currentParentheses);
			} else {
				if (currentParentheses != stack.peek()) {
					stack.pop();
				} else {
					stack.push(currentParentheses);
				}
			}
		}

		if (stack.isEmpty()) {
			return YES;
		}
		return NO;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCase = Integer.parseInt(br.readLine());

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < testCase; i++) {
			sb.append(solution(br.readLine())).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}