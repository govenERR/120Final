class Main {
    
    public static void main(String[] args) {
        StandardCurve standard = new StandardCurve();
        standard.assignFiles();
        Experimental experimental = new Experimental();
        experimental.assignFiles();
        standard.calculateSC();
        experimental.concentrationCalc(standard.getConcentrationConversion());
        System.out.println(experimental.getConcentration());
        experimental.writeCSV();

        
    }
}
