import java.util.*;
import java.io.*;

public class Main {

	private static int solution(String str) {
		int strSize = str.length();
		int strHalfSize = strSize / 2;
		Deque<Character> stack = new ArrayDeque<>();
		for (int i = 0; i < strHalfSize; i++) {
			stack.push(str.charAt(i));
		}

		int compareStartNum;
		if (strSize % 2 == 0) {
			compareStartNum = strHalfSize;
		} else {
			compareStartNum = strHalfSize + 1;
		}

		int answer = 1;
		for (int i = compareStartNum; i < strSize; i++) {
			if (stack.pop() != str.charAt(i)) {
				answer = 0;
				break;
			}
		}
		return answer;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		resolve(solution(str));
	}

	private static void resolve(int answer) throws IOException {
		try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
			bw.write(String.valueOf(answer));
		}
	}
}
