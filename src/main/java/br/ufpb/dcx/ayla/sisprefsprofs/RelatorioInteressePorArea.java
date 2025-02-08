package br.ufpb.dcx.ayla.sisprefsprofs;

import java.util.ArrayList;
import java.util.Collection;

public class RelatorioInteressePorArea {
    private Area area;

    Collection<Professor> interessados;

    public RelatorioInteressePorArea(Area area){
        this.area = area;
        this.interessados = new ArrayList<>();
    }

    public void adicionaProfessor(Professor prof){
        this.interessados.add(prof);
    }

    public Collection<Professor> getInteressados(){
        return this.interessados;
    }
}
