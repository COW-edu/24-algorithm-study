import java.io.*;

public class Main {

    static class Input {
        int numOfCase;
        int[] guessFirstCodeFestivalRanks;
        int[] guessSecondCodeFestivalRanks;

        Input(int numOfCase, int[] guessFirstCodeFestivalRanks, int[] guessSecondCodeFestivalRanks) {
            this.numOfCase = numOfCase;
            this.guessFirstCodeFestivalRanks = guessFirstCodeFestivalRanks;
            this.guessSecondCodeFestivalRanks = guessSecondCodeFestivalRanks;
        }
    }

    static class Output {
        int[] calculatedRewards;

        Output(int[] calculatedRewards) {
            this.calculatedRewards = calculatedRewards;
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
            String str = br.readLine();
            int numOfCase = Integer.parseInt(str);
            int[] guessFirstCodeFestivalRanks = new int[numOfCase];
            int[] guessSecondCodeFestivalRanks = new int[numOfCase];
            for (int i = 0; i < numOfCase; i++) {
                String[] ranks = br.readLine().split(" ");
                guessFirstCodeFestivalRanks[i] = Integer.parseInt(ranks[0]);
                guessSecondCodeFestivalRanks[i] = Integer.parseInt(ranks[1]);
            }
            input = new Input(numOfCase, guessFirstCodeFestivalRanks, guessSecondCodeFestivalRanks);
        }
        return input;
    }

    private static void resolve(Output output) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            for (int reward : output.calculatedRewards) {
                bw.write(String.valueOf(reward));
                bw.newLine();
            }
        }
    }

    private static Output solve(Input input) {
        int[] rewards = new int[input.numOfCase];
        for (int i = 0; i < input.numOfCase; i++) {
            int reward = 0;
            reward += getFirstCodeFestivalReward(input.guessFirstCodeFestivalRanks[i]);
            reward += getSecondCodeFestivalReward(input.guessSecondCodeFestivalRanks[i]);
            rewards[i] = reward;
        }
        return new Output(rewards);
    }

    private static int getFirstCodeFestivalReward(int guessRank) {
        if (guessRank == 0) {
            return 0;
        }
        if (guessRank == 1) {
            return 5_000_000;
        }
        if (guessRank <= 3) {
            return 3_000_000;
        }
        if (guessRank <= 6) {
            return 2_000_000;
        }
        if (guessRank <= 10) {
            return 500_000;
        }
        if (guessRank <= 15) {
            return 300_000;
        }
        if (guessRank <= 21) {
            return 100_000;
        }
        return 0;
    }

    private static int getSecondCodeFestivalReward(int guessRank) {
        if (guessRank == 0) {
            return 0;
        }
        if (guessRank == 1) {
            return 5_120_000;
        }
        if (guessRank <= 3) {
            return 2_560_000;
        }
        if (guessRank <= 7) {
            return 1_280_000;
        }
        if (guessRank <= 15) {
            return 640_000;
        }
        if (guessRank <= 31) {
            return 320_000;
        }
        return 0;
    }
}
