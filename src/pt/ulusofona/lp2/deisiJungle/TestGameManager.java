package pt.ulusofona.lp2.deisiJungle;

import org.testng.annotations.Test;

import java.util.Arrays;

public class TestGameManager {

    @Test
    public void testCreateJungle(){
        GameManager p = new GameManager();
        String[][] array = {
                { "1", "Elefante", "E"},
                { "2", "Tarzan", "Z"},
        };

        boolean resultadoReal = p.createInitialJungle(100,100, array);
        boolean move = p.moveCurrentPlayer(2,false);
        boolean move2 = p.moveCurrentPlayer(2,false);
        int[] get = p.getPlayerIds(1);
        String[] get2 = p.getSquareInfo(1);



        for(int i = 0; i < get.length ; i++){
            System.out.println(Arrays.toString(get));
            System.out.println(Arrays.toString(get2));
        }

    }

}
