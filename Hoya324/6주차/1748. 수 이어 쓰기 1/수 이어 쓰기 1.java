import java.io.*;

public class Main {

	private static final int MAX_DIGIT = 9;
	private static final int BASE = 10;

	private static int calculateDigitSum(String number) {
		int numberLength = number.length();
		
		if (numberLength == 1) {
			return Integer.parseInt(number);
		}

		int result = 0;
		int cumulativeNumbers = 0;
		int currentStep;

		for (int i = 1; i <= numberLength; i++) {
			if (i == numberLength) {
				result += (Integer.parseInt(number) - cumulativeNumbers) * i;
				break;
			}

			currentStep = MAX_DIGIT * (int) Math.pow(BASE, i - 1);
			cumulativeNumbers += currentStep;
			result += currentStep * i;
		}

		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inputNumber = br.readLine();
		bw.write(String.valueOf(calculateDigitSum(inputNumber)));
		bw.flush();
		bw.close();
	}
}