import java.io.*;
import java.util.Arrays;

public class Main {

    static class Input {
        final int numOfGrow;
        final Info[] infos;

        Input(int numOfGrow, String[] infos) {
            this.numOfGrow = numOfGrow;
            this.infos = Arrays.stream(infos).map(infoString -> {
                String[] split = infoString.split(" ");
                return new Info(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
            }).toArray(Info[]::new);
        }
    }

    static class Info {
        final int direction;
        final int value;

        Info(int direction, int value) {
            this.direction = direction;
            this.value = value;
        }
    }

    static class Output {
        final int totalCount;

        Output(int totalCount) {
            this.totalCount = totalCount;
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
            int numOfGrow = Integer.parseInt(br.readLine());
            String[] infos = new String[6];
            for (int i = 0; i < infos.length; i++) {
                infos[i] = br.readLine();
            }
            input = new Input(numOfGrow, infos);
        }
        return input;
    }

    private static void resolve(Output output) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(String.valueOf(output.totalCount));
        }
    }

    private static Output solve(Input input) {
        int verticalMaxValue = 0;
        int horizontalMaxValue = 0;
        int localHorizontalValue = 0;
        int localVerticalValue = 0;

        for (int i = 0; i < 6; i++) {
            Info info = input.infos[i];
            if (info.direction <= 2) {
                horizontalMaxValue = Math.max(horizontalMaxValue, info.value);
                int prevIdx = (i + 5) % 6;
                int nextIdx = (i + 1) % 6;
                if (input.infos[prevIdx].direction == input.infos[nextIdx].direction) {
                    localVerticalValue = info.value;
                }
            } else {
                verticalMaxValue = Math.max(verticalMaxValue, info.value);
                int prevIdx = (i + 5) % 6;
                int nextIdx = (i + 1) % 6;
                if (input.infos[prevIdx].direction == input.infos[nextIdx].direction) {
                    localHorizontalValue = info.value;
                }
            }
        }
        int totalSize = (verticalMaxValue * horizontalMaxValue) - (localVerticalValue * localHorizontalValue);
        return new Output(input.numOfGrow * totalSize);
    }

}
