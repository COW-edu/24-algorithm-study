import java.io.*;
import java.util.*;

public class Main {
	private final static int LINE_SIZE = 6;

	private static int solution(int K, List<Integer> lengths) {
		int totalField = -1;

		int sumOfProductsOfAdjacentSides = 0;
		for (int i = 0; i < LINE_SIZE; i++) {
			int nextIndex = (i + 1) % LINE_SIZE;

			int currentField = lengths.get(i) * lengths.get(nextIndex);
			sumOfProductsOfAdjacentSides += currentField;
			if (totalField < currentField) {
				totalField = currentField;
			}
		}

		int melonField = sumOfProductsOfAdjacentSides - (2 * totalField);

		return melonField * K;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		List<Integer> lengths = new ArrayList<>();

		StringTokenizer st;
		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			lengths.add(Integer.parseInt(st.nextToken()));
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(solution(K, lengths)));
		bw.flush();
		bw.close();
	}
}