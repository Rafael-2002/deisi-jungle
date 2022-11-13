package pt.ulusofona.lp2.deisiJungle;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.atomic.AtomicReferenceArray;


public class GameManager {

    public GameManager() {

    }

    ArrayList<Player> listaJog = new ArrayList<>();
    ArrayList<Player> listaJog2 = new ArrayList<>();

    String[][] especies = new String[5][3];
    int tamanhoTabuleiro, nTurno = 0,numJogadores = 0;
    int[] ordemTurnos;
    String[] winner1 = new String[4];
    String[] winner2 = new String[4];
    String[] winner3 = new String[4];
    String[] winner4 = new String[4];
    int lugar2 = 5;
    int lugar3 = 5;
    int lugar4 = 5;

    public void trocarTurno() {

        ordemTurnos = new int[listaJog.size()];

        for (int i = 0; i < listaJog.size(); i++) {

            Player p = listaJog.get(i);

            ordemTurnos[i] = p.id;

        }

        Arrays.sort(ordemTurnos);

    }


    public void criarPlayers(String[][] playersInfo, int initialEnergy) {


        for (int i = 0; i < playersInfo.length; i++) {

            String nome = playersInfo[i][1];
            String especie = playersInfo[i][2];

            listaJog.add(new Player(Integer.parseInt(playersInfo[i][0]), nome, especie, initialEnergy, 1));

        }

    }

    public void lugar2(){

        int jogadorVencedor = Integer.parseInt(winner1[0]);


        int maxPos = listaJog2.get(0).pos;
        int energia = 0;
        int numJog = 0;
        int minId = listaJog2.get(0).id;
        int jogador1 = 0;

        for (int i = 0; i < listaJog2.size(); i++) {

            if (maxPos < listaJog2.get(i).pos) {
                maxPos = listaJog2.get(i).pos;
            }
            if(minId > listaJog2.get(i).id){
                minId = listaJog2.get(i).id;
            }

        }

        for(int i = 0; i < listaJog2.size();i++){
            if(listaJog2.get(i).energia == 0){
                energia++;
            }
            if(maxPos == listaJog2.get(i).pos){
                numJog++;
            }
        }


        if(energia == listaJog2.size()) {

            for(int i = 0; i < listaJog2.size();i++){
                if(maxPos == listaJog2.get(i).pos){
                    if(numJog > 1){
                        if(minId == listaJog2.get(i).id){
                            jogador1 = minId;
                        }
                    }else{
                        jogador1 = listaJog2.get(i).id;
                    }
                }
            }

            for(int i = 0; i < listaJog2.size();i++){

                if(listaJog2.get(i).id == jogador1){
                    winner2[0] = String.valueOf(listaJog2.get(i).id);
                    winner2[1] = listaJog2.get(i).nome;
                    winner2[2] = listaJog2.get(i).especie;
                    winner2[3] = String.valueOf(listaJog2.get(i).pos);
                    listaJog2.remove(i);
                    return;
                }

            }

        }

        for(int i = 0; i < listaJog2.size();i++){

            if(listaJog2.get(i).pos == tamanhoTabuleiro){
                winner2[0] = String.valueOf(listaJog2.get(i).id);
                winner2[1] = listaJog2.get(i).nome;
                winner2[2] = listaJog2.get(i).especie;
                winner2[3] = String.valueOf(listaJog2.get(i).pos);
                listaJog2.remove(i);
                return;
            }

        }


    }

    public void lugar3(){


        int jogadorVencedor = Integer.parseInt(winner1[0]);

        int maxPos = listaJog2.get(0).pos;
        int energia = 0;
        int numJog = 0;
        int minId = listaJog2.get(0).id;
        int jogador1 = 0;

        for (int i = 0; i < listaJog2.size(); i++) {

            if (maxPos < listaJog2.get(i).pos) {
                maxPos = listaJog2.get(i).pos;
            }
            if(minId > listaJog2.get(i).id){
                minId = listaJog2.get(i).id;
            }

        }

        for(int i = 0; i < listaJog2.size();i++){
            if(listaJog2.get(i).energia == 0){
                energia++;
            }
            if(maxPos == listaJog2.get(i).pos){
                numJog++;
            }
        }


        if(energia == listaJog2.size()) {

            for(int i = 0; i < listaJog2.size();i++){
                if(maxPos == listaJog2.get(i).pos){
                    if(numJog > 1){
                        if(minId == listaJog2.get(i).id){
                            jogador1 = minId;
                        }
                    }else{
                        jogador1 = listaJog2.get(i).id;
                    }
                }
            }

            for(int i = 0; i < listaJog2.size();i++){

                if(listaJog2.get(i).id == jogador1){
                    winner3[0] = String.valueOf(listaJog2.get(i).id);
                    winner3[1] = listaJog2.get(i).nome;
                    winner3[2] = listaJog2.get(i).especie;
                    winner3[3] = String.valueOf(listaJog2.get(i).pos);
                    listaJog2.remove(i);
                    return;
                }

            }

        }

        for(int i = 0; i < listaJog2.size();i++){

            if(listaJog2.get(i).pos == tamanhoTabuleiro){
                winner3[0] = String.valueOf(listaJog2.get(i).id);
                winner3[1] = listaJog2.get(i).nome;
                winner3[2] = listaJog2.get(i).especie;
                winner3[3] = String.valueOf(listaJog2.get(i).pos);
                listaJog2.remove(i);
                return;
            }

        }


    }

    public void lugar4(){


        int jogadorVencedor = Integer.parseInt(winner1[0]);

        int maxPos = listaJog2.get(0).pos;
        int energia = 0;
        int numJog = 0;
        int minId = listaJog2.get(0).id;
        int jogador1 = 0;

        for (int i = 0; i < listaJog2.size(); i++) {

            if (maxPos < listaJog2.get(i).pos) {
                maxPos = listaJog2.get(i).pos;
            }
            if(minId > listaJog2.get(i).id){
                minId = listaJog2.get(i).id;
            }

        }

        for(int i = 0; i < listaJog2.size();i++){
            if(listaJog2.get(i).energia == 0){
                energia++;
            }
            if(maxPos == listaJog2.get(i).pos){
                numJog++;
            }
        }


        if(energia == listaJog2.size()) {

            for(int i = 0; i < listaJog2.size();i++){
                if(maxPos == listaJog2.get(i).pos){
                    if(numJog > 1){
                        if(minId == listaJog2.get(i).id){
                            jogador1 = minId;
                        }
                    }else{
                        jogador1 = listaJog2.get(i).id;
                    }
                }
            }

            for(int i = 0; i < listaJog2.size();i++){

                if(listaJog2.get(i).id == jogador1){
                    winner4[0] = String.valueOf(listaJog2.get(i).id);
                    winner4[1] = listaJog2.get(i).nome;
                    winner4[2] = listaJog2.get(i).especie;
                    winner4[3] = String.valueOf(listaJog2.get(i).pos);
                    listaJog2.remove(i);
                    return;
                }

            }

        }

        for(int i = 0; i < listaJog2.size();i++){

            if(listaJog2.get(i).pos == tamanhoTabuleiro){
                winner4[0] = String.valueOf(listaJog2.get(i).id);
                winner4[1] = listaJog2.get(i).nome;
                winner4[2] = listaJog2.get(i).especie;
                winner4[3] = String.valueOf(listaJog2.get(i).pos);
                listaJog2.remove(i);
                return;
            }

        }


    }

    public void lugares(){
        if(numJogadores == 2){
            lugar2();
        }

        if(numJogadores == 3){
            lugar2();
            lugar3();
        }

        if(numJogadores == 4){
            lugar2();
            lugar3();
            lugar4();
        }
    }



    public String[][] getSpecies() {

        especies[0][0] = "E";
        especies[0][1] = "Elefante";
        especies[0][2] = "elephant.png";

        especies[1][0] = "L";
        especies[1][1] = "Leao";
        especies[1][2] = "lion.png";

        especies[2][0] = "T";
        especies[2][1] = "Tartaruga";
        especies[2][2] = "turtle.png";

        especies[3][0] = "P";
        especies[3][1] = "Passaro";
        especies[3][2] = "bird.png";

        especies[4][0] = "Z";
        especies[4][1] = "Tarzan";
        especies[4][2] = "tarzan.png";

        return especies;
    }


    public boolean createInitialJungle(int jungleSize, int initialEnergy, String[][] playersInfo) {

        tamanhoTabuleiro = jungleSize;

        //verifica se existe algum utilizador com o mesmo ID e se o ID é válido

        for (int i = 0; i < playersInfo.length; i++) {

            int repeteID = 0;

            if (!playersInfo[i][0].matches("^[0-9]*$") || playersInfo[i][0] == null) {
                return false;
            }

            for (int x = 0; x < playersInfo.length; x++) {

                if (Objects.equals(playersInfo[i][0], playersInfo[x][0])) {
                    repeteID++;
                }

                if (repeteID > 1) {
                    return false;
                }
            }
        }

        //verifica os nomes dos jogadores

        for (int i = 0; i < playersInfo.length; i++) {

            if (Objects.equals(playersInfo[i][1], "") || playersInfo[i][1] == null) {
                return false;
            }
        }


        //verifica se as especies estao dentro da getSpecies
        boolean[] check = new boolean[playersInfo.length];
        for (int i = 0; i < playersInfo.length; i++) {
            for (int x = 0; x < especies.length; x++) {
                if (playersInfo[i][2].equals(getSpecies()[x][0])) {
                    check[i] = true;
                }
            }
            if (playersInfo[i][2] == null) {

                return false;
            }
        }

        for (int checkEspecies = 0; checkEspecies < check.length; checkEspecies++) {
            if (!check[checkEspecies]) {
                return false;
            }
        }
        //verifica o numero de jogadores
        if (playersInfo.length < 2 || playersInfo.length > 4) {
            return false;
        }

        //verifica se o mapa tem 2 posicoes para cada jogador

        if (jungleSize < playersInfo.length * 2) {
            return false;
        }

        //verifica se existem mais do que um tarzan
        int numTarzan = 0;

        for (int i = 0; i < playersInfo.length; i++) {
            if (Objects.equals(playersInfo[i][2], "Z")) {
                numTarzan++;
            }
        }
        if (numTarzan > 1) {
            return false;
        }

        //criar os jogadores
        criarPlayers(playersInfo, initialEnergy);
        trocarTurno();
        return true;
    }


    public int[] getPlayerIds(int squareNr) {

        ArrayList<Player> jogPos = new ArrayList<>();

        if (squareNr < 1 || squareNr > tamanhoTabuleiro) {
            return new int[0];
        }



        for(int i = 0; i < listaJog.size(); i++){
            int idsRepetidos = 0;
            for(int x = 0; x < listaJog.size(); x++){
                if(listaJog.get(i).id == listaJog.get(x).id) {
                    idsRepetidos++;
                }
            }
            if(idsRepetidos > 1){
                return new int[0];
            }
        }

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

        ArrayList<Player> jogPos = new ArrayList<>();
        String[] squareInfo = new String[3];
        String str = "";

        if (squareNr < 1 || squareNr > tamanhoTabuleiro || squareNr == 0) {
            return null;
        }


        for (int i = 0; i < listaJog.size(); i++) {

            Player p = listaJog.get(i);

            if (p.pos == squareNr) {
                jogPos.add(p);
            }
        }

        for (int x = 0; x < jogPos.size(); x++) {
            Player p = jogPos.get(x);

            if (x == jogPos.size() - 1) {
                str += p.id;
            } else {
                str += p.id + ",";
            }
        }

        if (squareNr == tamanhoTabuleiro) {
            squareInfo[0] = "finish.png";
            squareInfo[1] = "Meta";
            squareInfo[2] = str;
        } else {
            squareInfo[0] = "blank.png";
            squareInfo[1] = "Vazio";
            squareInfo[2] = str;
        }

        return squareInfo;
    }

    public String[] getPlayerInfo(int playerId) {

        ArrayList<Player> jogPos = new ArrayList<>();

        String[] infoPlayers = new String[4];

        for (int i = 0; i < listaJog.size(); i++) {

            Player p = listaJog.get(i);

            if (p.id == playerId) {
                jogPos.add(p);
            }

        }

        if(jogPos.size() == 0){
            return null;
        }

        for (int x = 0; x < jogPos.size(); x++) {
            Player p = jogPos.get(x);

            infoPlayers[0] = String.valueOf(p.id);
            infoPlayers[1] = p.nome;
            infoPlayers[2] = p.especie;
            infoPlayers[3] = String.valueOf(p.energia);
        }

        return infoPlayers;

    }

    public String[] getCurrentPlayerInfo() {

        String[] infoPlayers = new String[4];
        int check = 0;

        for (int i = 0; i < listaJog.size(); i++) {

            Player p = listaJog.get(i);

            if (p.id == ordemTurnos[nTurno]) {
                infoPlayers[0] = String.valueOf(p.id);
                infoPlayers[1] = p.nome;
                infoPlayers[2] = p.especie;
                infoPlayers[3] = String.valueOf(p.energia);
                check = 1;
            }
        }
        if (check == 1) {
            return infoPlayers;
        } else {
            return null;
        }
    }

    public String[][] getPlayersInfo() {

        String[][] infoPlayers = new String[listaJog.size()][4];

        if (listaJog.size() == 0) {
            return null;
        }

        for (int i = 0; i < listaJog.size(); i++) {
            Player p = listaJog.get(i);

            infoPlayers[i][0] = String.valueOf(p.id);
            infoPlayers[i][1] = p.nome;
            infoPlayers[i][2] = p.especie;
            infoPlayers[i][3] = String.valueOf(p.energia);

        }

        return infoPlayers;
    }

    public boolean moveCurrentPlayer(int nrSquares, boolean bypassValidations) {


        ArrayList<Player> jogadores = new ArrayList<>();

        int pos = 1, energia = 0;




        for(int i = 0; i < listaJog.size();i++){
            Player p = listaJog.get(i);
            if(p.id == ordemTurnos[nTurno]){
                jogadores.add(p);
                pos = p.pos;
                energia = p.energia;
            }
        }

        if(jogadores.get(0).energia < 2){

            if (nTurno == listaJog.size()-1) {
                nTurno = 0;
            } else {
                nTurno++;
            }
            return true;
        }

        if(jogadores.get(0).pos + nrSquares >= tamanhoTabuleiro){

            jogadores.get(0).pos = tamanhoTabuleiro;

            return true;
        }

        if(bypassValidations) {

            pos+=nrSquares;
            energia -= 2;

            if (nTurno == listaJog.size()-1) {
                nTurno = 0;
            } else {
                nTurno++;
            }


            for(int i = 0; i < listaJog.size();i++) {

                if (listaJog.get(i).id == jogadores.get(0).id) {
                    listaJog.get(i).pos = pos;
                    listaJog.get(i).energia = energia;
                }
            }

        }else {

            if(nrSquares < 1 || nrSquares > 6) {

                nTurno++;
                return false;

            }

        }

            pos += nrSquares;
            energia -= 2;

            for(int i = 0; i < listaJog.size();i++) {

                if (listaJog.get(i).id == jogadores.get(0).id) {
                    listaJog.get(i).pos = pos;
                    listaJog.get(i).energia = energia;

                }
            }

        if (nTurno == listaJog.size()-1) {
            nTurno = 0;
        } else {
            nTurno++;
        }
        return true;

        }

    public String[] getWinnerInfo () {

        int maxPos = listaJog.get(0).pos;
        int energia = 0;
        int numJog = 0;
        int minId = listaJog.get(0).id;
        int jogador1 = 0;

        numJogadores = listaJog.size();

        listaJog2 = listaJog;



        for (int i = 0; i < listaJog.size(); i++) {

            if (maxPos < listaJog.get(i).pos) {
                maxPos = listaJog.get(i).pos;
            }
            if(minId > listaJog.get(i).id){
                minId = listaJog.get(i).id;
            }

        }

        for(int i = 0; i < listaJog.size();i++){
            if(listaJog.get(i).energia == 0){
                energia++;
            }
            if(maxPos == listaJog.get(i).pos){
                numJog++;
            }
        }


        if(energia == listaJog.size()) {

            for(int i = 0; i < listaJog.size();i++){
                if(maxPos == listaJog.get(i).pos){
                    if(numJog > 1){
                        if(minId == listaJog.get(i).id){
                            jogador1 = minId;
                        }
                    }else{
                        jogador1 = listaJog.get(i).id;
                    }
                }
            }

            for(int i = 0; i < listaJog.size();i++){

                if(listaJog.get(i).id == jogador1){
                    winner1[0] = String.valueOf(listaJog.get(i).id);
                    winner1[1] = listaJog.get(i).nome;
                    winner1[2] = listaJog.get(i).especie;
                    winner1[3] = String.valueOf(listaJog.get(i).pos);
                    listaJog2.remove(i);
                    lugares();

                    return winner1;
                }

            }

        }

        for(int i = 0; i < listaJog.size();i++){

            if(listaJog.get(i).pos == tamanhoTabuleiro){
                winner1[0] = String.valueOf(listaJog.get(i).id);
                winner1[1] = listaJog.get(i).nome;
                winner1[2] = listaJog.get(i).especie;
                winner1[3] = String.valueOf(listaJog.get(i).pos);
                listaJog2.remove(i);
                lugares();

                return winner1;
            }

        }
        return null;
    }



        public ArrayList<String> getGameResults () {

        ArrayList<String> p = new ArrayList<>();

        if(listaJog.size() == 2){

            String nome1 = winner1[1];
            String especie1 = winner1[2];
            String pos1 = winner1[3];

            String nome2 = winner2[1];
            String especie2 = winner2[2];
            String pos2 = winner2[3];

            String lugar1 = "#1 " + nome1 + ", " + especie1 + ", " + pos1 + "\n" + "#2 " + nome2 + ", " + especie2 + ", " + pos2;

            p.add(lugar1);

        }

        if(listaJog.size() == 3){
            String nome1 = winner1[1];
            String especie1 = winner1[2];
            String pos1 = winner1[3];

            String nome2 = winner2[1];
            String especie2 = winner2[2];
            String pos2 = winner2[3];

            String nome3 = winner3[1];
            String especie3 = winner3[2];
            String pos3 = winner3[3];

            String lugar1 = "#1 " + winner1[1] + ", " + especie1 + ", " + pos1 + "\n"
                    + "#2 " + nome2 + ", " + especie2 + ", " + pos2 + "\n" + "#3 " + nome3 + ", " + especie3 + ", " + pos3;

            p.add(lugar1);
        }

            if(listaJog.size() == 4){
                String nome1 = winner1[1];
                String especie1 = winner1[2];
                String pos1 = winner1[3];



                String nome2 = winner2[1];
                String especie2 = winner2[2];
                String pos2 = winner2[3];

                String nome3 = winner3[1];
                String especie3 = winner3[2];
                String pos3 = winner3[3];

                String nome4 = winner4[1];
                String especie4 = winner4[2];
                String pos4 = winner4[3];

                String lugar1 = "#1 " + nome1 + ", " + especie1 + ", " + pos1 + "\n" + "#2 " + nome2 + ", " + especie2 + ", " + pos2
                        + "\n" + "#3 " + nome3 + ", " + especie3 + ", " + pos3 + "\n" + "#4 " + nome4 + ", " + especie4 + ", " + pos4;

                p.add(lugar1);

            }

            return p;
        }

        public JPanel getAuthorsPanel () {

            return null;
        }


        public String whoIsTaborda () {

            return "professional wrestling";
        }

    }