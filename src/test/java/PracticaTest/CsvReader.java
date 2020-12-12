package PracticaTest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class CsvReader {
  private String filePath;
  public final static String CSV_SEPARATOR = ",";

  public CsvReader(String filePath) {
    this.filePath = filePath;
  }


  public ArrayList<String> csvToStrList() {
    BufferedReader br;
    ArrayList<String> values = new ArrayList<String>();
    String line = "";

    try {
      br = new BufferedReader(new FileReader(this.filePath));
      while((line = br.readLine()) != null) {
        String[] splittedLine = line.split(CSV_SEPARATOR);
        values.add(splittedLine[0]);
        values.add(splittedLine[1]);
      }
      br.close();
    }catch(IOException ex) {
      ex.printStackTrace();
      return new ArrayList<String>();
    }
    return values;
  }

  public String[] getCsvValues() {
    ArrayList<String> csvValuesList = csvToStrList();

    String[] csvValuesArray = new String[csvValuesList.size()];

    for (int i = 0; i < csvValuesArray.length; i++) {
      csvValuesArray[i] = csvValuesList.get(i);
    }



    return csvValuesArray;
  }
}