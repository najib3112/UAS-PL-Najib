import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        String csvFile = "Src/cuboid.csv";
        String line;
        String cvsSplitBy = ",";
        ArrayList<Cuboid> cuboids = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] cuboidData = line.split(cvsSplitBy);
                double length = Double.parseDouble(cuboidData[0]);
                double width = Double.parseDouble(cuboidData[1]);
                double height = Double.parseDouble(cuboidData[2]);
                Cuboid cuboid = new Cuboid(length, width, height);
                cuboids.add(cuboid);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        cuboids.sort(Comparator.comparingDouble(Cuboid::getSurfaceArea));

        String fileOutput = "Src/output.txt";
        try (FileWriter fw = new FileWriter(fileOutput)){
            for (Cuboid cuboid : cuboids){
                fw.write(cuboid.getSurfaceArea() + "\n");
            }
        }catch (IOException e) {
            System.err.println(e.getMessage());
        }
        for (Cuboid cuboid : cuboids) {
            System.out.println(cuboid);
        }
    }
}
