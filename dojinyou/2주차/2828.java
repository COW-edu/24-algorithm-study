import java.io.*;

public class Main {

    static class Input {
        int screenSize;
        int bucketSize;
        int[] dropPositions;


        Input(int screenSize, int bucketSize, int[] dropPositions) {
            this.screenSize = screenSize;
            this.bucketSize = bucketSize;
            this.dropPositions = dropPositions;
        }
    }

    static class Output {
        int minMove;

        Output(int minMove) {
            this.minMove = minMove;
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
            String[] sizes = br.readLine().split(" ");
            int droppedAppleCount = Integer.parseInt(br.readLine());
            int[] dropPositions = new int[droppedAppleCount];
            for (int i = 0; i < droppedAppleCount; i++) {
                dropPositions[i] = Integer.parseInt(br.readLine());
            }
            input = new Input(Integer.parseInt(sizes[0]), Integer.parseInt(sizes[1]), dropPositions);
        }
        return input;
    }

    private static void resolve(Output output) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(String.valueOf(output.minMove));
        }
    }

    private static Output solve(Input input) {
        int moveCount = 0;

        int minBucketPosition = 1;
        int maxBucketPosition = input.bucketSize;

        for (int position: input.dropPositions) {
            if (position < minBucketPosition) {
                int diff = minBucketPosition - position;
                moveCount += diff;
                maxBucketPosition = maxBucketPosition - diff;
            } else if (position > maxBucketPosition) {
                int diff = position - maxBucketPosition;
                moveCount += diff;
                minBucketPosition = minBucketPosition + diff;
                maxBucketPosition = position;
            }
        }

        return new Output(moveCount);
    }

}
