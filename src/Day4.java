import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


public class Day4 {
    public static void main(String[] args) throws IOException {
        var file = Files.readAllLines(Path.of("C:\\Users\\Genee\\IdeaProjects\\demo7\\aoc\\src\\aocd4.txt"));
        double row = 0, column;
        long d = Day2.pow(10,String.valueOf(file.size()).length());
        List<Double> cords = new ArrayList<>();

        //convert input to coordinates
        for (String line : file){
            column = 0;
            for (char c : line.toCharArray()){
                if (c == '@'){
                    cords.add(row + column/d);
                }
                column++;
            }
            row++;
        }


        int c = 0;
        boolean remove = true;

        while (remove) {
            remove = false;
            for (int i = 0; i < cords.size(); i++) {
                int adjr = 0;
                for (int j = (int) ((cords.get(i)) - 1); j <= (int) ((cords.get(i)) + 1); j++) {
                    for (int k = (int) (Math.round(d * (cords.get(i) - Math.floor(cords.get(i)))) - 1); k <= (int) (Math.round(d * (cords.get(i) - Math.floor(cords.get(i)))) + 1); k++) {
                        if (k != -1 && k != d && cords.contains((j + (double) k / d))) {
                            adjr++;
                        }
                    }
                }

                if (adjr < 5) {
                    remove = true;
                    cords.remove(i);
                    c++;
                }
            }
        }
        pl(c);
    }


    public static void pl(Object x){System.out.println(x);}
    public static void p(Object x){System.out.print(x);}
}
