package pt.ulusofona.lp2.deisiJungle;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;


public class GameManager {

    int pos, tamanhoTabuleiro;


    public GameManager() {

    }

    ArrayList<Player> listaJog = new ArrayList<>();
    ArrayList<Player> listaJogSpos = new ArrayList<>();
    String[][] especies = new String[5][3];

    public int posJogador(int nrSquares) {
        pos += nrSquares;
        return pos;
    }


    public void players(String[][] playersInfo, int nrSquares) {

        for (int i = 0; i < playersInfo.length; i++) {

            int id = 0;
            String nome = null;
            String especie = null;
            int energia = 0;

            playersInfo[i][0] = String.valueOf(id);
            playersInfo[i][1] = nome;
            playersInfo[i][2] = especie;
            playersInfo[i][3] = String.valueOf(energia);

            listaJog.add(new Player(id, nome, especie, energia, posJogador(nrSquares)));
            listaJogSpos.add(new Player(id, nome, especie, energia));

        }


    }


    public String[][] getSpecies() {

        especies[0][0] = "E";
        especies[0][1] = "Elefante";
        especies[0][2] = "Elefante.png";

        especies[1][0] = "L";
        especies[1][1] = "Leao";
        especies[1][2] = "Leao.png";

        especies[2][0] = "T";
        especies[2][1] = "Tartaruga";
        especies[2][2] = "Tartaruga.png";

        especies[3][0] = "P";
        especies[3][1] = "Passaro";
        especies[3][2] = "Passaro.png";

        especies[4][0] = "Z";
        especies[4][1] = "Tarzan";
        especies[4][2] = "Tarzan.png";

        return especies;
    }

    public boolean createInitialJungle(int jungleSize, int initialEnergy, String[][] playersInfo) {

        int numJog = playersInfo.length;
        int numTarzan = 0;
        tamanhoTabuleiro = jungleSize;


        for (int i = 0; i < numJog; i++) {

            int numRep = 0;

            for(int y = 0; y < numJog; y++){

                if(Objects.equals(playersInfo[i][0], playersInfo[y][0])){
                    numRep++;
                }
            }

            int player = Integer.parseInt(playersInfo[i][0]);
            if(playersInfo[i][0] == null || player < 0 || playersInfo[i][2] == null){
                return false;
            }

            if(numRep >= 2){
                return false;
            }

            if (playersInfo[i][1] == null || Objects.equals(playersInfo[i][1], "")) {
                return false;
            }

            for(int x = 0; x < getSpecies().length;x++){
                if(!playersInfo[i][2].equals(getSpecies()[x][0])){
                    return false;
                }
            }


            if (Objects.equals(playersInfo[i][2], "Z")) {
                numTarzan++;
            }
        }

        if (numTarzan >= 2) {
            return false;
        }

        if (numJog < 2 || numJog > 4) {
            return false;
        }

        if(jungleSize < numJog * 2){
            return false;
        }

        return true;
    }

    public int[] getPlayerIds(int squareNr) {

        ArrayList<Player> jogPos = new ArrayList<>();

        for (int i = 0; i < listaJog.size(); i++) {

            Player p = listaJog.get(i);

            if (p.pos == squareNr) {
                jogPos.add(p);
            }

        }

        int[] array = new int[jogPos.size()];

        for (int x = 0; x < jogPos.size(); x++) {
            Player p = jogPos.get(x);

            array[x] = p.id;

        }

        return array;
    }

    public String[] getSquareInfo(int squareNr) {

        ArrayList<Integer> jogador = new ArrayList<>();
        String str = "";
        String[] squareInfo = new String[3];


        if(squareNr < 1 || squareNr > tamanhoTabuleiro){
            return null;
        }

        for (int i = 0; i < listaJog.size(); i++) {

            Player p = listaJog.get(i);

            if (p.pos == squareNr) {
                jogador.add(p.id);
            }

        }

        for (int x = 0; x < jogador.size(); x++) {
            str += jogador + ",";
        }

        if(squareNr == tamanhoTabuleiro){
            squareInfo[0] = "finish.png";
            squareInfo[1] = "Meta";
            squareInfo[2] = str;
        }else{
            squareInfo[0] = "blank.png";
            squareInfo[1] = "Vazio";
            squareInfo[2] = str;
        }


        return squareInfo;
    }

    public String[] getPlayerInfo(int playerId) {

        ArrayList<Player> jogId = new ArrayList<>();
        String[] str = new String[4];

        if (!listaJogSpos.contains(playerId)) {
            return null;
        }

        for (int i = 0; i < listaJogSpos.size(); i++) {

            Player p = listaJogSpos.get(i);

            if (p.id == playerId) {
                jogId.add(p);
            }
        }

        String[] input = listaJogSpos.toArray(new String[0]);

        return input;
    }



    public String[] getCurrentPlayerInfo(){

        return new String[0];
    }

    public String[][] getPlayersInfo(){

        return new String[0][];
    }


    public boolean moveCurrentPlayer(int nrSquares, boolean bypassValidations) {

        if(bypassValidations){
            return true;
        }else{
            if(nrSquares < 1 || nrSquares > 6){
                return false;
            }
        }

        posJogador(nrSquares);

        return true;
    }




    public String[] getWinnerInfo(){

        return new String[0];
    }

    public ArrayList<String> getGameResults(){

        return null;
    }

    public JPanel getAuthorsPanel(){

        return null;
    }



    public String whoIsTaborda() {

        return "Professional wrestler";
    }

}