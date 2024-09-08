import java.io.*;
import java.util.*;

public class Main {

	private static int solution(int neededToMaterials, int[] nums) {
		Arrays.sort(nums);
		int start = 0;
		int end = nums.length - 1;
		int result = 0;
		while (start < end) {
			if (nums[start] + nums[end] < neededToMaterials) {
				start++;
			} else if (nums[start] + nums[end] > neededToMaterials) {
				end--;
			} else {
				result++;
				start++;
				end--;
			}
		}

		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		br.readLine();
		int neededToMaterials = Integer.parseInt(br.readLine());

		int[] nums = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(solution(neededToMaterials, nums)));
		bw.flush();
		bw.close();
	}
}