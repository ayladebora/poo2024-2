package br.ufpb.dcx.ayla.sisprof;

public class Professor {
    private String nome;
    private int matricula;

    public Professor(String nome, int matricula){
        this.nome = nome;
        this.matricula = matricula;
    }

    public int getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }
}
