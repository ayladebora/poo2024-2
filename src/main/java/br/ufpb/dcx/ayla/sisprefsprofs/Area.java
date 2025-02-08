package br.ufpb.dcx.ayla.sisprefsprofs;

public class Area {
    String codArea;
    String nomeArea;

    public Area(String codArea, String nomeArea){
        this.codArea = codArea;
        this.nomeArea = nomeArea;
    }

    public String getCodigo(){
        return this.codArea;
    }

    public String getNome(){
        return this.nomeArea;
    }

}
