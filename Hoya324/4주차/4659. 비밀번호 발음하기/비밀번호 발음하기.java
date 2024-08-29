import java.io.*;
import java.util.*;

public class Main {

	private final static String ACCEPTABLE_COMMENT_FORMAT = "<%s> is acceptable.";
	private final static String NOT_ACCEPTABLE_COMMENT_FORMAT = "<%s> is not acceptable.";
	private final static List<Character> VOWELS = List.of('a', 'e', 'i', 'o', 'u');

	private static String solution(String input) {
		boolean isAcceptable = true;
		List<String> stringList = List.of(input.split(""));
		for (int i = 0; i < 5; i++) {
			if (stringList.contains(VOWELS.get(i).toString())) {
				isAcceptable = true;
				break;
			}
			isAcceptable = false;
		}

		if (!isAcceptable) {
			return String.format(NOT_ACCEPTABLE_COMMENT_FORMAT, input);
		}


		int vowelsCount = 0;
		int consonantsCount = 0;
		for (int i = 0; i < input.length(); i++) {
			if (VOWELS.contains(input.charAt(i))) {
				vowelsCount++;
				consonantsCount = 0;
			} else {
				consonantsCount++;
				vowelsCount = 0;
			}

			if (vowelsCount == 3 || consonantsCount == 3) {
				isAcceptable = false;
				break;
			}

			if (i > 0 && input.charAt(i-1) == input.charAt(i) && (input.charAt(i) != 'e' && input.charAt(i) != 'o')) {
				isAcceptable = false;
				break;
			}

		}

		if (!isAcceptable) {
			return String.format(NOT_ACCEPTABLE_COMMENT_FORMAT, input);
		}



		return String.format(ACCEPTABLE_COMMENT_FORMAT, input);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		while (true) {
			String input = br.readLine();
			if (input.equals("end")) {
				break;
			}
			sb.append(solution(input)).append("\n");
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}