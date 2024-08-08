import java.util.*;
import java.io.*;

public class Main {

	private static int[] solution(int[] nums) {
		int numsSize = nums.length;
		int[] answer = new int[numsSize];
		for (int i = 0; i < numsSize; i++) {
			answer[i] = nums[i] * (i + 1) - Arrays.stream(Arrays.copyOfRange(answer, 0, i)).sum();
		}

		return answer;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] input = getInput(br);
		StringBuilder sb = new StringBuilder();
		for (int i : solution(input)) {
			sb.append(i).append(" ");
		}
		resolve(sb.toString());
	}

	private static int[] getInput(BufferedReader br) throws IOException {
		int[] nums = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();
		return nums;
	}

	private static void resolve(String answer) throws IOException {
		try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
			bw.write(answer);
		}
	}
}