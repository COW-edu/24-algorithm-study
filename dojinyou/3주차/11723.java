import java.io.*;

public class Main {

    static class Input {
        final Command[] commands;

        Input(Command[] commands) {
            this.commands = commands;
        }
    }

    static class Output {
        final String value;

        Output(String value) {
            this.value = value;
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
            Command[] commands = new Command[size];
            for (int i = 0; i < size; i++) {
                String commandString = br.readLine().toUpperCase();
                if (commandString.equals(CommandKeyword.ALL.name()) || commandString.equals(CommandKeyword.EMPTY.name())) {
                    commands[i] = new Command(CommandKeyword.valueOf(commandString), 0);
                } else {
                    String[] split = commandString.split(" ");
                    CommandKeyword keyword = CommandKeyword.valueOf(split[0]);
                    int value = Integer.parseInt(split[1]);
                    commands[i] = new Command(keyword, value);
                }
            }
            input = new Input(commands);
        }
        return input;
    }

    private static void resolve(Output output) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(output.value);
        }
    }

    enum CommandKeyword {
        ADD,
        REMOVE,
        CHECK,
        TOGGLE,
        ALL,
        EMPTY,
        ;
    }

    static class Command {
        final CommandKeyword keyword;
        final int value;

        Command(CommandKeyword keyword, int value) {
            this.keyword = keyword;
            this.value = value;
        }
    }

    private static Output solve(Input input) {
        StringBuilder sb = new StringBuilder(input.commands.length);
        boolean[] set = new boolean[21];

        for (Command cmd : input.commands) {
            switch (cmd.keyword) {
                case ADD:
                    set[cmd.value] = true;
                    break;
                case REMOVE:
                    set[cmd.value] = false;
                    break;
                case CHECK:
                    if (set[cmd.value]) {
                        sb.append(1);
                    } else {
                        sb.append(0);
                    }
                    sb.append("\n");
                    break;
                case TOGGLE:
                    set[cmd.value] = !set[cmd.value];
                    break;
                case ALL:
                    for (int i = 1; i < set.length; i++) {
                        set[i] = true;
                    }
                    break;
                case EMPTY:
                    for (int i = 1; i < set.length; i++) {
                        set[i] = false;
                    }
                    break;
            }
        }

        return new Output(sb.toString());
    }
}
