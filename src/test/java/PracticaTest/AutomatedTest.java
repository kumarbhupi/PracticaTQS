package PracticaTest;

import static org.junit.Assert.*;

import org.junit.Test;

public class AutomatedTest {

  @Test
  public void testRunAllGames() {
    boolean[][] testArray1 = {
        { true, false, false, false, false},
        { false, false, false, false, false},
        { false, false, false, false, false},
        { false, false, false, false, false},
        { false, true, false, false, false},
    };

    String[] inputs = {"5,5", "d", "2,1", "d", "1,2", "d"};

    Board b = new Board(testArray1);
    Player p = new Player();

    //no hay control de errores en MockInuput, aseguraos de meter
    //la cantidad de comandos en "String[] inputs" precisa para el
    //tablero que monteis

    MockInput in = new MockInput(inputs);

    //EJECUCI�N MOCK
    new Game(p, b, in);


  }
}
