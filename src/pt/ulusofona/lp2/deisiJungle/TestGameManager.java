package pt.ulusofona.lp2.deisiJungle;

import org.junit.Test;

import java.util.Arrays;

import static org.testng.AssertJUnit.assertEquals;

public class TestGameManager {

        @Test
        public void getPlayerIdsAfterMove(){
            GameManager game = new GameManager();
            String[][] players = new String[2][3];
            players[0] = new String[]{"1","Filipe","E"};
            players[1] = new String[]{"2","Rodrigo","Z"};
            game.createInitialJungle(12,10,players);
            game.moveCurrentPlayer(3,false);
            assertEquals(players[1][0], game.getCurrentPlayerInfo()[0]);
        }

}
