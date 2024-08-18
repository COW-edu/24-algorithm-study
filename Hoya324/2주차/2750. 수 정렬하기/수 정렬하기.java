import java.util.*;
import java.io.*;

public class Main {

	private static List<Integer> solution(int[] nums) {
		List<Integer> answer;
		Set<Integer> numsSet = new HashSet<>();
		for (int i : nums) {
			numsSet.add(i);
		}
		answer = new ArrayList<>(numsSet);
		Collections.sort(answer);
		return answer;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] inputs = getInput(br);
		List<Integer> results = solution(inputs);
		StringBuilder sb = new StringBuilder();
		for (int i : results) {
			sb.append(i).append("\n");
		}
		resolve(sb.toString());
	}

	private static int[] getInput(BufferedReader br) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		return nums;
	}

	private static void resolve(String answer) throws IOException {
		try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
			bw.write(String.valueOf(answer));
		}
	}
}
