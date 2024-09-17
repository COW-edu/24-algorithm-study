import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int testCaseCount = Integer.parseInt(br.readLine());
		while (testCaseCount-- > 0) {
			int n = Integer.parseInt(br.readLine());
			Map<String, Integer> clothingMap = new HashMap<>();

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String item = st.nextToken();
				String category = st.nextToken();

				clothingMap.put(category, clothingMap.getOrDefault(category, 0) + 1);
			}

			int result = 1;
			for (int count : clothingMap.values()) {
				result *= (count + 1);
			}

			result--;
			bw.write(result + "\n");
		}

		bw.flush();
		bw.close();
	}
}