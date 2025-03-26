package br.ufpb.dcx.minhastarefas;

public class TarefaNaoExisteException extends Exception{

    public TarefaNaoExisteException(String msg){
        super(msg);
    }
}
