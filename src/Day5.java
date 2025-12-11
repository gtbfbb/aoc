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

        List<Long> sv = new ArrayList<>(), ev = new ArrayList<>();
        List<String> vr = new ArrayList<>();
        vr.add(ranges[0]);

        //add list of fresh ids
        for (String range: ranges) {
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

        for (int i = 0; i < sv.size(); i++){
            for (int j = 0; j < sv.size(); j++){
                if (sv.get(j) >= sv.get(i)){
                    long tempsv = sv.get(i);
                    long tempev = ev.get(i);
                    sv.set(i,sv.get(j));
                    ev.set(i,ev.get(j));
                    sv.set(j,tempsv);
                    ev.set(j,tempev);
                }
            }
        }

        pl(sv);
        pl(ev);


        boolean overlap = true;

//       pl(fresh.size());
        for (int i = 0; i < sv.size(); i++) {
            for (int j = 0; j < vr.size(); j++) {
                long s = Long.parseLong(vr.get(j).split("-")[0]);
                long e = Long.parseLong(vr.get(j).split("-")[1]);
                if ((sv.get(i) >= s && ev.get(i) <= e) || (sv.get(i) <= s && ev.get(i) >= e)) {
                    vr.set(j, Math.min(s, sv.get(i)) + "-" + Math.max(e, ev.get(i)));
                    overlap = true;
                } else if (sv.get(i) >= s && sv.get(i) <= e) {
                    vr.set(j, s + "-" + ev.get(i));
                    overlap = true;
                } else if (ev.get(i) >= s && ev.get(i) <= e) {
                    vr.set(j, sv.get(i) + "-" + e);
                    overlap = true;
                } else {
                    overlap = false;
                }
            }

            if (!overlap){
                vr.add(sv.get(i) + "-" + ev.get(i));
            }
        }


        for (int i = 0; i < vr.size(); i++){
            for (int j = i + 1; j < vr.size(); j++){
                if (vr.get(j).equals(vr.get(i))){
                    vr.remove(j);
                }
            }
        }

        pl(vr);
        long total = 0;

        for (String v : vr){
            long s = Long.parseLong(v.split("-")[0]);
            long e = Long.parseLong(v.split("-")[1]);
            total += e - s + 1;
        }

        pl(total);






    }


    public static void pl(Object x){System.out.println(x);}

}