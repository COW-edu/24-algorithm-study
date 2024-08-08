import java.util.*;
import java.io.*;

public class Main {

	private static int[] solution(int[] nums) {
		Arrays.sort(nums);
		int nineSum = Arrays.stream(nums).sum();

		int[] answer = new int[9];
		for (int i = 0; i < 9; i++) {
			for (int j = i + 1; j < 9; j++) {
				if (nineSum - (nums[i] + nums[j]) == 100) {
					int exceptNanjangOne = nums[i];
					int exceptNanjangTwo = nums[j];;

					answer = Arrays.stream(nums)
						.filter((num) -> ((num != exceptNanjangOne) && (num != exceptNanjangTwo)))
						.toArray();
				}
			}
		}

		return answer;
	}

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		int[] input = getInput();
		int[] result = solution(input);
		for (int i = 0; i < 7; i++) {
			sb.append(result[i]).append("\n");
		}
		resolve(sb.toString());
	}

	private static int[] getInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] nums = new int[9];
		for (int i = 0; i < 9; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		return nums;
	}

	private static void resolve(String answer) throws IOException {
		try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
			bw.write(answer);
		}
	}
}
