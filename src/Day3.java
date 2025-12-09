import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class Day3 {
    public static void main(String[] args) throws IOException {
        //day 3 sol 1 + 2
        var banks = Files.readAllLines(Path.of("C:\\Users\\Genee\\IdeaProjects\\demo7\\aoc\\src\\aocd3.txt"));
        long joltage = 0;
        for (String bank : banks) {
            int joltsize = 12 - 1, l = bank.length() - joltsize, loc = 0, temp = 0;
            for (int j = joltsize; j >= 0; j--) {
                long fd = 0;
                for (int i = loc; i < l; i++) {
                    long d = Long.parseLong(bank.substring(i, i + 1));
                    if (d > fd) {
                        fd = d;
                        temp = i;
                    }
                }
                l += 1;
                loc = temp + 1;
                joltage += Day2.pow(10, j) * fd;
            }
        }
        pl(joltage);
    }


    public static void pl(Object x){System.out.println(x);}
}