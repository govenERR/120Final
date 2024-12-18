import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Experimental extends CSVData{
    private ArrayList<Double> concentration = new ArrayList<Double>();
    private ArrayList<Double> x = new ArrayList<Double>();
    private ArrayList<Double> y = new ArrayList<Double>();


    public void concentrationCalc(double absorbanceConversion) {
        try {
        Scanner justInts = new Scanner(this.file);
        String[] throwawayString = justInts.nextLine().split(",");
        throwawayString = justInts.nextLine().split(",");
        throwawayString = justInts.nextLine().split(",");
        while (justInts.hasNextLine()) {
            String[] split = justInts.nextLine().split(",");
            double[] doubleNow = convertStringsToDoubles(split);
            x.add(doubleNow[0]);
            y.add(doubleNow[1]);
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (double y : this.y) {
            this.concentration.add(y/absorbanceConversion);
        }
    }

    public static double[] convertStringsToDoubles(String[] stringArray) {
        // Create a float array to store the results
        double[] doubleArray = new double[stringArray.length];
        
        // Loop through the string array and convert each element to float
        for (int i = 0; i < stringArray.length; i++) {
            try {
                // Parse each string as a float
                doubleArray[i] = Double.parseDouble(stringArray[i]);
            } catch (NumberFormatException e) {
                // Handle invalid input (e.g., if the string cannot be parsed as a float)
                System.err.println("Invalid number format: " + stringArray[i]);
                doubleArray[i] = 0.0f;  // Default to 0.0f in case of error
            }
        }
        
        return doubleArray;
    }

    public void writeCSV() {
        try{
            File updatedCSV = new File("ExperimentalTvC.csv");
            updatedCSV.createNewFile();
            FileWriter fileWriter = new FileWriter(updatedCSV);
            int i = 0;
            for (double y : this.concentration) {
                String xval = String.valueOf(this.x.get(i));
                String yval = String.valueOf(y);
                String line = String.join(",", xval, yval, "\n");
                fileWriter.write(line);
                i += 1;
        }
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public ArrayList<Double> getConcentration() {
        return this.concentration;
    }

    public static void main(String[] args) {
        
    }
}
