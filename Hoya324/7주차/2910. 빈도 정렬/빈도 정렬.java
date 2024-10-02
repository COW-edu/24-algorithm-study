import java.io.*;
import java.util.*;

public class Main {

	private static String solution(int size, List<Integer> list) {
		Map<Integer, Integer> frequencyMap = new HashMap<>();
		Map<Integer, Integer> firstIndexMap = new HashMap<>();
		
		for (int i = 0; i < list.size(); i++) {
			int num = list.get(i);
			frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
			firstIndexMap.putIfAbsent(num, i);
		}
		
		list.sort((o1, o2) -> {
			int freqCompare = Integer.compare(frequencyMap.get(o2), frequencyMap.get(o1));
			if (freqCompare == 0) {
				return Integer.compare(firstIndexMap.get(o1), firstIndexMap.get(o2));
			}
			return freqCompare;
		});

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < size; i++) {
			sb.append(list.get(i)).append(" ");
		}

		return sb.toString();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int size = Integer.parseInt(st.nextToken());
		st.nextToken();

		st = new StringTokenizer(br.readLine());
		List<Integer> list = new ArrayList<>();
		for (int index = 0; index < size; index++) {
			int currentNum = Integer.parseInt(st.nextToken());
			list.add(currentNum);
		}

		bw.write(solution(size, list));
		bw.flush();
		bw.close();
	}
}