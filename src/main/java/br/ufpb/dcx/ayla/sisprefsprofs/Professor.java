package br.ufpb.dcx.ayla.sisprefsprofs;

import java.util.Objects;

public class Professor {
    private String matriculaProf;
    private String nomeProf;

    public Professor(String matriculaProf, String nomeProf){
        this.matriculaProf = matriculaProf;
        this.nomeProf = nomeProf;
    }

    public String getMatricula(){
        return this.matriculaProf;
    }

    public String getNome(){
        return this.nomeProf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Professor professor = (Professor) o;
        return Objects.equals(matriculaProf, professor.matriculaProf);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(matriculaProf);
    }
}
