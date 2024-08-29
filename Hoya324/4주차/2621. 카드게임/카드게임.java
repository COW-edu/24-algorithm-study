import java.io.*;
import java.util.*;

public class Main {
	private static int solution(List<String> colors, List<Integer> numbers) {
		List<Integer> numberCount = new ArrayList<>(List.of(0, 0, 0, 0, 0, 0, 0, 0, 0, 0));

		for (int i = 0; i < 5; i++) {
			int numberCountIndex = numbers.get(i);
			numberCount.set(numberCountIndex, numberCount.get(numberCountIndex) + 1);
		}

		int continuousNumberCount = 1;
		int maxContinuousNumberCount = 1;
		for (int i = 1; i < 10; i++) {
			if (i + 1 < 10 && numberCount.get(i) != 0 && numberCount.get(i + 1) != 0) {
				maxContinuousNumberCount++;
				continue;
			}
			if (continuousNumberCount < maxContinuousNumberCount) {
				continuousNumberCount = maxContinuousNumberCount;
			}
			maxContinuousNumberCount = 1;
		}

		Set<String> colorSet = new HashSet<>(colors);
		boolean isAllSameColor = 1 == colorSet.size();

		Collections.sort(numbers);

		if (isAllSameColor) {
			if (continuousNumberCount == 5) {
				return 900 + numbers.get(4);
			}
			return 600 + numbers.get(4);
		}

		if (numberCount.contains(4)) {
			return 800 + numberCount.indexOf(4);
		}

		if (numberCount.contains(3)) {
			if (numberCount.contains(2)) {
				return 700 + (numberCount.indexOf(3) * 10) + numberCount.indexOf(2);
			}
			return 400 + numberCount.indexOf(3);
		}

		if (continuousNumberCount == 5) {
			return 500 + numbers.get(4);
		}

		long sameNumberCount = numberCount.stream().filter((count) -> count == 2).count();
		int[] twoSameNumberCount = { numberCount.indexOf(2), numberCount.lastIndexOf(2) };
		if (sameNumberCount == 2) {
			if (twoSameNumberCount[0] > twoSameNumberCount[1]) {
				return 300 + twoSameNumberCount[1] + (twoSameNumberCount[0] * 10);
			}
			return 300 + twoSameNumberCount[0] + (twoSameNumberCount[1] * 10);
		}

		if (sameNumberCount == 1) {
			return 200 + numberCount.indexOf(2);
		}

		return 100 + numbers.get(4);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		List<String> colors = new ArrayList<>();
		List<Integer> numbers = new ArrayList<>();
		StringTokenizer st;
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			colors.add(st.nextToken());
			numbers.add(Integer.parseInt(st.nextToken()));
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(solution(colors, numbers)));
		bw.flush();
		bw.close();
	}
}