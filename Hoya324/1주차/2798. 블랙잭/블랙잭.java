import java.util.*;
import java.io.*;

public class Main {

	private static int solution(int[] nums, int N, int M) {
		Arrays.sort(nums);
		int answer = 0;
		for (int j = N-1; j >= 2; j--) {
			for (int i = j-1; i > 0; i--) {
				for (int k = i-1; k >= 0; k --) {
					int sumCard = nums[j] + nums[i] + nums[k];
					if (sumCard < M && sumCard > answer) {
						answer = sumCard;
					}
					if (sumCard == M) {
						answer = sumCard;
						return answer;
					}
				}
			}
		}
		return answer;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		int[] input = getInput(br);
		resolve(solution(input, N, M));
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