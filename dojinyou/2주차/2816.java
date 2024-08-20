import java.io.*;

public class Main {

    private static final String FIRST_CHANNEL_NAME = "KBS1";
    private static final String SECOND_CHANNEL_NAME = "KBS2";

    static class Input {
        String[] channels;


        Input(String[] channels) {
            this.channels = channels;
        }
    }

    static class Output {
        String command;

        Output(String command) {
            this.command = command;
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
            int size = Integer.parseInt(br.readLine());
            String[] channels = new String[size];
            for (int i = 0; i < size; i++) {
                channels[i] = br.readLine();
            }
            input = new Input(channels);
        }
        return input;
    }

    private static void resolve(Output output) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(output.command);
        }
    }

    private static Output solve(Input input) {
        // 케이스는 총 4가지
        // 4. KBS1 O / KBS2 O
        // 1. KBS1 O / KBS2 X
        // 2. KBS1 X / KBS2 O
        // 3. KBS1 X / KBS2 X

        String[] channels = input.channels;
        StringBuilder builder = new StringBuilder();

        if (!input.channels[0].equals(FIRST_CHANNEL_NAME)) {
            applyCommand(channels, 0, FIRST_CHANNEL_NAME, builder);
        }

        if (!input.channels[1].equals(SECOND_CHANNEL_NAME)) {
            applyCommand(channels, 1, SECOND_CHANNEL_NAME, builder);
        }

        return new Output(builder.toString());
    }

    private static void applyCommand(String[] channels, int targetIdx, String targetChannelName, StringBuilder commandBuilder) {
        if (channels[targetIdx].equals(FIRST_CHANNEL_NAME)) {
            return;
        }

        for (int i = 0; i < channels.length; i++) {
            if (channels[i].equals(targetChannelName)) {
                commandBuilder.append("1".repeat(targetIdx));
                commandBuilder.append("3".repeat(i - targetIdx));
                commandBuilder.append("2");
                commandBuilder.append("4".repeat(i - targetIdx - 1));
                channels[i] = channels[targetIdx];
                channels[targetIdx] = targetChannelName;
            }
        }
    }

}
