package PracticaTest;

import org.junit.Before;
import org.junit.Test;

public class AutomatedTest {
  Board b;
  boolean[][] boardToTest;
  Game game;
  Square[][] gameBoard;

  public static int TEST_NUM = 6; //Number of test in test-files and test-results

  @Before
  public void setUp() {
    boardToTest = new boolean[][]{
        { true, false, false, false, false},
        { false, false, false, false, false},
        { false, false, false, false, false},
        { false, false, false, false, false},
        { false, true, false, false, false},
    };
    b = new Board(boardToTest);
  }


  @Test
  public void testRunAllGames() {

    CsvReader csvReader = new CsvReader();
    String[] csvValues;
    int[][] results;
    Player p;
    MockInput in;

    for (int i = 0; i < TEST_NUM; i++) {
      csvValues = csvReader.getCsvGame("test-files/game"+i+".csv");
      results = csvReader.getCsvResult("test-results/result"+i+".csv");
      p = new Player();
      in = new MockInput(csvValues);
      game = new Game(p, b, in);
      gameBoard = game.board.getMatrix();
      for (int j = 0; j < gameBoard.length; j++) {
        for (int k = 0; k < gameBoard[j].length; k++) {
          assert(gameBoard[j][k].getState() == results[j][k]);
        }
      }
    }
  }
}
