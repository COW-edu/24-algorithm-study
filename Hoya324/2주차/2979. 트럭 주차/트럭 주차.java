import java.util.*;
import java.io.*;

public class Main {

	private static int solution(int[] charge, int[][] inputs) {
		int	result = 0;
		Arrays.sort(inputs, (o1, o2) -> {
			if (o1[0] == o2[0]) {
				return o1[1] - o2[1];
			}
			return o1[0] - o2[0];
		});

		int maxNum = -1;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2; j++) {
				if (inputs[i][j] > maxNum) {
					maxNum = inputs[i][j];
				}
			}
		}
		int minNum =  inputs[0][0];
		int weight = -1;
		for (int time = minNum; time < maxNum; time++) {
			for (int check = 0; check < 3; check++) {
				if (inputs[check][0] == time) {
					weight++;
				}
				if (inputs[check][1] == (time)) {
					weight--;
				}
			}
			
			if (weight >= 0) {
				result += (charge[weight] * (weight + 1));
			}
		}
		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] charges = getInput(br);
		int[][] inputs = new int[3][2];
		for (int i = 0; i < 3; i++) {
			int[] input = getInput(br);
			inputs[i] = input;
		}
		resolve(solution(charges, inputs));
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
