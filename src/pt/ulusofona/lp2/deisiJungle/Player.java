package pt.ulusofona.lp2.deisiJungle;

public class Player {

    int id;
    String nome;
    String especie;
    int energia;
    int pos;


    public Player(int id, String nome, String especie, int energia, int pos){
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        this.energia = energia;
        this.pos = pos;
    }

    public Player(int id, String nome, String especie, int energia){
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        this.energia = energia;
    }
}
