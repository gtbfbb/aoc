import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;


public class Day8 {
    public static void main(String[] args) throws IOException {
        var file = Files.readAllLines(Path.of("C:\\Users\\Genee\\IdeaProjects\\aoc\\src\\acod8.txt"));
        List<int[]> coords = new ArrayList<>();
        List<Double> distances = new ArrayList<>();
        List<int[][]> distancecoords = new ArrayList<>();
        for (String line : file) {
            coords.add(strintcoords(line));
        }


        for (int i = 0; i < coords.size(); i++){
            for (int j = i + 1; j < coords.size(); j++){
                int[][] secoords = new int[2][3];
                distances.add(getDist(coords.get(i), coords.get(j)));
                secoords[0] = coords.get(i);
                secoords[1] = coords.get(j);
//                pl(Arrays.toString(secoords[0]) + "  " + Arrays.toString(secoords[1]));
                distancecoords.add(secoords);
//                pl(Arrays.toString(distancecoords.get(0)[0]) + "  " + Arrays.toString(distancecoords.get(0)[1]));
//                pl(distancecoords.size()) ;
            }
        }

//        for (int i = 0; i < distancecoords.size(); i++){
//            pl(Arrays.toString(distancecoords.get(i)[0]) + "  " + Arrays.toString(distancecoords.get(i)[1]));
//        }
//
//        pl(distancecoords.size());

        sort(distances, distancecoords);

        for (int i = 0; i < distances.size(); i++){
            pl(distances.get(i) + "  " + Arrays.toString((distancecoords.get(i)[0])) + "  " + Arrays.toString((distancecoords.get(i))[1]));
        }

    }






    private static int[] strintcoords(String line){
        String[] strcoords = line.split(",");
        int[] intcoords = new int[strcoords.length];
        for (int i = 0; i < strcoords.length; i++){
            intcoords[i] = Integer.parseInt(strcoords[i]);
        }
        return intcoords;
    }


    private static void sort(List<Double> list, List<int[][]> coords){
        Double temp;
        int[][] tempcoords;
        for (int i = 0; i < list.size(); i++){
            for (int j = i + 1; j < list.size(); j++){
                if (list.get(i) > list.get(j)) {
                    temp = list.get(j);
                    list.set(j,list.get(i));
                    list.set(i, temp);

                    tempcoords = coords.get(j);
                    coords.set(j,coords.get(i));
                    coords.set(i, tempcoords);
                }
            }
        }
    }

    private static double getDist(int[] pointi, int[] pointf){
        double dist = 0;
        for (int i = 0; i < pointi.length; i++){
            dist += square(pointf[i] - pointi[i]);
        }
        return Math.sqrt(dist);
    }


    private static double square(int number){
        return number * number;
    }


    private static void pl(Object x){System.out.println(x);}

}