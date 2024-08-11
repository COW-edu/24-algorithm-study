import java.util.*;
import java.io.*;

public class Main {

	private static int solution(int[] nums, int T) {
		Arrays.sort(nums);
		int answer = nums[T-1] - nums[0];
		return answer;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] input = getInput(br);
		resolve(solution(input, T));
	}

	private static int[] getInput(BufferedReader br) throws IOException {
		int[] nums = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();
		return nums;
	}

	private static void resolve(int answer) throws IOException {
		try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
			bw.write(String.valueOf(answer));
		}
	}
}