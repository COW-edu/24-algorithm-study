import java.io.*;
import java.util.Arrays;

public class Main {

    static class Input {
        int numOfCards;
        int targetNumber;
        int[] numberCards;

        Input(int numOfCards, int targetNumber, int[] numberCards) {
            this.numOfCards = numOfCards;
            this.targetNumber = targetNumber;
            this.numberCards = numberCards;
        }
    }

    static class Output {
        int closedCombinationNumber;

        Output(int closedCombinationNumber) {
            this.closedCombinationNumber = closedCombinationNumber;
        }
    }

    public static void main(String[] args) throws IOException {
        Input input = getInput();
        Output output = solve(input);
        resolve(output);
    }

    private static Input getInput() throws IOException {
        Input input;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] nm = br.readLine().split(" ");
            int[] numberCards = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            input = new Input(Integer.parseInt(nm[0]), Integer.parseInt(nm[1]), numberCards);
        }
        return input;
    }

    private static void resolve(Output output) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(String.valueOf(output.closedCombinationNumber));
        }
    }

    private static Output solve(Input input) {
        int closedCombinationNumber = -1;

        for (int i = 0; i < input.numOfCards; i++) {
            for (int j = i + 1; j < input.numOfCards; j++) {
                for (int k = j + 1; k < input.numOfCards; k++) {
                    int number = input.numberCards[i] + input.numberCards[j] + input.numberCards[k];
                    if (number == input.targetNumber) {
                        return new Output(number);
                    }
                    if (closedCombinationNumber < number && number < input.targetNumber) {
                        closedCombinationNumber = number;
                    }
                }
            }
        }

        return new Output(closedCombinationNumber);
    }

}
