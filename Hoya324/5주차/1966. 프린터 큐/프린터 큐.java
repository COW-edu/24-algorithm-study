import java.io.*;
import java.util.*;

public class Main {
	
	private static final int IMPORTANCE = 0; 
	private static final int INIT_INDEX = 1; 

	private static int solution(BufferedReader br) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int length = Integer.parseInt(st.nextToken());
		int targetIndex = Integer.parseInt(st.nextToken());

		// 큐에 문서들의 중요도와 초기 위치를 함께 저장
		Queue<int[]> queue = new LinkedList<>();
		String[] temp = br.readLine().split(" ");
		for (int i = 0; i < length; i++) {
			int[] importanceAndInitPoint = {Integer.parseInt(temp[i]), i};
			queue.add(importanceAndInitPoint);
		}

		// 중요도를 내림차순으로 정렬하는 우선순위 큐
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
		for (String doc : temp) {
			priorityQueue.add(Integer.parseInt(doc));
		}

		int order = 0;
		while (!queue.isEmpty()) {
			int[] current = queue.poll();

			// 현재 문서가 가장 높은 중요도를 가지는 경우 출력
			if (current[IMPORTANCE] == priorityQueue.peek()) {
				order++;
				priorityQueue.poll(); // 해당 중요도 제거
				if (current[INIT_INDEX] == targetIndex) {
					return order;
				}
			} else {
				// 중요도가 높지 않으면 다시 큐의 끝에 추가
				queue.add(current);
			}
		}
		return 0;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int count = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < count; i++) {
			sb.append(solution(br)).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}