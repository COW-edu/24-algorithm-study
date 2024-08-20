import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    static class Input {
        UserInfo[] userInfos;


        Input(UserInfo[] userInfos) {
            this.userInfos = userInfos;
        }
    }

    static class Output {
        UserInfo[] sortedUserInfo;

        Output(UserInfo[] sortedUserInfos) {
            this.sortedUserInfo = sortedUserInfos;
        }
    }

    static class UserInfo {
        int id;
        String name;
        int age;

        UserInfo(int id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return String.format("%d %s", age, name);
        }

        static UserInfo parse(int id, String line) {
            String[] info = line.split(" ");
            return new UserInfo(id, info[1], Integer.parseInt(info[0]));
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
            UserInfo[] userInfos = new UserInfo[size];
            for (int i = 0; i < size; i++) {
                userInfos[i] = UserInfo.parse(i, br.readLine());
            }
            input = new Input(userInfos);
        }
        return input;
    }

    private static void resolve(Output output) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            for (UserInfo userInfo : output.sortedUserInfo) {
                bw.write(userInfo.toString() + "\n");
            }
        }
    }

    private static Output solve(Input input) {
        UserInfo[] sortedUserInfos = Arrays.stream(input.userInfos)
                .sorted((o1, o2) -> {
                    if (o1.age != o2.age) {
                        return o1.age - o2.age;
                    }
                    return o1.id - o2.id;
                })
                .toArray(UserInfo[]::new);
        return new Output(sortedUserInfos);
    }

}
