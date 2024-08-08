import java.io.*;
import java.util.Arrays;

public class Main {

	private static int solution(int[] nums) {
        Arrays.sort(nums);
        
        int answer = 0;
        if (nums[0] == nums[1] && nums[1] == nums[2]) {
            answer += (nums[0] * 1000);
            answer += 10000;
            return answer;
        } 
        if (nums[0] == nums[1]) {
            answer += (nums[0] * 100);
            answer += 1000;
            return answer;
        }
        if (nums[1] == nums[2]) {
            answer += (nums[1] * 100);
            answer += 1000;
            return answer;
        }
        answer += nums[2] * 100;
        return answer;
	}

	public static void main(String[] args) throws IOException {
		int[] input = getInput();
		resolve(solution(input));
	}

	private static int[] getInput() throws IOException {
		int[] input;
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int[] nums = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
			input = nums;
		}
		return input;
	}

	private static void resolve(int answer) throws IOException {
		try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
			bw.write(String.valueOf(answer));
		}
	}
}