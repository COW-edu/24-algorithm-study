import java.util.*;
import java.io.*;

public class Main {

	private static int solution(int[] nums) {
		int answer = 0;
		if (nums[0] == 0) {
			answer += 0;
		} else if (nums[0] >= 1 && nums[0] < 2) {
			answer += 5000000;
		} else if (nums[0] >= 2 && nums[0] < 4) {
			answer += 3000000;
		} else if (nums[0] >= 4  && nums[0] < 7) {
			answer += 2000000;
		} else if (nums[0] >= 7 && nums[0] < 11) {
			answer += 500000;
		} else if (nums[0] >= 11 && nums[0] < 16) {
			answer += 300000;
		} else if (nums[0] >= 16 && nums[0] < 22) {
			answer += 100000;
		}

		if (nums[1] == 0) {
			answer += 0;
			return answer;
		}
		if (nums[1] < 2) {
			answer += 5120000;
			return answer;
		}
		if (nums[1] < 4) {
			answer += 2560000;
			return answer;
		}
		if (nums[1] < 8) {
			answer += 1280000;
			return answer;
		}
		if (nums[1] < 16) {
			answer += 640000;
			return answer;
		}
		if (nums[1] < 32) {
			answer += 320000;
			return answer;
		}

		return answer;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			int[] input = getInput(br);
			sb.append(solution(input)).append("\n");
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