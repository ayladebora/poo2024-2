package br.ufpb.dcx.ayla.sisprof;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {
    private String nome;
    private int codigo;
    private List<Horario> horarios;
    private int matriculaProf;

    public Disciplina(String nome, int codigo, int matriculaProf, List<Horario> horarios){
        this.nome = nome;
        this.codigo = codigo;
        this.matriculaProf = matriculaProf;
        this.horarios = horarios;
    }

    public String getNome() {
        return this.nome;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public List<Horario> getHorarios() {
        return this.horarios;
    }

    public int getMatriculaProfessor() {
        return this.matriculaProf;
    }
}
