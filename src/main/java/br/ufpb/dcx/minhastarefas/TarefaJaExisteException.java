package br.ufpb.dcx.minhastarefas;

public class TarefaJaExisteException extends Exception {

    public TarefaJaExisteException(String msg){
        super(msg);
    }
}
