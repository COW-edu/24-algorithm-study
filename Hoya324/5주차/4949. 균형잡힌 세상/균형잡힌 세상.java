import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	private static final String NO = "no";
	private static final String YES = "yes";
	private static final char LEFT_PARENTHESES = '(';
	private static final char RIGHT_PARENTHESES = ')';
	private static final char LEFT_SQUARE_BRACKET = '[';
	private static final char RIGHT_SQUARE_BRACKET = ']';
	private static final String FULL_STOP = ".";

	private static String solution(String word) {
		Deque<Character> stack = new ArrayDeque<>();

		for (int i = 0; i < word.length() - 1; i++) {
			char currentCharUnit = word.charAt(i);

			if (currentCharUnit == LEFT_PARENTHESES) {
				stack.push(LEFT_PARENTHESES);
			} else if (currentCharUnit == LEFT_SQUARE_BRACKET) {
				stack.push(LEFT_SQUARE_BRACKET);
			} else if (currentCharUnit == RIGHT_PARENTHESES) {
				if (!stack.isEmpty() && stack.peek() == LEFT_PARENTHESES) {
					stack.pop();
				} else {
					return NO;
				}
			} else if (currentCharUnit == RIGHT_SQUARE_BRACKET) {
				if (!stack.isEmpty() && stack.peek() == LEFT_SQUARE_BRACKET) {
					stack.pop();
				} else {
					return NO;
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

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		while (true){
			String nowWord = br.readLine();
			if (nowWord.equals(FULL_STOP)) {
				break;
			}
			sb.append(solution(nowWord)).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}