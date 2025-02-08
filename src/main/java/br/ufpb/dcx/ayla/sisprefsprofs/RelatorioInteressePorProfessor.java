package br.ufpb.dcx.ayla.sisprefsprofs;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class RelatorioInteressePorProfessor {
    private Professor professor;
    private Collection<Area> areasDeInteresse;
    private Map<NivelInteresse, Collection<Disciplina>> interessePorNivel;

    public RelatorioInteressePorProfessor(Professor professor){
        this.professor = professor;
        this.areasDeInteresse = new ArrayList<>();
        this.interessePorNivel = new HashMap<>();
    }

    public void adicionarAreaDeInteresse(Area area){
        this.areasDeInteresse.add(area);
    }

    public Collection<Area> getAreasDeInteresse(){
        return this.areasDeInteresse;
    }

    public Collection<Disciplina> getDisciplinasPorNivel(NivelInteresse nivel){
        return this.interessePorNivel.get(nivel);
    }

    public void configurarNivelDeInteresseEmDisciplina(Disciplina disciplina, NivelInteresse nivel){
        this.interessePorNivel.get(nivel).add(disciplina);
    }
}
