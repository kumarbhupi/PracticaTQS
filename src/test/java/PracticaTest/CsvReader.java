package PracticaTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;


public class CsvReader {
  public final static String CSV_SEPARATOR = ";";


  private ArrayList<String[]> csvToStrList(String filePath) {
    BufferedReader br;
    ArrayList<String[]> values = new ArrayList<>();
    String line;
    String[] splitValues;
    try {
      br = new BufferedReader(new FileReader(filePath));

      while ((line = br.readLine()) != null) {
        splitValues = line.split(CSV_SEPARATOR);
        values.add(splitValues);
      }
      br.close();
    } catch (IOException ex) {
      ex.printStackTrace();
      return new ArrayList<>();
    }
    return values;
  }


  public String[] getCsvGame(String filePath) {
    ArrayList<String[]> csvValuesList = csvToStrList(filePath);

    String[] csvValuesArray = new String[csvValuesList.size()*csvValuesList.get(0).length];
    String[] values;

    for (int i = 0; i < csvValuesList.size(); i++) {
      values= csvValuesList.get(i);
      System.arraycopy(values, 0, csvValuesArray, i * values.length, values.length);
    }

    return csvValuesArray;
  }

  public int[][] getCsvResult(String filePath) {
    ArrayList<String[]> csvValuesList = csvToStrList(filePath);
    String[][] csvResult = new String[csvValuesList.size()][csvValuesList.get(0).length];
    for (int i = 0; i < csvValuesList.size(); i++) {
      csvResult[i] = csvValuesList.get(i);
    }
    int [][] csvIntResult = new int[csvResult.length][csvResult[0].length];

    for (int i = 0; i < csvResult.length; i++) {
      for (int j = 0; j < csvResult[i].length; j++) {
        csvIntResult[i][j] = Integer.parseInt(csvResult[i][j]);
      }
    }
    return csvIntResult;
  }
}