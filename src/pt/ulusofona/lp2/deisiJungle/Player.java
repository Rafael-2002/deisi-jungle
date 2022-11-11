package pt.ulusofona.lp2.deisiJungle;

import java.util.HashMap;

public class Player {

    String nome;
    String id;
    String especie;
    int energia;
    int pos;


    public Player(String id, String nome, String especie, int energia,int pos){
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        this.energia = energia;
        this.pos = pos;
    }

    public Player(String id, String nome, String especie, int energia){
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        this.energia = energia;
    }
}
