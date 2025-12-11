import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


public class Day6 {
    public static void main(String[] args) throws IOException {
        var file = Files.readAllLines(Path.of("C:\\Users\\Genee\\IdeaProjects\\demo7\\aoc\\src\\aocd6.txt"));

        for (String line : file) {
            pl(line.toCharArray());

        }

    }




    public static void pl(Object x){System.out.println(x);}

}