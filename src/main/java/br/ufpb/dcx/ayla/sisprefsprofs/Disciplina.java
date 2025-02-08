package br.ufpb.dcx.ayla.sisprefsprofs;

public class Disciplina {
    private String codDisciplina;
    private String nomeDisciplina;

    public Disciplina(String codDisciplina, String nomeDisciplina){
        this.codDisciplina = codDisciplina;
        this.nomeDisciplina = nomeDisciplina;
    }

    public String getCodigo(){
        return this.codDisciplina;
    }

    public String getNome(){
        return this.nomeDisciplina;
    }
}
