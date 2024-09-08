import java.io.*;
import java.util.*;

public class Main {

	private static int solution(String currentWord) {
		Deque<Character> stack = new ArrayDeque<>();
		stack.push(currentWord.charAt(0));
		for (int index = 1; index < currentWord.length(); index++) {
			if (stack.isEmpty() || stack.peek() != currentWord.charAt(index)) {
				stack.push(currentWord.charAt(index));
			} else {
				stack.pop();
			}
		}

		if (stack.isEmpty()) {
			return 1;
		}
		return 0;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int wordCount = Integer.parseInt(br.readLine());

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int result = 0;
		for (int i = 0; i < wordCount; i++) {
			result += solution(br.readLine());
		}
		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
	}
}