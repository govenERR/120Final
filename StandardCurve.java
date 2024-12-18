import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;


/*
 * Child of CSVData, creates a conversion that is used to convert experimental data to concentration vs. time
 */
public class StandardCurve extends CSVData {
    private Double absorbanceConversion;
    private ArrayList<Double> x = new ArrayList<Double>();
    private ArrayList<Double> y = new ArrayList<Double>();

    /*
     * Reads file, converts it into doubles and adds it to an array, and reads the first and last data points to create a line between them, which is set as the absorbance conversion
     */
    public void calculateSC() {
        
        try {
        Scanner justInts = new Scanner(this.file);
        String[] throwawayString = justInts.nextLine().split(",");
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
        Double deltaX = x.getLast() - x.getFirst();
        Double deltaY = y.getLast() - y.getFirst();
        this.absorbanceConversion = deltaY/deltaX;

    }
/*
Used in the file reading methods, converts the strings in the files into doubles, and adds them to an array. Returns the array of doubles
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
 * Getter function for this.absorbanceConversion
 * @return this.absorbanceConversion the conversion factor to change absorbance to concentration
 */
        public double getConcentrationConversion() {
            return this.absorbanceConversion;
        }
    

    public static void main(String[] args) {
        
    }
}
