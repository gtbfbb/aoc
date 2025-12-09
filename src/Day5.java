import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


public class Day5 {
    public static void main(String[] args) throws IOException {
        var file = Files.readAllLines(Path.of("C:\\Users\\Genee\\IdeaProjects\\demo7\\aoc\\src\\aocd5.txt"));
        int c = 0;
        String[] ranges = new String[0];
        long[] ids;
        List<Long> fresh = new ArrayList<>();

        //initialize arrays
        for (String line : file) {
            if (line.isEmpty()) {
                ranges = new String[c];
                c = -1;
            }
            c++;
        }
        ids =  new long[c];

        //add content to arrays
        for (int i = 0; i < ranges.length; i++) ranges[i] = file.get(i);
        for (int i = 0; i < ids.length; i++) ids[i] = Long.parseLong(file.get(i + ranges.length + 1));

        List<Long> sv = new ArrayList<>();
        List<Long> ev = new ArrayList<>();


        //add list of fresh ids
        for (String range : ranges) {
            long s = Long.parseLong(range.split("-")[0]);
            long e = Long.parseLong(range.split("-")[1]);
            sv.add(s);
            ev.add(e);

            //part 1
//            for (long id : ids) {
//                if (s <= id && id <= e && !fresh.contains(id)) {
//                    fresh.add(id);
//                }
//            }
        }
//        pl(fresh.size());





    }


    public static void pl(Object x){System.out.println(x);}

}