package br.ufpb.dcx.ayla.sisprefsprofs;

import br.ufpb.dcx.ayla.sisprof.ProfessorInexistenteException;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collection;


public class RelatorioInteressePorDisciplina {
    private Disciplina disciplina;

    private Map<NivelInteresse, Collection<Professor>> professoresPorNivel;

    public RelatorioInteressePorDisciplina(Disciplina disciplina){
        this.disciplina = disciplina;
        this.professoresPorNivel = new HashMap<>();
        this.professoresPorNivel.put(NivelInteresse.P1, new ArrayList<>());
        this.professoresPorNivel.put(NivelInteresse.P2, new ArrayList<>());
        this.professoresPorNivel.put(NivelInteresse.P3, new ArrayList<>());
        this.professoresPorNivel.put(NivelInteresse.NP, new ArrayList<>());
    }

    public void cadastraInteresseDeProfessor(Professor professor, NivelInteresse nivel){
        this.professoresPorNivel.get(nivel).add(professor);
    }

    public Disciplina getDisciplina(){
        return this.disciplina;
    }

    public Collection<Professor> getProfessoresInteressadosComNivel(NivelInteresse nivel){
        return this.professoresPorNivel.get(nivel);
    }

    public NivelInteresse getInteresseDoProfessor(Professor prof) throws ProfessorInexistenteException {
        if (this.professoresPorNivel.get(NivelInteresse.P1).contains(prof)){
            return NivelInteresse.P1;
        } else if (this.professoresPorNivel.get(NivelInteresse.P2).contains(prof)){
            return NivelInteresse.P2;
        } else if (this.professoresPorNivel.get(NivelInteresse.P3).contains(prof)){
            return NivelInteresse.P3;
        } else if (this.professoresPorNivel.get(NivelInteresse.NP).contains(prof)){
            return NivelInteresse.NP;
        } else {
            throw new ProfessorInexistenteException("Não existe cadastro de interesse do professor "+prof.getNome());
        }
    }
}
