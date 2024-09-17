import java.io.*;

public class Main {

	private static String PATTERN_FIRST;
	private static String PATTERN_END;
	private static final String YES = "DA";
	private static final String NO = "NE";

	private static String solution(String currentFileName) {

		int fileNameLength = currentFileName.length();

		if (fileNameLength < PATTERN_FIRST.length() + PATTERN_END.length()) {
			return NO;
		}

		for (int currentIndex = 0; currentIndex < PATTERN_FIRST.length(); currentIndex++) {
			if (PATTERN_FIRST.charAt(currentIndex) != currentFileName.charAt(currentIndex)) {
				return NO;
			}
		}

		int fileStartIndex = fileNameLength - PATTERN_END.length();

		for (int index = 0; index < PATTERN_END.length(); index++) {
			if (PATTERN_END.charAt(index) != currentFileName.charAt(index + fileStartIndex)) {
				return NO;
			}
		}

		return  YES;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int size = Integer.parseInt(br.readLine());
		String[] pattern = br.readLine().split("[*]| ");
		PATTERN_FIRST = pattern[0];
		PATTERN_END = pattern[1];

		StringBuilder sb = new StringBuilder();
		for (int tryCount = 0; tryCount < size; tryCount++) {
			String currentFileName = br.readLine();
			sb.append(solution(currentFileName)).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}