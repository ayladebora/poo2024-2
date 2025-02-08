package br.ufpb.dcx.ayla.sisprof;

public class DisciplinaJaExisteException extends Exception {

    public DisciplinaJaExisteException(){
        super("Disciplina já existe!");
    }
    public DisciplinaJaExisteException(String msg){
        super (msg);
    }

}
