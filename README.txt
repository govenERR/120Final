CONCENTRATION CURVE CONVERSIONS by LILY FAIRMAN

This program reads two CSV files, one representing experimental data (represented in absorbance vs time), and the other representing a standard curve (represented in concentration vs. absorbance), and the other representing standard curve data. 
It reads the values in the CSV and writes them to an array, performs very basic calculus on them to estimate a line of best fit of the standard curve, and then uses that line to convert the absorbances in the experimental data into concentrations. Finally, it writes the new concentration vs. time data to a CSV file, which can easily be uploaded to a graphing application like Excel or Kaleidagraph, to convey your data through imagery. 

INSTRUCTIONS

1. Run Main.java
2. A file select menu will pop up, prompting you to select a Standard Curve file. A sample one is in GitHub
3. After you select the first file, the menu will return asking you to select an experimental data file, I've provided samples that can be used for practice in GitHub (lfhre2 and lfhre3, these are actual samples my lab partner and I collected in lab ) but I'd encourage you to use your own!
4. 