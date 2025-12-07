import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class Day1 {
    public static void main(String[] args) throws IOException {
        var file = Files.readAllLines(Path.of("C:\\Users\\Genee\\IdeaProjects\\demo7\\aoc\\src\\aocd1.txt"));
        int n = 50;
        int c = 0;
        for (String lines : file) {
            int d = lines.charAt(0) == ('R') ? 1 : -1;
            int r = d * Integer.parseInt(lines.substring(1));
            if (d == -1 && n > 0) {
                c += Math.abs(((-100 + n) + r) / 100);
            } else if (d == 1 && n < 0) {
                c += Math.abs(((100 + n) + r) / 100);
            } else {
                c += Math.abs((n + r) / 100);
            }
            n = (n + r) % 100;
        }
        pl(c);
    }

    public static void pl(Object x){
        System.out.println(x);
    }
}