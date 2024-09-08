import java.io.*;
import java.util.*;

public class Main {

	private static final char LEFT_MOVE = '<';
	private static final char RIGHT_MOVE = '>';
	private static final char BACKSPACE = '-';

	private static String solution(String keyLog) {
		Deque<Character> left = new LinkedList<>();
		Deque<Character> right = new LinkedList<>();

		for (int keyIndex = 0; keyIndex < keyLog.length(); keyIndex++) {
			char key = keyLog.charAt(keyIndex);

			if (key == LEFT_MOVE) {
				if (!left.isEmpty()) {
					right.offerFirst(left.pollLast());
				}
			} else if (key == RIGHT_MOVE) {
				if (!right.isEmpty()) {
					left.offerLast(right.pollFirst());
				}
			} else if (key == BACKSPACE) {
				if (!left.isEmpty()) {
					left.pollLast();
				}
			} else {
				left.offerLast(key);
			}
		}

		StringBuilder sb = new StringBuilder();
		for (char ch : left) {
			sb.append(ch);
		}
		for (char ch : right) {
			sb.append(ch);
		}
		return sb.toString();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int count = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < count; i++) {
			sb.append(solution(br.readLine())).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}