package pt.ulusofona.lp2.deisiJungle;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.testng.AssertJUnit.assertEquals;

public class TestGameManager {

    @Test
    public void testMoveCurrentPlayer1() {
        GameManager p = new GameManager();
        String[][] players = {
                {"1","joao","E"},
                {"2","andre","L"},
        };

        p.createInitialJungle(40,40,players);
        p.moveCurrentPlayer(4,false);

        assertEquals(players[1][0], p.getCurrentPlayerInfo()[0]);

    }

    @Test
    public void testMoveCurrentPlayer2() {
        GameManager p = new GameManager();
        String[][] players = {
                {"1","joao","E"},
                {"2","andre","L"},
        };

        p.createInitialJungle(40,40,players);
        p.moveCurrentPlayer(4,false);
        p.moveCurrentPlayer(2,false);
        p.moveCurrentPlayer(5,false);
        p.moveCurrentPlayer(1,false);

        assertEquals(players[0][0], p.getCurrentPlayerInfo()[0]);

    }

    @Test
    public void testMoveCurrentPlayer3() {
        GameManager p = new GameManager();
        String[][] players = {
                {"1","joao","E"},
                {"2","andre","L"},
        };

        p.createInitialJungle(10,40,players);
        p.moveCurrentPlayer(9,false);

        assertEquals(players[0][0], p.getWinnerInfo()[0]);

    }

    @Test
    public void testMoveCurrentPlayer4() {
        GameManager p = new GameManager();
        String[][] players = {
                {"1","joao","E"},
                {"2","andre","L"},
                {"3","rodrigo","Z"},
        };

        p.createInitialJungle(10,4,players);
        p.moveCurrentPlayer(1,false);
        p.moveCurrentPlayer(9,false);
        p.moveCurrentPlayer(9,false);
        p.moveCurrentPlayer(2,false);

        assertEquals(players[1][0], p.getWinnerInfo()[0]);

    }

}