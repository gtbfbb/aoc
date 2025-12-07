import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class Day2 {
    public static void main(String[] args) throws IOException {
        long total = 0L;
        var file = Files.readString(Path.of("C:\\Users\\Genee\\IdeaProjects\\demo7\\aoc\\src\\aocd2.txt"));
        String[] ranges = file.split(",");

        for (String range : ranges){
            long s = Long.parseLong(range.split("-")[0]);
            long e = Long.parseLong(range.split("-")[1]);

            for (long i = s; i <= e; i++){
                //pt1 sol1
//                String Stri = String.valueOf(i);
//                if(){
//                    pl(Stri);
//                    total += Long.parseLong(Stri);
//                }
                //pt1 sol2
                //number of digits in value
                int d = (int) Math.floor(Math.log10((double) i)) + 1;

//                if ((d % 2) == 0 && (i % (pow(10, d/2) + 1) == 0)){
//                    pl(i);
//                    total += i;
//                }


                //pt2 sol
                long div;
                int count = 0;
                for (int j = 1; j < d; j++){
                    if (d % j == 0){
                        div = 0;
                        for (int k = 0; k < d; k += j){
                            div += pow(10, k);
                        }

                        if (i % div == 0 && count == 0){
                            total += i;
                            count++;
                        }
                    }
                }
            }
        }
        pl(total);
    }


    public static long pow(long a, long b){
        long result = 1;
        for (long i = 0; i < b; i++){
            result *= a;
        }
        return result;
    }

    public static void pl(Object x){
        System.out.println(x);
    }
}