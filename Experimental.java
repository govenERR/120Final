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

/*
 * Converts the file data from absorbance vs time data into concentration vs. time data using the standard curve class calculations
 */
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
    /*
     * Reads file, converts it into doubles and adds it to an array, and reads the first and last data points to create a line between them, which is set as the absorbance conversion
     */
    public static double[] convertStringsToDoubles(String[] stringArray) {
        double[] doubleArray = new double[stringArray.length];
        
        for (int i = 0; i < stringArray.length; i++) {
            try {
                doubleArray[i] = Double.parseDouble(stringArray[i]);
            } catch (NumberFormatException e) {
                System.err.println("Invalid number format: " + stringArray[i]);
                doubleArray[i] = 0.0f;
            }
        }
        
        return doubleArray;
    }
    /*
     * Creates a CSV file for the data to be stored in, and writes the updated concentration data to the new file
     */
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
    /*
     * Getter for this.concentration, returns the concentration data
     */
    public ArrayList<Double> getConcentration() {
        return this.concentration;
    }

    public static void main(String[] args) {
        
    }
}
