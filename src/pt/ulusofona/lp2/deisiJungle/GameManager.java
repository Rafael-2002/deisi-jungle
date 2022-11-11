package pt.ulusofona.lp2.deisiJungle;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;


public class GameManager {

    public GameManager() {

    }

    ArrayList<Player> listaJog = new ArrayList<>();
    ArrayList<Player> listaJogSpos = new ArrayList<>();
    String[][] especies = new String[5][3];
    int pos, tamanhoTabuleiro,energia;


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

        tamanhoTabuleiro = jungleSize;

        //verifica se existe algum utilizador com o mesmo ID e se o ID é válido

        for(int i = 0; i < playersInfo.length; i++){

            int repeteID = 0;

            for(int x = 0; x < playersInfo.length; x++){

                if(Objects.equals(playersInfo[i][0], playersInfo[x][0])){
                    repeteID++;
                }

                if(repeteID > 1){
                    return false;
                }
            }

            if(playersInfo[i][0] == null){
                return false;
            }
        }


        //verifica os nomes dos jogadores

        for(int i = 0; i < playersInfo.length; i++){

            if(Objects.equals(playersInfo[i][1], "") || playersInfo[i][1] == null){
                return false;
            }
        }


        //verifica se as especies estao dentro da getSpecies
        boolean[] check = new boolean[playersInfo.length];
        for(int i = 0; i < playersInfo.length; i++){
            for(int x = 0; x < especies.length; x++){
                if(playersInfo[i][2].equals(getSpecies()[x][0])){
                    check[i] = true;
                }
            }
            if(playersInfo[i][2] == null){

                return false;
            }
        }

        for(int checkEspecies = 0; checkEspecies < check.length; checkEspecies++){
            if(!check[checkEspecies]){
                return false;
            }
        }
        //verifica o numero de jogadores
        if(playersInfo.length < 2 || playersInfo.length > 4){
            return false;
        }

        //verifica se o mapa tem 2 posicoes para cada jogador

        if(jungleSize < playersInfo.length * 2){
            return false;
        }

        //verifica se existem mais do que um tarzan
        int numTarzan = 0;

        for(int i = 0; i < playersInfo.length; i++){
            if(Objects.equals(playersInfo[i][2], "Z")){
                numTarzan++;
            }
        }
        if(numTarzan > 1){
            return false;
        }

        //criar os jogadores

        for(int i = 0; i < playersInfo.length; i++) {

            int id = Integer.parseInt(playersInfo[i][0]);
            String nome = playersInfo[i][1];
            String especie = playersInfo[i][2];

            listaJog.add(new Player(id, nome, especie, initialEnergy, pos));
            listaJog.add(new Player(id, nome, especie, initialEnergy));
        }

        energia = initialEnergy;

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
            pos += nrSquares;
            energia -= 2;
            return true;
        }else{
            if(nrSquares < 1 || nrSquares > 6){
                return false;
            }
        }
        pos += nrSquares;
        energia -= 2;
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

        return "Portuguese professional wrestler";
    }

}