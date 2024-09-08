import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	private static final String PUSH = "+";
	private static final String POP = "-";
	private static final String NO = "NO";

	private static String solution(int count, int[] nums) {
		Deque<Integer> stack = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		int currentNumber = 1;

		for (int target : nums) {
			while (currentNumber <= target) {
				stack.push(currentNumber);
				currentNumber++;
				sb.append(PUSH).append("\n");
			}

			if (stack.peek() == target) {
				stack.pop();
				sb.append(POP).append("\n");
			}
		}

		if (!stack.isEmpty()) {
			return NO;
		}
 		return sb.toString();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int count = Integer.parseInt(br.readLine());
		int[] nums = new int[count];
		for (int i = 0; i < count; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		bw.write(solution(count, nums));
		bw.flush();
		bw.close();
	}
}